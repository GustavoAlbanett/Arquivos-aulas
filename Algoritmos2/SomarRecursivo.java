public class SomarRecursivo{
	public static void main(String[] args){
		int soma = somarNumerosAteN(5);
		
		int fato = fatorial(5);
		System.out.println(soma);
		System.out.println(fato);
		
	}

	public static int somarNumerosAteN(int numero){
	
		if(numero == 0) return 0; //caso base
		return numero + somarNumerosAteN(numero-1);
	}
	
	public static int fatorial(int num){
		if(num == 1) return 1;
		return num * fatorial(num -1);
	
	}


}