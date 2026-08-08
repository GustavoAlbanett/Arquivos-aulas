import java.util.Scanner;

public class Aula {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite os nomes e suas idades");
		String[] txt = teclado.nextLine().split(" ");
		
		System.out.println("A pessoa com maior idade é: " + txt[maior(txt) -1]);
		
	}
	
	public static int maior(String[] txt){
		int indice = 0;
		for(int i =1; i < txt.length / 2; i += 2){
			if(Integer.parseInt(txt[i]) >= Integer.parseInt(txt[i+2])){
				indice = i;
			}else{
				indice = i+2;
			}
		}
		return indice;
	}
 
 
}