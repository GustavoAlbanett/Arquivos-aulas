import javax.swing.JOptionPane;
import java.util.Arrays;

public class Ex27{
	public static void main(String[] args){
	String[] txt = JOptionPane.showInputDialog("Digite o texto.").split(" ");
	
	JOptionPane.showMessageDialog(null, "Contagem de Palavras: "+ txt.length + ", Frequência: " + ", Palavra Mais Frequente: ");
	JOptionPane.showMessageDialog(null, (contador(txt)));
	
	}

	public static void verificarPalavras(String[] txt){
		
		for(int j = 0; j < txt.length; j++){
			for(int i = 0; i < txt.length; i++ ){
				
			}
		}
	}
	
	public static int contador(String[] txt){
		int cont = 0;
		String[] unicas = new String[txt.length];
		for(int j = 0; j < txt.length ; j++){
			
			for(int i = j; i < txt.length; i++){
				if(unicas[i].equals(txt[j])){
					unicas[i] = txt[j];
					break;
				}
			}
		
		}
		cont = 0;
		for(int i = 0; i < unicas.length; i++){
			if(unicas[i] != null ){
				cont++;
			}
		}
			
		return cont;
	}
	
	public static String[] unic(String[] vet){
		String[] txt = new String[contador(vet)];
		
		for(int i = 0; i < txt.length; i++){
			if(vet[i] != null){
				txt[i] = vet[i];
			}
		}
		return txt;
	}
	
}