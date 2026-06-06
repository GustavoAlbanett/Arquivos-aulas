import java.util.Arrays;
public class QuestoesOrdena{
	public static void main(String[] args){
	//String[] vet = {"abacate", "aaa", "aabo", "aaaa"};
	int[] veti = {4, 2, 2, 8, 4, 9};
	//removeduplicado(veti);
	bubble(veti);
	System.out.println(Arrays.toString(veti));
	
	}
	
	public static void insert(int[] vet){
		for(int i = 1; i < vet.length; i++){
			int chave = vet[i];
			int j = i-1;
			
			while(j >= 0 && vet[j] > chave){
				vet[j+1] = vet[j];
				j--;
			}
		vet[j+1] = chave;
		}
	}
	
	public static void bubble(int[] vet){
		for(int i = 0; i < vet.length -1; i++){
			for(int j =0; j <vet.length-1; j++){
				if(vet[j] > vet[j+1]){
					int aux = vet[j];
					vet[j] = vet[j+1];
					vet[j+1] = aux;
				}
			}
		}
		
	}
	
	public static void select(int[] vet){
		for(int j = 0; j < vet.length-1; j++){
			int menor = j;
			for(int i =j+1; i < vet.length; i++){
				if(vet[i] < vet[menor]){
					menor = i;
				}
			}
		int aux = vet[j];
		vet[j] = vet[menor];
		vet[menor] = aux;
		}
	}
	
	public static void ordenaString1(String[] vet){
	for(int i = 1; i < vet.length; i++){
		String chave = vet[i];
		int j = i-1;
		
		while(j >= 0 && vet[j].compareTo(chave) > 0){
		vet[j+1] = vet[j];
		j--;
		
		}
		vet[j+1] = chave;
	}
	
	}

	public static void ordenaString2 (String[] vet){
		for(int j = 0; j < vet.length-1; j++){
			int indmenor = j;
			for(int i = j+1; i < vet.length; i++){
				if(vet[indmenor].compareTo(vet[i] ) > 0){
					indmenor = i;
				}
			}
			String aux = vet[indmenor];
			vet[indmenor] = vet[j];
			vet[j] = aux;
		}

	}

	public static void ordenalimitadoIns(int[] vet, int num){
		for(int i = 1; i < num; i++){
			int chave = vet[i];
			int j = i -1;
			
			while(j >= 0 && vet[j] > chave){
				vet[j+1] = vet[j];
				j--;
			}
			vet[j+1] = chave;
			
		}
	}

	public static void ordenalimitadoSel(int[] vet, int num){
		for(int j = 0; j < num; j++){
			int indmenor = j;
			for(int i = j+1; i < num; i++ ){
				if(vet[indmenor] > vet[i]){
					indmenor = i;
				}
			}
			int aux = vet[indmenor];
			vet[indmenor] = vet[j];
			vet[j] = aux;
		}
	}

	public static int removeduplicado(int [] vet){
		for(int i =1; i < vet.length; i++){
			int chave = vet[i];
			int j = i -1;
			
			while(j >= 0 && vet[j] > chave){
				vet[j+1] = vet[j];
				j--;
			}
			vet[j+1] = chave;
		}
	
	
	//{2,4,8,9,8,9}
		int contador = 0; // Ponteiro para o último elemento único
		for (int i = 1; i < vet.length;i++) {
			if (vet[i] != vet[contador]) { // Se encontrei um número novo (diferente do último único)
				contador++;                // Aumento o espaço dos únicos
				vet[contador] = vet[i];    // Trago o número novo para a frente
			}
		}

		return contador+1;
	}
}