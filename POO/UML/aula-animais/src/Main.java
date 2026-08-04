import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] animais = new Animal[100];
        
		Animal a = new Animal();
		Cachorro c = new Cachorro();
		Passaro p = new Passaro();
		Gato g = new Gato();
		
		a.EmitirSom();
		c.EmitirSom();
		p.EmitirSom();
		g.EmitirSom();

    }
    public static void PrintAnimais(Animal[] animais){
        for(Animal vet: animais){
            vet.EmitirSom();
        }
    }
    public static void PreencherRandom(Animal[] vet){
        Random rand = new Random();
        for(int i = 0; i < vet.length; i++){
            int num = rand.nextInt(3);
            if(num == 0) vet[i] = new Cachorro();
            if(num == 1) vet[i] = new Gato();
            if(num == 2) vet[i] = new Passaro();
        }
    }

}
class Animal{
    String nome;
    int idade;

    public void EmitirSom(){
        System.out.println("Barulho Generico de animal");
    }
}

class Cachorro extends Animal{
    public void EmitirSom(){
    System.out.println("Au au");
    }
}

class Gato extends Animal{
    public void EmitirSom(){
        System.out.println("miau");
    }
}

class Passaro extends Animal{

    public void EmitirSom(){
        System.out.println("bem-tivi");
    }
}