import java.util.Arrays;
public class Ordenacao{

	public static void main(String args[]){
		int vetor[] = {5,6,2,4,8,3};
		System.out.println(Arrays.toString(vetor));
		Bubble(vetor);
		System.out.println(Arrays.toString(vetor));

	}

	public static void Bubble(int vetor[]){
		int contador = 0;
		for(int x = 0; x < vetor.length -1; x++){
			boolean trocou = false;
			for(int y = 0; y < vetor.length -1; y++){
				contador++;
				if(vetor[y] > vetor[y+1]){

					int aux = vetor[y];
					vetor[y] = vetor[y+1];
					vetor[y+1] = aux;
					trocou= true;

				}					

			}
		if(!trocou) break;
	
		}
		System.out.println(contador);
	
	}




}