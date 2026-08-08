public class Classes {
    public static void main(String[] args){
        Pessoa tmp;
		
		Pessoa p1 = new Pessoa();
        p1.adicionaInfo("joao", 22);

        Pessoa p2 = new Pessoa();
        p2.adicionaInfo("jose", 33);
		
		Pessoa p3 = new Pessoa();
		p3.adicionaInfo("Marcelo", 35);
		
		tmp = new Pessoa();
		tmp.adicionaInfo("Kreslen", 44);
		tmp.mostreInfo();
		
		tmp = new Pessoa();
		tmp.adicionaInfo("Paulo", 24);
		tmp.mostreInfo();

        p1.mostreInfo();
        p2.mostreInfo();
		p3.mostreInfo();
    }
    
}

class Pessoa {
    String nome;
    int idade;

    public void adicionaInfo(String n, int id){
        this.nome = n;
        this.idade = id;
    }

    public void mostreInfo() {
        System.out.println("Nome: "+this.nome+", idade: "+this.idade + " Nascimento: " + (2026 - this.idade));
    }
}






