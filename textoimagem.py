"""
image_to_text_gui.py
Interface gráfica para converter imagens em texto usando Claude Vision.

Instalação:
    pip install anthropic pillow

Uso:
    python image_to_text_gui.py

Como usar:
    1. Copie qualquer imagem (print, screenshot, foto, etc.)
    2. Cole com Ctrl+V na janela
    3. O texto é extraído automaticamente
"""

import base64
import os
import threading
import tkinter as tk
from io import BytesIO
from tkinter import font as tkfont
from tkinter import messagebox, scrolledtext

from PIL import Image, ImageGrab, ImageTk

# ── Configuração ──────────────────────────────────────────
API_KEY = os.getenv("ANTHROPIC_API_KEY", "")   # ou cole sua chave aqui
MODEL   = "claude-opus-4-5"
# ──────────────────────────────────────────────────────────


def image_to_base64(img: Image.Image) -> tuple[str, str]:
    """Converte PIL Image para base64 + media_type."""
    buf = BytesIO()
    img.save(buf, format="PNG")
    return base64.standard_b64encode(buf.getvalue()).decode(), "image/png"


def extract_text_claude(img: Image.Image) -> str:
    """Envia a imagem para o Claude Vision e retorna o texto extraído."""
    try:
        import anthropic
    except ImportError:
        raise ImportError("Execute: pip install anthropic")

    b64, media_type = image_to_base64(img)

    client = anthropic.Anthropic(api_key=API_KEY)
    message = client.messages.create(
        model=MODEL,
        max_tokens=4096,
        messages=[{
            "role": "user",
            "content": [
                {
                    "type": "image",
                    "source": {
                        "type": "base64",
                        "media_type": media_type,
                        "data": b64,
                    },
                },
                {
                    "type": "text",
                    "text": (
                        "Extraia TODO o texto presente nesta imagem. "
                        "Preserve a formatação original (parágrafos, listas, tabelas). "
                        "Retorne apenas o texto extraído, sem comentários adicionais."
                    ),
                },
            ],
        }],
    )
    return message.content[0].text.strip()


# ── Interface gráfica ─────────────────────────────────────

class App(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Imagem → Texto  (Ctrl+V para colar)")
        self.geometry("720x680")
        self.minsize(560, 500)
        self.configure(bg="#F5F5F3")
        self.resizable(True, True)

        self._current_image: Image.Image | None = None
        self._photo: ImageTk.PhotoImage | None = None

        self._build_ui()
        self._bind_keys()
        self._check_api_key()

    # ── Layout ────────────────────────────────────────────

    def _build_ui(self):
        PAD = 16
        BG  = "#F5F5F3"
        CARD = "#FFFFFF"
        BORDER = "#E0DED8"
        BLUE   = "#2563EB"
        BLUE_H = "#1D4ED8"

        # Título
        header = tk.Frame(self, bg=BG, pady=PAD)
        header.pack(fill="x", padx=PAD)
        tk.Label(header, text="Imagem → Texto", bg=BG,
                 font=("Segoe UI", 17, "bold"), fg="#1A1A1A").pack(side="left")
        self._status_lbl = tk.Label(header, text="", bg=BG,
                                    font=("Segoe UI", 11), fg="#6B7280")
        self._status_lbl.pack(side="right")

        # Área de drop / preview
        self._drop_frame = tk.Frame(self, bg=CARD, bd=0,
                                    highlightbackground=BORDER,
                                    highlightthickness=1)
        self._drop_frame.pack(fill="x", padx=PAD, pady=(0, PAD))

        self._hint_lbl = tk.Label(
            self._drop_frame,
            text="📋  Cole uma imagem com  Ctrl+V",
            bg=CARD, fg="#9CA3AF",
            font=("Segoe UI", 13),
            pady=40,
        )
        self._hint_lbl.pack(fill="x")

        self._img_lbl = tk.Label(self._drop_frame, bg=CARD, cursor="arrow")
        # (oculto até ter imagem)

        # Botões
        btn_row = tk.Frame(self, bg=BG)
        btn_row.pack(fill="x", padx=PAD, pady=(0, PAD))

        self._extract_btn = tk.Button(
            btn_row, text="Extrair texto",
            command=self._start_extraction,
            bg=BLUE, fg="white",
            activebackground=BLUE_H, activeforeground="white",
            font=("Segoe UI", 12, "bold"),
            relief="flat", cursor="hand2",
            padx=20, pady=8,
            state="disabled",
        )
        self._extract_btn.pack(side="left")

        self._clear_btn = tk.Button(
            btn_row, text="Limpar",
            command=self._clear,
            bg=CARD, fg="#374151",
            activebackground="#F3F4F6",
            font=("Segoe UI", 12),
            relief="flat", cursor="hand2",
            padx=16, pady=8,
            highlightbackground=BORDER, highlightthickness=1,
            state="disabled",
        )
        self._clear_btn.pack(side="left", padx=(8, 0))

        self._copy_btn = tk.Button(
            btn_row, text="Copiar texto",
            command=self._copy_text,
            bg=CARD, fg="#374151",
            activebackground="#F3F4F6",
            font=("Segoe UI", 12),
            relief="flat", cursor="hand2",
            padx=16, pady=8,
            highlightbackground=BORDER, highlightthickness=1,
            state="disabled",
        )
        self._copy_btn.pack(side="right")

        # Área de resultado
        result_card = tk.Frame(self, bg=CARD, bd=0,
                               highlightbackground=BORDER, highlightthickness=1)
        result_card.pack(fill="both", expand=True, padx=PAD, pady=(0, PAD))

        tk.Label(result_card, text="Texto extraído", bg=CARD,
                 font=("Segoe UI", 11, "bold"), fg="#374151",
                 anchor="w", padx=12, pady=8).pack(fill="x")

        sep = tk.Frame(result_card, bg=BORDER, height=1)
        sep.pack(fill="x")

        self._result_txt = scrolledtext.ScrolledText(
            result_card,
            font=("Segoe UI", 12),
            bg=CARD, fg="#111827",
            relief="flat",
            wrap="word",
            padx=12, pady=10,
            state="disabled",
        )
        self._result_txt.pack(fill="both", expand=True)

    # ── Bindings ──────────────────────────────────────────

    def _bind_keys(self):
        self.bind("<Control-v>", self._on_paste)
        self.bind("<Control-V>", self._on_paste)

    # ── Lógica ────────────────────────────────────────────

    def _check_api_key(self):
        if not API_KEY:
            messagebox.showwarning(
                "Chave da API não configurada",
                "Defina a variável de ambiente ANTHROPIC_API_KEY\n"
                "ou edite a variável API_KEY no topo do script.",
            )

    def _on_paste(self, _event=None):
        """Captura imagem do clipboard via Ctrl+V."""
        try:
            img = ImageGrab.grabclipboard()
        except Exception:
            img = None

        if isinstance(img, Image.Image):
            self._load_image(img)
        elif isinstance(img, list) and img:
            # Windows pode retornar lista de caminhos
            try:
                self._load_image(Image.open(img[0]))
            except Exception:
                self._set_status("Não foi possível abrir o arquivo colado.")
        else:
            self._set_status("Nenhuma imagem encontrada no clipboard.")

    def _load_image(self, img: Image.Image):
        self._current_image = img.copy()
        self._show_preview(img)
        self._set_status("Imagem pronta.")
        self._extract_btn.config(state="normal")
        self._clear_btn.config(state="normal")
        self._copy_btn.config(state="disabled")
        self._set_result("")

    def _show_preview(self, img: Image.Image):
        """Exibe thumbnail da imagem na área de preview."""
        self._hint_lbl.pack_forget()
        max_w, max_h = 680, 220
        img.thumbnail((max_w, max_h), Image.LANCZOS)
        self._photo = ImageTk.PhotoImage(img)
        self._img_lbl.configure(image=self._photo)
        self._img_lbl.pack(pady=8)

    def _clear(self):
        self._current_image = None
        self._photo = None
        self._img_lbl.pack_forget()
        self._img_lbl.configure(image="")
        self._hint_lbl.pack(fill="x")
        self._extract_btn.config(state="disabled")
        self._clear_btn.config(state="disabled")
        self._copy_btn.config(state="disabled")
        self._set_result("")
        self._set_status("")

    def _start_extraction(self):
        if not self._current_image:
            return
        if not API_KEY:
            messagebox.showerror("API Key ausente",
                                 "Configure ANTHROPIC_API_KEY antes de extrair.")
            return
        self._extract_btn.config(state="disabled", text="Extraindo…")
        self._set_status("Enviando para o Claude Vision…")
        self._set_result("")
        thread = threading.Thread(target=self._run_extraction, daemon=True)
        thread.start()

    def _run_extraction(self):
        try:
            text = extract_text_claude(self._current_image)
            self.after(0, self._on_success, text)
        except Exception as exc:
            self.after(0, self._on_error, str(exc))

    def _on_success(self, text: str):
        self._set_result(text)
        self._set_status("Concluído.")
        self._extract_btn.config(state="normal", text="Extrair texto")
        self._copy_btn.config(state="normal")

    def _on_error(self, msg: str):
        self._set_status(f"Erro: {msg}")
        self._extract_btn.config(state="normal", text="Extrair texto")
        messagebox.showerror("Erro na extração", msg)

    def _set_status(self, msg: str):
        self._status_lbl.config(text=msg)

    def _set_result(self, text: str):
        self._result_txt.config(state="normal")
        self._result_txt.delete("1.0", "end")
        if text:
            self._result_txt.insert("1.0", text)
        self._result_txt.config(state="disabled")

    def _copy_text(self):
        text = self._result_txt.get("1.0", "end-1c")
        if text:
            self.clipboard_clear()
            self.clipboard_append(text)
            self._copy_btn.config(text="Copiado!")
            self.after(1500, lambda: self._copy_btn.config(text="Copiar texto"))


# ── Entry point ───────────────────────────────────────────

if __name__ == "__main__":
    app = App()
    app.mainloop()