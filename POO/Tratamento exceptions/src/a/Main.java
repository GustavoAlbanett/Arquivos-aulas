package a;


public class Main{
	public static void main(String[] args){
		GeraErro obj = new GeraErro();
		try {
		obj.Executar();
		}catch (Exception ex) {
			TrataExecessao minhaex = new TrataExecessao();
					minhaex.run(ex);
		}
		finally {
			System.out.println(".. Codigo continua ...");
		}
				
	}

}

class TrataExecessao{
	void run(Exception ex) {
		System.out.print("Veja o erro abaixo");
		System.out.println(ex);
	}
}

class GeraErro{
	
	int Executar() throws Exception {
		int[] a = {0,1};
		System.out.println(a[2]);
		return a[2];
	}
	
	int Executar1() throws Exception {
		int a = 10;
		int b = 0;		
		int resultados = a/b;
		System.out.println(resultados);
		return resultados;
	}
}

class Banco{
	double saldo;
	
	Banco(int saldo){
		this.saldo = saldo;
	}
	
	void sacar(int val) {
		if(val > saldo && val < 0) {
			this.saldo -= val;
		}
	}
	
}