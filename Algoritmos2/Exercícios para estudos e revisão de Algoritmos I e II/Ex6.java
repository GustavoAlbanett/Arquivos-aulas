import javax.swing.JOptionPane;

public class Ex6{
	public static void main(String[] args){
		String[] num = JOptionPane.showInputDialog("Digite o número.").split("");

		JOptionPane.showMessageDialog(null, Somar(num));
	}
	

	public static int Somar(String[] num){
		int soma = 0;
		
		for(int i = 0; i < num.length; i++ ){
			soma += Integer.parseInt(num[i]);
		}
		return soma;
	}
}