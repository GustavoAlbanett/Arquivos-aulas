import javax.swing.JOptionPane;
import java.util.Arrays;

public class Ex21{
	public static void main(String[] args){
		String[] cpf = JOptionPane.showInputDialog("Digite o cpf.").split("");
		JOptionPane.showMessageDialog(null, verificar((cpf)));
	}

	public static int[] converter(String[] vet){
		int[] cpf = new int[9];
		int contador = 0;
		for(int i = 0; i < 11; i++){
			if(i == 3 || i == 7){
				
			}else{
				cpf[contador] = Integer.parseInt(vet[i]);
				contador++;
			}
		}
		return cpf;	
	}
	
	public static int verificador1(int[] vet){
		int soma = 0;
		for(int i = 2; i <= 10 ; i++){
			soma += vet[vet.length -i +1] * i;
		}
		if(soma / 11 < 2){
			return 0;
		}else{
			return 11 - (soma % 11);
		}
	}
	
	public static int verificador2(int[] vet){
		int soma = 0;
		for(int i = 3; i <= 11 ; i++){
			soma += vet[vet.length -i +2] * i;
		}
		soma += 2 * verificador1(vet);
		if(soma / 11 < 2){
			return 0;
		}else{
			return 11 - (soma % 11);
		}		
	}

	public static String verificar(String[] vet){
		if(Integer.parseInt(vet[12]) == verificador1(converter(vet)) && Integer.parseInt(vet[13]) == verificador2(converter(vet))){
			return "Válido";
		}else{
			return "Inválido";
		}
	}
}