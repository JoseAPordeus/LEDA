package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (verification(array, leftIndex, rightIndex)) {
			this.bubbleSort(array, leftIndex, rightIndex);
		}
	}

	private void bubbleSort(T[] array, int leftIndex, int rightIndex) {
		
		boolean swapping = true;
		while (swapping) {
			swapping = false;
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i].compareTo(array[i+1]) > 0) {
					Util.swap(array, i, i+1);
					swapping = true;
				}
			}
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
