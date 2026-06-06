import java.util.Arrays;

public class Sorts{
	public static void main(String[] args){
	
	int[] vet = {7, 5, 1, 8, 3};
	
		insertSort(vet);
		System.out.println(Arrays.toString(vet));
	}
	
	public static void selectSort(int[] vet){
		int aux = 0;
		for(int j = 0; j < vet.length -1; j++){
			int indmenor = j;
			for(int i = j; i < vet.length; i++){
				if(vet[indmenor] > vet[i]){
					indmenor = i;
				}
			}
		
		aux = vet[j];
		vet[j] = vet[indmenor];
		vet[indmenor] = aux;
		System.out.println(Arrays.toString(vet));
		}
		
	}

	public static void insertSort(int[] vet){
		for(int i = 1; i < vet.length; i++){
			int chave = vet[i];
			int j = i -1;
			
			while(j >= 0 && vet[j] > chave){
				vet[j+1] = vet[j];
				j--;
			}
			vet[j+1] = chave;
		}
	}	
}

// {5, 4, 2, 7, 6}                  {5,4,2,7,6}
//	{5,4,2,7,6} --> {5,4,2,7,6} --> {2,4,5,6,7} chave 6