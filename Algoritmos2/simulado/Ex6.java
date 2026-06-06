import javax.swing.JOptionPane;


public class Ex6{
	public static void main(String[] args){
	String[] palavra = JOptionPane.showInputDialog("Qual a palavra?").split("");
	
	JOptionPane.showMessageDialog(null, contador(palavra));
	}

	public static int contador(String[] palavra){
		int contador = 0;
		String[] aeiou = {"a", "e", "i", "o", "u"};
		for(int i = 0; i < palavra.length; i++){
				if(palavra[i].equals("a") || palavra[i].equals("e") || palavra[i].equals("i") || palavra[i].equals("o") || palavra[i].equals("u")){
						contador++;
				}
		}
		
		return palavra.length - contador;
	}

}