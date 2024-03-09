package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}
		
		if (leftIndex < rightIndex) {

			int max = findMaxValue(array, leftIndex, rightIndex);

			int[] counters = new int[max + 1];
			Integer[] arrayAux = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {
				counters[array[i]] += 1;
			}

			for (int i = 1; i < counters.length; i++) {
				counters[i] += counters[i-1];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[counters[arrayAux[i]]-1] = arrayAux[i];
				counters[arrayAux[i]] -= 1;
			}
		}
	}

	private int findMaxValue(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
