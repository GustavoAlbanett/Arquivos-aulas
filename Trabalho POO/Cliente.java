class Cliente extends Pessoa {
    private int codigo;

    public Cliente(String nome, String cpf, int codigo) {
        super(nome, cpf);
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    @Override
    public String toString() {
        return "Nome: " + getNome() +
                " | CPF: " + getCpf() +
                " | Código: " + codigo + "\n";
    }
}