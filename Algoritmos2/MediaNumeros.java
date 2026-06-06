import javax.swing.JOptionPane;

public class MediaNumeros{

	public static void main(String args[]){

		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vet: "));
		int numeros[] = new int[qtd];

		System.out.println(media(preenchernumero(numeros)));
		mostrar(numeros);

		
	}
	

	public static int[] preenchernumero(int num[]){

		for(int i = 0; i < num.length; i++){
			num[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o "+ (i+1) + "º número: "));
		}
		return num;
	}


	public static void mostrar(int num[]){
		for(int i = 0; i < num.length; i++){

			System.out.println("número" + (i+1) + " = " + num[i]);
		}
	}
	

	public static int media(int num[]){
		int soma = 0;
		for(int i = 0; i < num.length; i++){
			soma += num[i];
		}
		return (soma / num.length);
	
	}
}