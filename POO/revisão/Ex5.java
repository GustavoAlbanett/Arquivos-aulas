public class Ex5{
	public static void main(String[] args){
	Aluno[] alunos = {new Aluno("jorge", 9.6), new Aluno("cringa", 5.7), new Aluno("babi", 9.7), new Aluno("thrzin", 8.0), new Aluno("bradock", 4.0)};
	
	System.out.println(maiorNota(alunos));
	}
	
	public static String maiorNota(Aluno[] vet){
		Aluno maior = vet[0];
		
		for(int i = 0; i < vet.length ; i++){
			if(maior.nota < vet[i].nota) maior = vet[i];
		}
		return maior.nome;
	}
}

class Aluno {
	String nome;
	double nota;
	
	Aluno(String n, double num){
	this.nome = n;
	this.nota = num;
	}
}