import javax.swing.JOptionPane;

public class Ex3{
	public static void main(String[] args){
	
	int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número"));
	
	JOptionPane.showMessageDialog(null, "Soma final = " + soma(num));
	
	}

	public static int soma(int num){
		int soma = 0;
		for(int i = 0; i < num; i++){
			if(i % 3 == 0 || i % 5 == 0){
				soma += i;
			}
			
		}
		return soma;
	}


}