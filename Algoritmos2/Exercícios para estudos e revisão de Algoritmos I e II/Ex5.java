import javax.swing.JOptionPane;

public class Ex5{
	public static void main(String args[]){
		String[] palavra = JOptionPane.showInputDialog("Digite a palavra.").split("");
		
		JOptionPane.showMessageDialog(null, Verificador(palavra));
		
	}
	
	public static String[] Invert(String[] txt){
		for(int i = 0; i < txt.length /2 ; i++){
			String aux = txt[i];
			txt[i] = txt[txt.length - i -1];
			txt[txt.length -i -1] = aux;
		}
		return txt;
	}
	
	public static String Verificador(String[] palavra){
		
		String txt1 = Juntar(palavra);
		String[] invertida = Invert(palavra);
		String txt2 = Juntar(invertida);
		
		String resposta = "";
		
		if(txt1.equals(txt2)){
			resposta = "É palíndromo";
		} else{
			resposta = "Não é";
		}
		
		return resposta;
	}
	
	public static String Juntar(String[] txt){
		//String somador = "";
		//for(int i = 0; i < txt.length; i++){
			//somador += txt[i];
		//}
		//return somador;
		
		return String.join(" ", txt);
	}
	
	
}