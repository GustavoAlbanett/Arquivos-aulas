
class Aluno {
    String nome;
    double nota;
    
    public Aluno(String param1, double param2){
        this.nome = param1;
        this.nota = param2;
    }

    public void verificarSituacao(){
        if( this.nota < 5 ) {
            System.out.println("Reprovado, sorry");
        } else if( this.nota < 7 ) {
            System.out.println("Recuperacao");
        } else {
            System.out.println("Aprovado");
        }
    }
}

// Método escolhido: 04
public class Ex4 {
        public static void main(String[] args){
            Aluno aluno = new Aluno("marcelo", 8.6);
            aluno.verificarSituacao();
        }
}


	