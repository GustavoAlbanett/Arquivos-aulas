public class ExerciciosRecursao{
	public static void main(String[] args){
		
		int[] vet = {5, 5, 2, 5, 7};
		String txt = "arara";
		String[] palavra = txt.split("");
		boolean a = palindroma(palavra, palavra.length-1, "", txt);
		System.out.println(fibonachi(5));
	
	}
	public static int somarNumerosAteN(int numero){
	
		if(numero == 0) return 0; //caso base
		return numero + somarNumerosAteN(numero-1);
	}
	
	public static int fatorial(int num){
		if(num == 1) return 1;
		
		return num * fatorial(num -1);
	
	}
	
	public static void printNate0(int num){
		if(num == 0) return;
		System.out.println(num);
		printNate0(num -1);
	}
	
	public static int somaVetor(int[] vet, int ind){
		if( ind == vet.length) return 0;
		
		return vet[ind] + somaVetor(vet, ind+1);
		
	}
	
	public static int maiorVetor(int[] vet, int ind, int maior){
		if(ind == vet.length-1) return maior;
		
		if(maior < vet[ind+1]){
			maior = vet[ind+1];
		}
		return maiorVetor(vet, ind+1, maior);
		
	}
	
	public static int contadorNumero(int[] vet, int num, int ind, int soma ){
		if(ind == vet.length) return soma;
		
		if(num == vet[ind]){
			soma++;
		}
		return contadorNumero(vet, num, ind+1, soma);
	}

	public static String inverterString(String vet[], int ind, String txt){
		if(ind == -1) return txt;
		txt += vet[ind];
		return inverterString(vet, ind-1, txt );
	}

	public static int somarDigitos(String[] vet, int ind, int soma ){
		if(ind == vet.length) return soma;
		soma += Integer.parseInt(vet[ind]);
		return somarDigitos(vet, ind+1, soma);
	}

	public static boolean palindroma(String[] vet, int ind, String txt, String txtn){
		
		if(txt.equals(txtn)) return true;
		if(ind == -1) return false;
		txt += vet[ind];
		
		return palindroma(vet, ind-1, txt, txtn);
		
		
	}

	public static int fibonachi(int num){
		if(num == 0) return 0;
		if(num ==1) return 1;
		
		return fibonachi(n-1) + fibonachi(n-2);
	}
}