public class Questoes{
	public static void main(String[] args){
		Pessoa eu = new Pessoa("Gustavo", 19);
		eu.mostrarDados();
	}
}
//Q1
class Pessoa{
	String nome;
	String cpf;
	
	Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	void mostrarDados(){
		System.out.println(this);
	}
	
	String getNome(){
		return this.nome;
	}
	
	String getCPF(){
		return this.cpf;
	}
	@Override
	public String toString(){
		return nome + " " + cpf;
	}
}

class Usuario extends Pessoa{
	String numCadastro;
	
	Usuario(String num, String nome, String cpf){
		super(String nome, String cpf);
		this.numCadastro = num;
	}
	
	void mostrarDados(){
		System.out.println(this);
	}
	
	@Override
	public String toString(){
		return this.nome + " " + this.cpf + " " + this.numCadastro;
	}
}

class Funcionario extends Pessoa{
	String cargo;
	
	Funcionario(String cargo, String nome, String cpf){
		super(String nome, String cpf);
		this.cargo = cargo;
	}
	void mostrarDados(){
		System.out.println(this);
	}
	@Override
	public String toString(){
		return this.nome + " " + this.cpf + " " + this.cargo;
	}
}

class Biblioteca{
	Livro[] livros;
	Usuario[] users;
	Funcionario[] funcionarios;
	Emprestimo[] esmprestimos;
	
	Biblioteca(){
		
	}
}

class Emprestimo {
	Usuario user;
	Livro livro;
	Funcionario funcionario;
	
	void mostrarDados(){
		System.out.println(this);
	}
	@Override
	public String toString(){
		return this.nome + " " + this.cpf + " " + this.numCadastro;
	}
}

class Livro{
	String titulo;
	String autor;
	boolean disponivel;
	
	Livro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
	}
	
	boolean isDisponivel(){
		return this.disponivel;
	}
	
	String getTitulo(){
		return this;titulo;
	}
	
	
	void mostrarDados(){
		System.out.println(this);
	}
	
	void emprestar(){
		this.disponivel = false;
	}
	
	void devolver(){
		this.disponivel = true;
	}
	
	@Override
	public String toString(){
		return this.titulo + " " + this.autor;
	}
}








//Q2
class Produto{
	String nome;
	double preco;
	int qtd;
	
	Produto(String nome, double preco, int qtd){
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	void mostrarProduto(){
		System.out.println(nome + " " + preco + " " + qtd);
	}
	
	double calcularValorTotal(){
		return (preco * qtd);
	}
}

