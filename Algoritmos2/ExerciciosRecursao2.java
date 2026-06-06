import java.util.Arrays;

public class ExerciciosRecursao2{
	public static void main(String[] args){
	
	
	int[] a = {-1, 0, 1, 2, -1, -4};
	
	//insertSort(a);
	//System.out.println(Arrays.toString(a));
	String[] b = "java".split("");
	System.out.println(inverterString(b, 0));
	//System.out.println(soma3Valores(a, 0));
	}
	public static int somaAteN(int num){
		if(num == 1) return 1;
		
		return num + somaAteN(num-1);
	}
	
	public static int fatorial(int num){
		if(num == 1) return 1;
		
		return num * fatorial(num-1);
	}
	
	public static void printAteN(int num){
		if(num < 0) return;
			System.out.println(num);
			printAteN(num-1);
		
	}
	
	public static int somaVetor(int[] vet, int ind){
		if(ind == vet.length-1) return vet[ind];
		return vet[ind] + somaVetor(vet, ind+1);
	}
	
	public static int acharMaiorVetor(int[] vet, int ind, int maior){
		if(ind == vet.length) return maior;
		
		if(vet[ind] > maior){
			maior = vet[ind];
		}
		return acharMaiorVetor(vet, ind+1, maior);
	}

	public static int contarNum(int[] vet, int ind, int num, int qtd){
		if(ind == vet.length) return qtd;
		
		if(vet[ind] == num){
			qtd++;
		}
		return contarNum(vet, ind+1, num, qtd);
	}

	public static String inverterString(String[] vet,int ind){
		if(ind == vet.length) return "";
		return vet[vet.length-1-ind] + inverterString(vet, ind+1);
	}
	
	public static boolean verificarPalindroma(String[] vet, int ind){
		if(ind > vet.length /2) return true;
	
		if(!vet[ind].equals(vet[vet.length-1-ind])){
			return false;
		}else{
		return verificarPalindroma(vet, ind+1);
		}
	}
	
	public static void selectSort(int[] vet){
		for(int j = 0; j < vet.length-1; j++){
			int menor = j;
			for(int i = j+1; i < vet.length; i++){
				if(vet[i] < vet[menor]){
					menor = i;
				}
			}
			int aux = vet[menor];
			vet[menor] = vet[j];
			vet[j] = aux;
		}
	}
	
	public static void insertSort(int[] vet){
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
	
	public static boolean soma3Valores(int[] vet, int ind){
		if(ind == vet.length-2) return false;
		int esq = ind+1;
		int dir = vet.length -1;
		int soma = 1;
		while(esq<dir){
			soma = vet[ind] + vet[esq] + vet[dir];
			if(soma == 0){
				return true;
			}else if(soma > 0){
				dir--;
			}else{
				esq++;
			}
		}
		return soma3Valores(vet, ind+1);
	}
}
