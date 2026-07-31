public class Main {
    public static void main (String[] args) {
        Loja loja = new Loja("Loja POO");
        Cliente cliente = new Cliente("Ana Silva", "111.111.111-11", 101);
        Funcionario funcionario = new Funcionario("Carlos Souza", "222.222.222-22", 501, 2500.00);
        Produto teclado = new Produto(1, "Teclado", 150.00, 10);
        Produto mouse = new Produto(2, "Mouse", 80.00, 15);
        Produto monitor = new Produto(3, "Monitor", 900.00, 5);
        loja.cadastrarPessoa(cliente);
        loja.cadastrarPessoa(funcionario);
        loja.cadastrarProduto(teclado);
        loja.cadastrarProduto(mouse);
        loja.cadastrarProduto(monitor);
        funcionario.aumentarSalario(10);
        Pedido pedido = new Pedido(1001, cliente);
        pedido.adicionarProduto(teclado, 2);
        pedido.adicionarProduto(mouse);
        pedido.adicionarProduto(monitor, 1);
        Produto encontrado = pedido.buscarProduto(2);

        System.out.println("PRODUTO ENCONTRADO");
        System.out.println(encontrado);
        System.out.println("\nDADOS DO PEDIDO");
        System.out.println(pedido);
        System.out.println("\nPESSOAS CADASTRADAS");
        loja.listarPessoas();
        System.out.println("\nPRODUTOS CADASTRADOS");
        loja.listarProdutos();
        Pessoa pessoaEncontrada =
                loja.buscarPessoa("222.222.222-22");
        System.out.println("\nPESSOA ENCONTRADA");
        System.out.println(pessoaEncontrada);


    }
}








