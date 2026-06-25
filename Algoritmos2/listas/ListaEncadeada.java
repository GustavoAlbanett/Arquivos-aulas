import java.util.ArrayList;
import java.util.List;

public class ListaEncadeada {
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.adicionarInicio(10);
		lista.adicionarInicio(20);
		lista.adicionarFim(10);
		lista.adicionarInicio(100);
		lista.adicionarApos(30, 10);
		lista.removerFim();
		lista.imprimir();
	 }
 
	 No inicio;
	 int tamanho;
	 
	 public ListaEncadeada() {
		this.inicio = null;
		this.tamanho = 0;
	 }
	 
	 public void adicionarInicio(int valor) {
		 No novo = new No(valor);
		 novo.proximo = inicio;
		 inicio = novo;
		 tamanho++;
	 }
	 
	 public void adicionarFim(int valor){
		 No novo = new No(valor);
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
		
	 public void adicionarApos(int num, int apos){
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
	 
	 public void removerInicio(){
		 if(inicio != null){
			 inicio = inicio.proximo;
			 tamanho--;
		 }else{
			 System.out.println("Lista vazia");
		 }
	 }
	 
	 public void removerFim(){
		 No aux = inicio;
		 if(inicio == null) return;
		 if(inicio.proximo == null){
			 inicio = null;
			 return;
		 }
		 while(aux.proximo.proximo != null){
			 aux = aux.proximo;
		 }
		 aux.proximo = null;
		 tamanho --;
	 }
	 
	 public void imprimir() {
		 No aux = inicio;
		 while(aux!=null) {
			 System.out.print(aux.valor+" ");
			 aux = aux.proximo; 
		 }
		 System.out.println();
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
