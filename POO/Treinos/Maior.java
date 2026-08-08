import java.util.Scanner;

public class Maior{


	public static void main(String args[]){
	
		Scanner teclado = new Scanner(System.in);
		Integer menor = null;
		Integer maior = null;
		
		for(int i = 0; i < 5; i++){
			System.out.print("Digite um número: ");
			Integer valor = teclado.nextInt();
			if(maior == null || maior <= valor){
				maior = valor;
			}
			if(menor == null || menor >= valor){
				menor = valor;
			}
		}
		System.out.println("O maior número é: " + maior);
		System.out.println("O menor número é: " + menor);
	}
}

