public class Heranca{
	public static void main(String[] args){
		Abelha a = new Abelha();
		Vaca v = new Vaca();
		Grilo g = new Grilo();
		Animal ani = new Animal();
		a.emitirSom();
		v.emitirSom();
		g.emitirSom();
		ani.emitirSom();
	}

}



class Animal{
	public void emitirSom(){
		System.out.println("grrrr");
	}
}

class Abelha extends Animal{
	String nome;
	public void emitirSom(){
		System.out.println("bzzzz");
	}
}

class Grilo extends Animal{
	String nome;
	public void emitirSom(){
		System.out.println("cri cri");
	}
}

class Vaca extends Animal{
	String nome;
	
	public void emitirSom(){
		System.out.println("muuu");
	}
}