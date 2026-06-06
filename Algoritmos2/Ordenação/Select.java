import java.util.Arrays;

public class Select{
	public static void main(String[] args){
		int[] vet = {5, 4, 3, 2};
		ordenar(vet);
		System.out.println(Arrays.toString(vet));
	}


	public static void ordenar(int[] vet){
		
		for(int x = 0; x < vet.length -1; x++){
			int indicemenor = x; // o indice menor é = x pois assim ele não fica verificando os que ja foram ordenados
			
			for(int y = x+1; y < vet.length; y++){
				if(vet[indicemenor] > vet[y]){
				indicemenor = y;
				}
			}
			
			if(indicemenor !=x){ // verifica se o indice é diferente de x pois se for igual quer dizer que ja esta ordenado
				int aux = vet[indicemenor];
				vet[indicemenor] = vet[x];
				vet[x] = aux;
			}
		}
		
	}
}