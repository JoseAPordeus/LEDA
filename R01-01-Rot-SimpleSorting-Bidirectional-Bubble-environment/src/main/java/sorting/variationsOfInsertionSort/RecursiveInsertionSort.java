package sorting.variationsOfInsertionSort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveInsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        
        if (array.length <= 0) {
            return;
        }
        if ((leftIndex < 0 || leftIndex >= array.length) || ( rightIndex < 0 || rightIndex >= array.length)) {
            return;
        }
        forRecursive(array, leftIndex+1, rightIndex);
    }

    private void forRecursive(T[] array, int leftIndex, int rightIndex) {
       if (leftIndex < rightIndex) {
        T key = array[leftIndex];
        int last = leftIndex-1; 
        whileRecursive(array, leftIndex, rightIndex, last, key);
        forRecursive(array, leftIndex+1, rightIndex);
       }
    }

    private void whileRecursive(T[] array, int leftIndex, int rightIndex, int i, T key) {
        if (i >= 0 && array[i].compareTo(key) >= 0) {
            array[i+1] = array[i];
            whileRecursive(array, leftIndex, rightIndex, i-1, key);
        }
        array[i+1] = key;
    }
}
