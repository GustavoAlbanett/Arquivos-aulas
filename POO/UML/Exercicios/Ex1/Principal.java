// considerar estudante com sendo sub-classe de pessoa
// considerar pessoa com nome e idade
// considerar estudante com matricula
public class Principal {
    public static void main(String[] args) {
		Estudante[] estudantes = null;
		estudantes = carregar_lista_estudantes();
		for( int i=0; i<estudantes.length; i++ ) {
			Estudante est = estudantes[i];
			System.out.println(est);
		}
	}
	
	public static Estudante[] carregar_lista_estudantes(){
		Estudante[] estudantes = new Estudante[3];
		estudantes[0] = new Estudante("Gustavo", 19, "001");
		estudantes[1] = new Estudante("Arthur", 18, "002");
		estudantes[2] = new Estudante("Nicolas", 17, "003");
		return estudantes;
	}
}

class Pessoa{
	int idade;
	String nome;
	
	Pessoa(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}
	
}

class Estudante extends Pessoa{
	String matricula;
	
	
	Estudante(String nome, int idade, String matricula){
		super(nome, idade);
		this.matricula = matricula;
	}
	@Override
	public String toString(){
		return "O aluno " + nome + " tem " + idade + " anos e tem a matricula " + matricula;
	}
}

// implementar classe Pessoa e Estudante
// implementar a função carregar_lista_estudantes()
// Faça o desenho do vetor de estudantes, considerando Ana; Bob; Carl
// Faça uma imagem que exemplifique a estrutura do programa
// onde o override está sendo utilizado? Explique.
// gere a sequência de linhas executadas do seu codigo