import java.util.ArrayList;
import java.util.List;

public class EstudoLista{
	public static void main(String[] args){
		ListaEncadeada lista = new ListaEncadeada();
		lista.adcInicio(10);
		lista.adcInicio(20);
		lista.adcInicio(30);
		lista.removerPorInd(2);
		lista.imprimir();

	}
}


class ListaEncadeada{
	No inicio;
	int tamanho;
	
	ListaEncadeada(){
		this.inicio = null;
		this.tamanho = 0;
	}
	
	public void imprimir(){
		No aux = inicio;
		while(aux != null){
			System.out.print(aux.valor + " ");
			aux = aux.proximo;
		}
	}
	
	public void adcFinal(int num){
		No novo = new No(num);
		if(inicio == null){
			inicio = novo;
		}else{
			No aux = inicio;
			while(aux.proximo != null){
				aux = aux.proximo;
			}
			aux.proximo = novo;
			tamanho++;
		}
	}
	
	public void adcInicio(int num){
		No novo = new No(num);
		novo.proximo = this.inicio;
		this.inicio = novo;
		tamanho++;	
	}
	
	public void adcPorIndice(int num, int ind){
		if(tamanho <= ind) return;
		if(ind == 0) {
			adcInicio(num);
			return;
		}
		
		No novo = new No(num);
		No aux = inicio;
		int contador = 0;
		while(contador != ind-1){
			aux = aux.proximo;
			contador++;
		}
		novo.proximo = aux.proximo;
		aux.proximo = novo;
		tamanho++;
			
		
	}
	
	 public void adcApos(int num, int apos){
		 if(inicio == null)return;
		 No aux = inicio;
		 while(aux.valor != apos){
			 aux = aux.proximo;
		 }
		 if(aux.proximo == null) return;
		 
		 No novo = new No(num);
		 novo.proximo = aux.proximo;
		 aux.proximo = novo;
		 tamanho++;
	 }
	 
	 public boolean estaPresente(int num){
		 No aux = inicio;
		 while( aux != null){
			if(aux.valor == num){
				return true;
			}
			aux = aux.proximo;
		 }
		 return false;
	 }
	 
	 public void contarItens(){
		System.out.println(tamanho);
	 }
	
	public void removerPorInd(int num){
		int contador = 1;
		No aux = inicio;
		while(aux != null && contador != num){
			aux = aux.proximo;
			contador++;
		}
		aux.proximo = aux.proximo.proximo;
		tamanho--;
	}
	
	public void removerUltimo(){
		No aux = inicio;
		
		if(inicio == null) return;
		if(aux.proximo == null) {
			inicio = null;
			return;
		}
		while(aux.proximo.proximo != null){
			aux = aux.proximo;
		}
		aux.proximo = null;
		tamanho--;
	}
	
	public void removerPrimeiro(){
		inicio = inicio.proximo;
		tamanho--;
	}
	
	private class No{
	int valor;
	No proximo;
	
		No(int num){
			this.valor = num;
			this.proximo = null;
		}
	}
}


