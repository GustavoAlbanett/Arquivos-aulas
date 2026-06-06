package aula;

public class Teste {
	public static void main(String[] args) {
	int[] vetor = {2, 5, 1, 9, 3};
	Codigo maior = new Codigo();
	
	System.out.println("O maior número esta no indice: " + maior.encontrarMaior(vetor));
	System.out.println("A maior soma consecutiva é: " + maior.somaMaior(vetor));
	}
	
}

class Codigo{
	int encontrarMaior(int[] vet) {
		int maior = vet[0];
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] > maior) {
					maior = i;
			}
		
			}
		 
		return maior;
	}

	int somaMaior(int[] vet) {
		int maior = vet[0] + vet[1];
		for(int i = 0; i < vet.length - 1; i++) {
			if(vet[i] + vet[i +1] > maior) {
				maior = vet[i] + vet[i +1]; 
			}
		}
		return maior;
	}
}
