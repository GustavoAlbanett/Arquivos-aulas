import java.util.Scanner;

public class Aula2{
	public static void main(String [] main){
		Scanner teclado = new Scanner(System.in);
		System.out.println("1. Real -> Dollar; 2. Dollar --> Real");
		int opc = teclado.nextInt();
		System.out.print("Valor: ");
		double valor = teclado.nextDouble();
		double resultado = 0;
		if(opc == 1){
			resultado = valor/5;
			System.out.print("O valor convertido é: $" + resultado);
		}
		else if(opc == 2){
			resultado = valor * 5;
			System.out.print("O valor convertido é: R$" + resultado);
		}
		else{
			System.out.print("Valor inválido");
		}
	
	}	


}