import java.util.Arrays;

public class Insert{
	public static void main(String[] args){
		int[] vet = {7, 1, 5, 9, 2};
		ordenar(vet);
		System.out.println(Arrays.toString(vet));
		System.out.println(maxDif(vet));
		
	}
	
	
	private static void ordenar(int[] vet){
		
		for(int i = 1; i < vet.length; i++){
			int chave = vet[i];
			int y = i-1;
			
			while(y >= 0 && vet[y] > chave){
				vet[y +1] = vet[y];
				y--;
			}
			
			vet[y+1] = chave;
		}
	}
	
	private static int maxDif(int[] vet){
		Integer maior = null;
		
		for(int i =0; i < vet.length-1; i++){
			int dif = vet[i+1] - vet[i];
			if( maior == null || dif > maior ){
				maior = dif;
			}
		}
		return maior;
		
		
	}
	
	
}