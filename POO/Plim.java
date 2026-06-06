import java.util.Scanner;
public class Plim{
	public static void main(String args[]){

	int inicio = LerNum("Inicio: ");
	int fim = LerNum("Fim: ");
	int plim = LerNum("Plim: ");
	Executar(inicio, fim, plim);


	}

	public static void Executar(int ini, int fim, int plim){
		for(int i = ini; i <= fim; i++){
			if(i % plim != 0){
				System.out.println(i);
			}
			else{
				System.out.println("PLIM");
			}
		}

	}		

	public static int LerNum(String txt){
		Scanner teclado = new Scanner(System.in);
		System.out.print(txt);
		int num = teclado.nextInt();
		return num;
	}



// MAPA - 
}