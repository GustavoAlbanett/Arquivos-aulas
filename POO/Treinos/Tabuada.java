import java.util.Scanner;
public class Tabuada{

	public static void main(String args[]){
		System.out.print("Digite o núnero da tabuada: ");
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();
		for(int i = 1; i <= 10; i++){
			System.out.println(i + " X " + num + "= " + num * i);
		}


	}




}