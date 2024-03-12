package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)){
			return;
		}

		if (leftIndex < rightIndex) {
			
			int min = getMinAndMax(array, leftIndex, rightIndex)[0];
			int max = getMinAndMax(array, leftIndex, rightIndex)[1];

			int[] counters = new int[max-min +1];
			Integer[] arrayAux = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {
				counters[array[i] - min] += 1;
			}

			for (int i = 1; i < counters.length; i++) {
				counters[i] += counters[i - 1];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
                array[counters[arrayAux[i] - min] - 1] = arrayAux[i];
                counters[arrayAux[i] - min] -= 1;
            }
		}
	}

	private Integer[] getMinAndMax(Integer[] array, int leftIndex, int rightIndex) {
		
		int min = array[leftIndex];
		int max = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max) {
				max = array[i];
			}

			if (array[i] < min) {
				min = array[i];
			}
		}

		Integer[] resp = new Integer[]{min, max};
		return resp;
	}

}
