class Pessoa2 {
	String nome;
	int idade;
	
	Pessoa2(String n, int id ){
		this.nome = n;
		this.idade = id;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}


public class MediaPessoas {

	static double mediaIdade(Pessoa2[] pessoas){
		double media = 0.0;
		
		for(int i = 0; i < pessoas.length; i++){
			media += pessoas[i].idade;
		}
		
		return media / pessoas.length;
		
	}

	static void menorIdadeM(Pessoa2[] pessoas) {
		double media = mediaIdade(pessoas);

		for(int i =0; i < pessoas.length; i++){
			if(pessoas[i].idade < media){
				System.out.println(pessoas[i]);
			}
		}
	}
	
	static Pessoa2 maiorIdade( Pessoa2[] pessoas ) {
		Pessoa2 resposta = pessoas[0];
		
		Pessoa2 tmp;
		for( int i=1; i<pessoas.length; i++) {
			tmp = pessoas[ i ];
			if( tmp.idade > resposta.idade ) {
				resposta = tmp;
			}
		}

		return resposta;
	}
	
	public static void main(String[] args) {
		Pessoa2 pessoas[] = new Pessoa2[4];
		pessoas[0] = new Pessoa2("ana", 50);
		pessoas[1] = new Pessoa2("bob", 15);
		pessoas[2] = new Pessoa2("carl", 22);
		pessoas[3] = new Pessoa2("dann", 11);

 
		//Pessoa2 result = maiorIdade( pessoas );
		//System.out.println("Pessoa com maior idade abaixo");
		// System.out.println(result);
		
		// double result = MediaPessoas(pessoas);
		// System.out.println(result);
		menorIdadeM(pessoas);
	}
// 44, 45, 46, 5, 6, 7,46, 47, 5, 6, 7, 47, 48 5, 6, 7, 48, 49, 5, 6, 7, 49, 55, 19, 20, 22, 23, 22, 23, 22, 23, 22, 23, 24, 26, 56,
}