class Produto{
    private int codigo;
    private String nome;
    private double preco;
    private int estoque;

    Produto(int codigo, String nome, double preco, int estoque){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    int getCodigo(){
        return this.codigo;
    }

    String getNome(){
        return this.nome;
    }

    double getPreco(){
        return this.preco;
    }

    int getEstoque(){
        return this.estoque;
    }

    void setPreco(double preco){
        this.preco = preco;
    }

    boolean retirarEstoque(int quantidade) {
        if (quantidade > this.estoque || quantidade < 0) return false;
        this.estoque -= quantidade;
        return true;
    }

    @Override
    public String toString(){
        return "Produto: " + this.nome + " | Código: " + this.codigo + " | Preço: " + this.preco + " | Estoque: " + this.estoque + "\n";
    }
}