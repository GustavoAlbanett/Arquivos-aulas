


class Pessoa {
	String nome;
	int idade;
	Livro possui;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public void adquirirLivro(Livro umLivro) {
		this.possui = umLivro;
		umLivro.tenhoPosse(this);
	}
	
	public String toString() {
		String str = "Pessoa: ";
		str += this.nome;
		str += " - possui: " + possui.nome;
		return str;
	}
}

class Livro {
	String nome;
	Pessoa posseDeAlguem;

	public Livro(String nome) {
		this.nome = nome;
	}
	
	public void tenhoPosse(Pessoa p) {
		this.posseDeAlguem = p;
	}
	
}

public class Bidirecional {

	public static void main(String[] args) {
		Pessoa p = new Pessoa("Aaron", 33);
		Livro li = new Livro("CLT");
		p.adquirirLivro(li);
		System.out.println(p);
	}
}
// Tracing
// 43 - 44 - 9 - 10 - 11 - 45 - 31 - 32 - 46 - 14 - 15 - 16 - 35 - 36 - 47