public class Main{
	public static void main(String[] args){

		
		Carro car = new Carro("Volks", "Gol", 2013);
		
		Roda roda = new Roda(18);
		car.adicionarRoda(roda);
		roda = new Roda(18);
		car.adicionarRoda(roda);
		roda = new Roda(18);
		car.adicionarRoda(roda);
		roda = new Roda(18);
		car.adicionarRoda(roda);
		roda = new Roda(18);
		car.adicionarRoda(roda);
		roda = new Roda(18);
		System.out.println(car);
		
		
	}
}


class Carro{
	String modelo;
	String marca;
	int ano;
	Roda rodas[];
	
	public Carro(String marca, String modelo, int ano){
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
			rodas = new Roda[5];
		}
		
		
		public void adicionarRoda(Roda roda_qualquer){
			int x = roda_livre();
				rodas[x] = roda_qualquer;	
		}
		
		public int roda_livre(){
				Roda tmp;
				for(int i=0; i < 5; i++){
					tmp = this.rodas[i];
					if(tmp == null){
						return i;
					}
				}
				return -1; 
		}
		
		@Override
		public String toString(){
			String str = ("Carro " + marca + " " + modelo + " " + ano);
			str += "\n - rodas: ";
			for(int i =0; i < rodas.length; i++){
				str += "\n roda["+i+"] -> "+this.rodas[i];
			}
			return str;
			
			
	}
}


class Roda{
	int aro;
	public Roda(int n){
		this.aro = n;
	}
	
	@Override
	public String toString(){
		return "Sou uma roda";
	}
}