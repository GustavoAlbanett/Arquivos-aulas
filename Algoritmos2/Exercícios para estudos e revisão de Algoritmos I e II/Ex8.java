import javax.swing.JOptionPane;

public class Ex8{
	public static void main(String[] args){
		String[] palavra = JOptionPane.showInputDialog("Qual a palavra?").split("");
		
		JOptionPane.showMessageDialog(null, "A palavra tem " + Contador(palavra) + " vogais.");
	}
	
	public static int Contador(String[] txt){
		int contador = 0;
		for(int i = 0 ; i < Length(txt); i++){
			if(txt[i].equals("a") || txt[i].equals("e") || txt[i].equals("i") || txt[i].equals("o")|| txt[i].equals("u")){
				contador++;
			}
		}
		return contador;
	}	
	
	public static int Length(String[] txt){
		int contador = 0;
		for(String cont : txt){
			contador++;
		}
		return contador;
	}
}