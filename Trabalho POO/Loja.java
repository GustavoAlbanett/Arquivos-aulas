class Loja{
    private String nome;
    private Produto[] produtos = new Produto[0];
    private Pessoa[] pessoas = new Pessoa[0];
    private int quantidadeProdutos;
    private int quantidadePessoas;

    Loja(String nome){
        this.nome = nome;
    }

    boolean cadastrarProduto(Produto produto){
        Produto[] prods = new Produto[this.produtos.length + 1];

        for(int i = 0; i < this.produtos.length; i++){
            prods[i] = this.produtos[i];
        }
        prods[prods.length-1] = produto;

        this.produtos = prods;
        this.quantidadeProdutos++;
        return true;
    }


    boolean cadastrarPessoa(Pessoa pessoa){
        Pessoa[] pess = new Pessoa[this.pessoas.length +1];

        for(int i = 0; i < this.pessoas.length; i++){
            pess[i] = this.pessoas[i];
        }
        pess[pess.length-1] = pessoa;

        this.pessoas = pess;
        this.quantidadePessoas++;
        return true;
    }

    Produto buscarProduto(int codigo){
        for (Produto produto : this.produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        Produto produ = new Produto(-1, "Não encontrado produto", 0.0, 0);
        return produ;
    }

    Pessoa buscarPessoa(String cpf){
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getCpf() == cpf) {
                return pessoa;
            }
        }
        Pessoa pesso = new Pessoa("Não encontrada pessoa", "0000");
        return pesso;
    }

    void listarProdutos(){
        for(int i = 0; i < this.produtos.length ; i++){
            System.out.print(this.produtos[i]);
        }
    }

    void listarPessoas(){
        for(int i = 0; i < this.pessoas.length ; i++){
            System.out.print(this.pessoas[i]);
        }
    }



}