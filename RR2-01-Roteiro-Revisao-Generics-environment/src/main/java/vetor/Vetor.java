package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor <Object extends Comparable<Object>> {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<Object> comparadorMaximo;
	private Comparator<Object> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (Object[]) new Comparable[tamanho]; 
	}

	public void setComparadorMaximo(Comparator<Object> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<Object> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		Object result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou){
			if(arrayInterno[i].equals(0)){
				result = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		Object result = null;
		boolean achou = false;
		int i = 0;
		while(i <= indice && !achou){
			if(arrayInterno[i].equals(o)){
				result = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice == this.tamanho -1;
	}
	
	public Object maximo(){
		Object result = null;
		if(!isVazio()){
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if(comparadorMaximo.compare(result, arrayInterno[i]) < 0){
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

	public Object minimo(){
		Object result = null;
		if(!isCheio()){
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if(comparadorMinimo.compare(result, arrayInterno[i]) < 0){
					result = arrayInterno[i];
				}
			}
		} 
		return result;
	}
}
