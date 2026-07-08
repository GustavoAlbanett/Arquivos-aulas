public class Questoes{
	public static void main(String[] args){
		Usuario user = new Usuario("0001", "Gustavo", "1342424-01");
		Funcionario func = new Funcionario("Atendente", "Tavips", "1231231312-42");
		Livro livro = new Livro("memorias postumas", "Machado de Assis");
		Biblioteca bib = new Biblioteca();
		
		bib.adicionarLivro(livro);
		bib.adicionarFuncionario(func);
		bib.adicionarUsuario(user);
		bib.realizarEmprestimo(user, livro, func);
		bib.mostrarLivros();
		bib.mostrarEmprestimo();
	}
}
// Q24
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
		super( nome, cpf);
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
		super(nome, cpf);
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
	Livro[] livros = new Livro[3];
	Usuario[] users = new Usuario[3];
	Funcionario[] funcionarios = new Funcionario[3];
	Emprestimo[] emprestimos = new Emprestimo[3];
	
	int qtdLivro = 0;
	int qtdUsers = 0;
	int qtdFuncionarios = 0;
	int qtdEmprestimos = 0;
	
	void adicionarLivro(Livro livro){
		this.livros[qtdLivro] = livro;
		qtdLivro++;
	}
	void adicionarUsuario(Usuario user){
		this.users[qtdUsers] = user;
		qtdUsers++;
	}
	void adicionarFuncionario(Funcionario funcionario){
		this.funcionarios[qtdFuncionarios] = funcionario;
		qtdFuncionarios++;
	}
	void realizarEmprestimo(Usuario user, Livro livro, Funcionario funcionario){
		if(livro.isDisponivel()){
			this.emprestimos[qtdEmprestimos] = new Emprestimo(user, livro, funcionario);
			qtdEmprestimos++;
			livro.emprestar();
		}else{
			System.out.println("livro indisponível");
		}
	}
	void mostrarLivros(){
		for(int i = 0; i < this.qtdLivro; i++){
			livros[i].mostrarDados();
		}
	}
	void mostrarEmprestimo(){
		for(int i = 0; i < this.qtdEmprestimos; i++){
			emprestimos[i].mostrarDados();
		}
	}
}

class Emprestimo {
	Usuario user;
	Livro livro;
	Funcionario funcionario;
	
	Emprestimo(Usuario user, Livro livro, Funcionario funcionario){
		this.user = user;
		this.livro = livro;
		this.funcionario = funcionario;
	}
	
	void mostrarDados(){
		System.out.println(this);
	}
	@Override
	public String toString(){
		return this.user + " " + this.livro + " " + this.funcionario;
	}
}

class Livro{
	String titulo;
	String autor;
	boolean disponivel = true;
	
	Livro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
	}
	
	boolean isDisponivel(){
		return this.disponivel;
	}
	
	String getTitulo(){
		return this.titulo;
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

