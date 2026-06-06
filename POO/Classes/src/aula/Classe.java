package aula;


class Pessoa {
	// atributos
	String nome;
	
	String nasc;
	

	// construtor
	Pessoa(String n){
		System.out.println("criando: "+n);
		this.nome = n;
	}
	
	Pessoa(String no, String na){
		this.nome = no;
		this.nasc = na;
	}
	
	// metodos
	void andar(){
		System.out.println("estou andando..");
	}
	
	void falar() {
		System.out.println("meu nome é: " + this.nome);
	}
	
	@Override
	public String toString() {
		String tmp = "pessoa: " + this.nome;
		return tmp;
	}
}

public class Classe {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("marcelo");
		Pessoa p2 = new Pessoa("joao");
		//p1.falar();
		System.out.println(p1);
	}

}


