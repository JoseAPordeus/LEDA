package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (verification(array, leftIndex, rightIndex)) {
			this.insertionSort(array, leftIndex, rightIndex);
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		
		T key;
		int i;
		for (int j = leftIndex+1; j <= rightIndex; j++) {
			key = array[j];
			i = j-1;
			while (i >= 0 && array[i].compareTo(key) > 0) {
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
	}

	private boolean verification(T[] array, int leftIndex, int rightIndex) {
		
		boolean status = true;
		if (array.length == 0) {
			status = false;
		}

		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			status = false;
		}
		return status;
	}
}
