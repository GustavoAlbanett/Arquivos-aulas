class ItemPedido{
    private Produto produto;
    private int quantidade;

    ItemPedido(Produto produto, int quantidade){
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Produto getProduto(){
        return this.produto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double calcularSubtotal(){
        return quantidade * produto.getPreco();
    }
}