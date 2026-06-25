public class ListaEncadeada{
    No cabeca;

    public void adicionarInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = cabeca;
        cabeca = novo;
    }

    public void adicionarFim(int valor) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
            return;
        }
        No t = cabeca;
        while (t.proximo != null) t = t.proximo;
        t.proximo = novo;
    }

    public void imprimir() {
        No t = cabeca;
        while (t != null) {
            System.out.print(t.valor + " -> ");
            t = t.proximo;
        }
        System.out.println("null");
    }
	
	public ListaEncadeada clonar(){
		
		ListaEncadeada clone = new ListaEncadeada();
		No aux = cabeca;
		while(aux != null){
			clone.adicionarFim(aux.valor);
			aux = aux.proximo;
		}
		return clone;
	}
	
	public ListaEncadeada intercalar(ListaEncadeada outra){
		No aux1 = cabeca;
		No aux2 = outra.cabeca;
		
		ListaEncadeada lista3 = new ListaEncadeada();
		
		while(aux1 != null && aux2 != null){
			lista3.adicionarFim(aux1.valor);
			lista3.adicionarFim(aux2.valor);
			aux1 = aux1.proximo;
			aux2 = aux2.proximo;
		}
		
		if(aux1 == null){
			while(aux2 != null){
				lista3.adicionarFim(aux2.valor);
				aux2 = aux2.proximo;
			}
		}
		if(aux2 == null){
			while(aux1 != null){
				lista3.adicionarFim(aux1.valor);
				aux1 = aux1.proximo;
			}
		}
		return lista3;
	}

	public boolean 

	public void limpar(){
		inicio = null;
	}

	public static void main(String[] args){
		ListaEncadeada original = new ListaEncadeada();
        original.adicionarFim(1);
        original.adicionarFim(2);
        original.adicionarFim(3);

        ListaEncadeada copia = original.clonar();

        original.imprimir();
        copia.imprimir();


        original.adicionarFim(4);
        original.imprimir();
        copia.imprimir();
	}

    private static class No {
        int valor;
        No proximo;
        public No(int valor) { this.valor = valor; }
    }

}
