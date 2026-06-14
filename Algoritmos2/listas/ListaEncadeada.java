import java.util.ArrayList;
import java.util.List;

public class ListaEncadeada{
	No inicio;
	int tamanho;
	
	public ListaEncadeada(){
		this.inicio = null;
		this.tamanho = 0;
	}

	public static void main(String[] args){
		ListaEncadeada Lista = new ListaEncadeada();
		Lista.adicionarInicio(10);
		Lista.adicionarInicio(20);
		Lista.adicionarInicio(100);
		Lista.imprimir();
	}
		
		public void imprimir(){
			No aux = inicio;
			while(aux != null){
				System.out.println(aux.valor + " ");
				aux = aux.proximo;
			}
			System.out.println();
		}
		
		public void adicionarInicio(int valor){
			No novo = new No(valor);
			novo.proximo = inicio;
			inicio = novo;
			tamanho ++;
		}
	
	
		private class No{
		int valor;
		No proximo;
		
		No(int valor){
			this.valor = valor;
			this.proximo = null;	
		}
	}
}
