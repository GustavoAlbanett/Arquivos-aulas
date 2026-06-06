import javax.swing.JOptionPane;

public class Ex7{
	public static void main(String[] args){
		String[] num = JOptionPane.showInputDialog("Quais os números").split(" ");
	
		JOptionPane.showMessageDialog(null, Ordena(num));
	}

	public static String[] Ordena(String[] num){
		String aux = "";
		for(int i = 0; i < num.length -1; i++){
			for(int j = 0; j < num.length -1; j++){
					if(Integer.parseInt(num[j]) > Integer.parseInt(num[j+1])){
						aux = num[j];
						num[j] = num[j+1];
						num[j+1] = aux;
					}
			}
		}
		return num;
		
	}

}