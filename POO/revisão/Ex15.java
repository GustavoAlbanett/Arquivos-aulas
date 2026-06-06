public class Ex15{
	public static void main(String[] args){
	
	Pessoa pessoas[] = 	new Pessoa[10];
	pessoas[0] = new Pessoa("gu", 10); 
	pessoas[1] = new Pessoa("pedro", 11); 
	pessoas[2] = new Pessoa("joao", 20); 
	pessoas[3] = new Pessoa("robert", 30); 
	pessoas[4] = new Pessoa("cadu", 9);
	pessoas[5] = new Pessoa("james", 25);
	pessoas[6] = new Pessoa("bradock", 13);
	pessoas[7] = new Pessoa("coringo", 17);
	pessoas[8] = new Pessoa("babi", 1);
	pessoas[9] = new Pessoa("thurzin", 28);

	System.out.println(maisVelha(pessoas));
	System.out.println(maisNova(pessoas));
	System.out.println(mediaIdades(pessoas));
	System.out.println(pessoasMaior18(pessoas));
	}
	
	static String maisVelha(Pessoa[] pessoas){
		Pessoa maior = null;
		for(int i = 0; i < pessoas.length; i++){
			if(maior == null || maior.idade < pessoas[i].idade) maior = pessoas[i];
		} 
		return maior.nome;
	}	 
	
	static String maisNova(Pessoa[] pessoas){
		Pessoa menor = null;
		for(int i = 0; i < pessoas.length; i++){
			if(menor == null || menor.idade < pessoas[i].idade) menor = pessoas[i];
		} 
		return menor.nome;
	}	 	

	static double mediaIdades(Pessoa[] pessoas){
		int media = 0;
		for(int i = 0; i < pessoas.length; i++){
			media += pessoas[i].idade;
		} 
		return media / pessoas.length;
	}	

	static int pessoasMaior18(Pessoa[] pessoas){
		int num = 0;
		for(int i =0; i < pessoas.length; i++){
			if( pessoas[i].idade > 18) num++;
		}
		return num;
	}
}
class Pessoa{
	String nome;
	int idade;
	
	Pessoa(String n, int num){
		this.nome = n;
		this.idade = num;
	}

}