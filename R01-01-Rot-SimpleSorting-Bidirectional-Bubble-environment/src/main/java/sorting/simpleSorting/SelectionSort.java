package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (verification(array, leftIndex, rightIndex)) {
			this.selectionSort(array, leftIndex, rightIndex);
		}
	}

	private void selectionSort(T[] array, int leftIndex, int rightIndex) {
		
		int indice_menor;
		for (int i = leftIndex; i < rightIndex; i++) {
			indice_menor = i;
			for (int j = i+1; j <= rightIndex; j++) {
				if (array[indice_menor].compareTo(array[j]) > 0) {
					indice_menor = j;
				}
			}
			Util.swap(array, i, indice_menor);
		}
	}

	private boolean verification(T[] array, int leftIndex, int rightIndex) {
		
		boolean status = true;
		if (array.length == 0) {
			status = false;
		}
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			status = true;
		}
		return status;
	}
}
