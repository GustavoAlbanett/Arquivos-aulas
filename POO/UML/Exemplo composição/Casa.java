public class Casa{
	int num;
	Quarto[] qtos;
	public Casa(int nqtos){
		this.num = nqtos;
		qtos = new Quarto[nqtos];
		for(int i =0; i< nqtos; i++){
			qtos[i] = new Quarto();
		}
	}
	
	
	@Override
	public String toString() {
		String str = "casa com " + this.num + " quartos";
		return str;
	}
}