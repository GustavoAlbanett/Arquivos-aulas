class Contabancaria{
	String titular;
	double saldo;


	Contabancaria(String nome, double valor){
		this.titular = nome;
		this.saldo = valor;
	}

	public void depositar(double valor){
		this.saldo += valor;
	}
	
	public void sacar(double valor){
		if(this.saldo >= valor){	
			this.saldo -= valor;
			System.out.println("OK");
		}else{
			System.out.println("Erro. Saldo indisponível");
		}
	}
	
	public void exibirSaldo(){
		System.out.println("Saldo atual: " + this.saldo);
	}
}

public class Ex9 {
	public static void main(String[] args){
		Contabancaria conta = new Contabancaria("Marcelo", 10);
		conta.depositar(100.33);
		conta.sacar(200.02);
		conta.exibirSaldo();
	}
}

// 30, 31, 6, 7, 8, 9, 32, 11, 12, 13, 33, 15, 16, 19, 20, 21, 22, 34, 24, 25, 26, 35