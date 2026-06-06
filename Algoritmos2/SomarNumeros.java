import javax.swing.JOptionPane;

public class SomarNumeros{
	public static void main(String args[]){
	somar(10,20);
	int resultado = somar(10,20,30);
	System.out.println(resultado);

	//String nome = JOptionPane.showInputDialog("Informe seu nome");

	String num1S = JOptionPane.showInputDialog("Informe os números: ");
	int num1 = Integer.parseInt(num1S);

	String num2S = JOptionPane.showInputDialog("Informe os números: ");
	int num2 = Integer.parseInt(num2S);

	String num3S = JOptionPane.showInputDialog("Informe os números: ");
	int num3 = Integer.parseInt(num3S);
	System.out.println(media(num1, num2, num3));
	
	}
	
	// public static INT -> quer dizer que vai RETORNAR um INT
	public static int media(int num1, int num2, int num3){
	return (num1 + num2 + num3) / 3;

	}

	private static void somar(int num1,int num2){
	System.out.println(num1+num2);
	}

	private static int somar(int num1, int num2, int num3){
	return num1 + num2 + num3;
	}
}