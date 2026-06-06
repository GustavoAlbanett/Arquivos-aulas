import java.util.Arrays;

public class Merge{
	public static void main(String[] args){
		int[] vetor = {5,4,3,2,1};
		mergeSort(0, vetor.length-1, vetor);
		System.out.println(Arrays.toString(vetor));
	}
	
	public void mergeSort(int inicio, int fim, int[] vetor){
		if(inicio < fim){
			int meio = (inicio + fim) / 2;
			mergeSort(inicio, meio, vetor);
			mergeSort(meio+1, fim, vetor);
			merge(inicio, meio, fim, vetor);
			//System.out.println(inicio + " - " + meio);
				
		}
	}
	private void merge(int inicio, int meio, int fim, int[]vetor){
		int[] aux = new int[vetor.length];
		int i = inicio;
		int m = meio+1;
		int y = inicio;
		
		while(i <= inicio && m<= fim ){
			if(vetor[i] <= vetor[m]){
				aux[y] = vetor[i];
				i++;
				y++;
			}else{
				aux[y] = vetor[m];
				m++;
				y++;
			}
		}
		while(i<= inicio){
			aux[y] = vetor[i];
			i++;
			y++;
		}
		
		while(m <= fim){
			aux[y] = vetor[m];
			m++;
			y++;
		}
		
		for(int x = inicio; x <=fim; x++){
			vetor[x] = aux[x];
		}
		
	}
}