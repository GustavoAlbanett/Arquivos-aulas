import java.util.Scanner;

public class Ex1 {

    public static int contarPalavras(String frase) {
        String[] separado = frase.split(" ");
		return separado.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();

        System.out.println(contarPalavras(frase));
    }
}