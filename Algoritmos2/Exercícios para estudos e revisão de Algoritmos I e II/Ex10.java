import javax.swing.JOptionPane;

public class Ex10{
	public static void main(String[] args){
	int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número: "));
	int pot = Integer.parseInt(JOptionPane.showInputDialog("Digite a potência: "));

	JOptionPane.showMessageDialog(null, "RESULTADO: " + calculo(num, pot));
	}

	public static int calculo(int num, int pot){
		int soma = 1;
		for(int i = 0; i < pot; i++){
			soma = soma * num; 
		}
		return soma;
	}	
	
}
	