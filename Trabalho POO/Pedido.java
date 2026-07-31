class Pedido {
    private int numero;
    private Cliente cliente;
    private ItemPedido[] itens = new ItemPedido[10];
    private int quantidadeItens;

    Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public boolean adicionarProduto(Produto produto) {
        for (int i = 0; i < itens.length; i++) {
            if (1 > produto.getEstoque()) {
                System.out.println("Estoque insuficiente");
                return false;
            }
            if (itens[i] == null) {
                itens[i] = new ItemPedido(produto, 1);
                quantidadeItens++;
                itens[i].getProduto().retirarEstoque(1);
                return true;
            }
        }
        return false;
    }

    public boolean adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < itens.length; i++) {
            if (quantidade > produto.getEstoque()) {
                System.out.println("Estoque insuficiente");
                return false;
            }

            if (itens[i] == null) {
                itens[i] = new ItemPedido(produto, quantidade);
                quantidadeItens++;
                itens[i].getProduto().retirarEstoque(quantidade);
                return true;
            }
        }
        return false;
    }

    public Produto buscarProduto(int codigo) {
        for (ItemPedido item : itens) {
            if (item != null && item.getProduto().getCodigo() == codigo) {
                return item.getProduto();
            }
        }
        return null;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            if (item != null) {
                total += item.calcularSubtotal();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "Pedido: " + this.numero + "\nCliente: " + this.cliente.getNome() + "\nItens:";

        for (ItemPedido item : itens) {
            if (item != null) {
                str += "\n" + item.getQuantidade() + " x " + item.getProduto().getNome() + " = R$ " + item.calcularSubtotal();
            }
        }
        str += "\nTotal: R$" + calcularTotal();
        return str;
    }
}
