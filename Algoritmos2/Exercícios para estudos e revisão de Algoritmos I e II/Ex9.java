import javax.swing.JOptionPane;

public class Ex9{
	public static void main(String[] args){
		int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número a ser convertido."));
	
		JOptionPane.showMessageDialog(null, "número em binário: " + Conversor(num));
	}
	
	public static int Contador(int num){
		int contar = 0;
		while(num != 0){
			contar++;
			num = num / 2;
		}
		return contar;
	}

	public static String Conversor(int num){
		int[] vet = new int[Contador(num)];
		
		for(int i = 0; i < vet.length; i++){
			if(num % 2 == 0){
				vet[vet.length -1 -i] = 0;
			}else{
				vet[vet.length -1 -i] = 1;
			}
			num = num / 2;
		}
		return Juntar(vet);
	}
	
	public static String Juntar(int[] nums){
		String[] txt = new String[nums.length];
		
		for(int i = 0; i < nums.length; i++){
			txt[i] = String.valueOf(nums[i]);
		}
		return String.join("", txt);
		
	}

}
