import javax.swing.JOptionPane;

public class Ex7{
	public static void main(String[] args){
	int a = Integer.parseInt(JOptionPane.showInputDialog("Primeiro número"));
	int b = Integer.parseInt(JOptionPane.showInputDialog("Segunda número"));
	
	JOptionPane.showMessageDialog(null, somaPar(a, b));
	
	
	}

	public static int somaPar(int a, int b){
		int soma = 0;
		for(int i = a; i <= b; i++){
			if(i % 2 == 0){
				soma += i;
			}
		}
		return soma;
	}
	
	
}