package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if ((rightIndex - leftIndex < 0) || (array.length == 0)) {
			return;
		}
		if((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)){
			return;
		}

		int indice_menor = leftIndex;
		for (int i = indice_menor+1; i <= rightIndex; i++) {
			if (array[indice_menor].compareTo(array[i]) > 0) {
				indice_menor = i;
			}
		}
		Util.swap(array, leftIndex, indice_menor);
		sort(array, leftIndex+1, rightIndex);
	}

}
