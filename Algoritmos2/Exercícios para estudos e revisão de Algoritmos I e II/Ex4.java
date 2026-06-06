import javax.swing.JOptionPane;

public class Ex4{
	public static void main(String args[]){
		String[] num = (String.valueOf(JOptionPane.showInputDialog("Escreva o número."))).split("");
	
		Inverter(num);
		Mostrar(num);
	}
	
	public static void Inverter(String[] num){
		String aux = "";
		int diminuidor = 1;
		for(int i = 0; i < num.length /2 ; i++){
		
			aux = num[i];
			num[i] = num[num.length - diminuidor ];
			num[num.length - diminuidor] = aux;
			diminuidor++;
		}
	}
	
	public static void Mostrar(String[] num){
		String texto = "";
		for(int i = 0; i < num.length ; i++){
			texto += num[i];
		}
		JOptionPane.showMessageDialog(null, texto);
	}
	
	
}