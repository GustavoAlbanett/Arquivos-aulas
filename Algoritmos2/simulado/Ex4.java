import javax.swing.JOptionPane;
public class Ex4{
	public static void main(String[] args){
		int[] vet = {5, 4, 3 ,2 ,1, 23 , 22, 1};
		bubbleSort(vet);
		String soma = "";
		for(int i = 0; i < vet.length; i++){
			soma += " " + String.valueOf(vet[i]);
		}
		JOptionPane.showMessageDialog(null, soma);
	}
	
	


	public static void bubbleSort(int[] vet){
		int aux = 0;
		for(int i = 0; i < vet.length -1; i++){
			for(int j = 0; j < vet.length -1; j++){
				if(vet[j] > vet[j +1]){
					aux = vet[j];
					vet[j] = vet[j+1];
					vet[j +1] = aux;
				}
		}
		
		}
	}

}