import java.util.Random;
import javax.swing.JOptionPane;

public class Teste{
	public static void main(String args[]){
		Random random = new Random();
		System.out.println(random.nextInt(11));
		
		String texto = "Exemplo";
		
		Soletra(texto);
		
		String txt = JOptionPane.showInputDialog("a\n a\n a");
	}
	
	public static void Soletra(String texto){

		String[] letras = texto.split("");

		for (String letra : letras) {
			System.out.println(letra);
		}
	}
	
	
}