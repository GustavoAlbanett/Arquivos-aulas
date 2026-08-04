public class Main {
    public static void main(String[] args) {
        String entradaUsuario = "10a"; // Exemplo de entrada com erro de digitação

        try {
            int numero = Integer.parseInt(entradaUsuario);
            System.out.println("Número convertido com sucesso: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro de conversão: O texto '" + entradaUsuario + "' não é um número válido!");
        }
    }
}