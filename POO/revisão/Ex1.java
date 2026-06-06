public class Ex1{
	public static void main(String[] args){
		Produto item1 = new Produto("tomate", 10);
		Produto item2 = new Produto("presunto", 8);
		Produto item3 = new Produto("queijo", 5);
		item1.exibirDados();
		item2.exibirDados();
		item3.exibirDados();
		
		System.out.println(item1.calcularDesconto(10));
		System.out.println(item2.calcularDesconto(10));
		System.out.println(item3.calcularDesconto(10));	
	}
	
}
class Produto{
	String nome;
	double preco;
	
	public Produto(String n, double num){
		this.nome = n;
		this.preco = num;
	}
	
	double calcularDesconto(double percentual){
		return (this.preco - (this.preco * percentual /100));
	}
	
	public void exibirDados(){
		System.out.println(this.nome);
		System.out.println(this.preco);
	}
	
	
}
	
	
	
	
