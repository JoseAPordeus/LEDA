package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each subList, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)){
			return;
		}
		if (rightIndex - leftIndex <= 0) {
			return;
		}

		int middle = (leftIndex + rightIndex) / 2;

		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);
		marge(array, leftIndex, middle, rightIndex);
}

	private void marge(T[] array, int leftIndex, int middle, int rightIndex) {
		@SuppressWarnings("unchecked")
		T[] arrayAux = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			arrayAux[i] = array[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int indexResult = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (arrayAux[i].compareTo(arrayAux[j]) <= 0) {
				array[indexResult] = arrayAux[i];
				i++;
			}else{
				array[indexResult] = arrayAux[j];
				j++;
			}
			indexResult++;
		}

		while (i <= middle) {
			array[indexResult] = arrayAux[i];
			i++;
			indexResult++;
		}
		
		while (j <= rightIndex) {
			array[indexResult] = arrayAux[j];
			j++;
			indexResult++;
		}
	}
}