import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

       System.out.println(verificador(n));
    }
	
	public static String verificador(int num){
		int soma = 0;
		String resposta = "";
		
		for(int i = 0; i < num-1; i++){
			if(num % (i + 1) == 0 ){
				soma += i +1;
			}	
		}
		if(soma == num){
			resposta = "N é perfeito";
		}else {
			resposta = "N não é perfeito";
		}
		return resposta;
	}
}