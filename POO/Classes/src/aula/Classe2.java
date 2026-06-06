
package Aula4;


class Pessoa2 {
	String nome;
	int idade;
	
	Pessoa2(String n, int id ){
		this.nome = n;
		this.idade = id;
	}
}


public class MaiorPessoa {

	int Pessoa2 maiorIdade( Pessoa2[] pessoas){
		Integer maior = 0;
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].idade > maior) {
				maior = pessoas[i].idade;
			}
		}
		return maior;
	}
	
	public static void main(String[] args) {
		Pessoa2 pessoas[] = new Pessoa2[3];
		pessoas[0] = new Pessoa2("ana", 15);
		pessoas[1] = new Pessoa2("bob", 18);
		pessoas[2] = new Pessoa2("carl", 16);
		
		Pessoa2 result = maiorIdade( pessoas );
		System.out.println("Pessoa com maior idade abaixo");
		System.out.println(result);
	}

}