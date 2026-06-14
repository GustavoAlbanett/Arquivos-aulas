import java.util.ArrayList;
import java.util.List;

public class EstudoLista{
	public static void main(String[] args){
		ListaEncadeada lista = new ListaEncadeada();
		lista.adcInicio(10);
		lista.adcInicio(20);
		lista.adcInicio(30);
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
			System.out.println(aux.valor + " ");
			aux = aux.proximo;
		}
		System.out.println();
	}
	
	public void adcFinal(int num){
		No aux = inicio;
		if(inicio == null){
			inicio = num;
			return;
		}
	}
	
	public void adcInicio(int num){
		No novo = new No(num);
		novo.proximo = this.inicio;
		this.inicio = novo;
		tamanho++;	
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


