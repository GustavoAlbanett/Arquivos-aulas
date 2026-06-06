import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Descoberta{
	public static void main(String agrs[]){
		String[] palavras = {
		"Abacaxi",
		"Neblina",
		"Relogio",
		"Montanha",
		"Labirinto",
		"Caneta",
		"Horizonte",
		"Tempestade",
		"Biblioteca",
		"Foguete"};
	
		String palavra = Rand(palavras);
		String[] palavrasplt = palavra.split("");
		
		Embaralhamento(palavrasplt);
		
		Ciclo(palavra, palavrasplt);
	}
	
	public static void Ciclo(String palavra, String[] palavrasplt){
		//Scanner teclado = new Scanner(System.in);
		//System.out.print("\nQual é essa palavra -> " + Palavrajunto(palavrasplt) + " \n 1.Pedir dica \n 2.Desistir \n\n Resposta: ");
		//String resposta = teclado.nextLine();
		
		String resposta = JOptionPane.showInputDialog("\nQual é essa palavra -> " + Palavrajunto(palavrasplt) + " \n 1.Pedir dica \n 2.Desistir \n\n Resposta: ");
		
		while(!resposta.equals("2") && !resposta.equals(palavra)){
			
			if(resposta.equals("1")){
				Dica(palavra);
			}
			resposta = JOptionPane.showInputDialog("\nQual é essa palavra -> " + Palavrajunto(palavrasplt) + " \n 1.Pedir dica \n 2.Desistir \n\n Resposta: ");
			//System.out.print("\nQual é essa palavra -> " + Palavrajunto(palavrasplt) + " \n 1.Pedir dica \n 2.Desistir \n\n Resposta: ");
			//resposta = teclado.nextLine();
		}
	}	

	
	public static String Rand(String[] palavras){
		Random aleatorio = new Random();
		String palavra = palavras[aleatorio.nextInt(palavras.length)];
		
		return palavra;
		
	}
	
	public static void Embaralhamento(String[] palavra){
		Random aleatorio = new Random();
		
		String[] emb = palavra;
		
		String aux = "";
		for(int i = 0; i < emb.length; i++){
			int num = aleatorio.nextInt(emb.length);
			aux = emb[i];
			emb[i] = emb[num];
			emb[num] = aux;
			
		}
	
	}	
	
	public static void Dica(String palavra){
	
		String[] palavrasplt = palavra.split("");
		JOptionPane.showMessageDialog(null, "\nPrimeira letra: " + palavrasplt[0] + " Segunda letra: " + palavrasplt[palavrasplt.length -1]);
		
		
	}

	public static String Palavrajunto(String[] palavrasplt){
		String palavraint = "";
		for(int i = 0; i < palavrasplt.length; i++){
			palavraint += palavrasplt[i];
		}
		return palavraint;
		
	}

}