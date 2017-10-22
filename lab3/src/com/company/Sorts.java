package com.company;

public class Sorts {

    public static void bubbleSort(int sortArray[]) {
        int n = sortArray.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (sortArray[i] > sortArray[k]) {
                    swapNumbers(i, k, sortArray);
                }
            }
        }
    }

    private static void swapNumbers(int i, int j, int[] sortArray) {

        int temp;
        temp = sortArray[i];
        sortArray[i] = sortArray[j];
        sortArray[j] = temp;
    }

    public static int[] doInsertionSort(int[] sortArray){

        int temp;
        for (int i = 1; i < sortArray.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(sortArray[j] < sortArray[j-1]){
                    temp = sortArray[j];
                    sortArray[j] = sortArray[j-1];
                    sortArray[j-1] = temp;
                }
            }
        }
        return sortArray;
    }


    static void QuickSort(int[] sortArray, int begin, int end) {
        int left = begin, right = end;
        int pivot = sortArray[(left + right) / 2];
        while (left <= right) {
            while (sortArray[left] < pivot) left++;
            while (sortArray[right] > pivot) right--;
            if (left <= right) exchange(sortArray, left++, right--);
        }
        if (begin < right) QuickSort(sortArray, begin, right);
        if (end > left) QuickSort(sortArray, left, end);
    }

    static void exchange(int[] array, int n1, int n2) {
        int var = array[n1];
        array[n1] = array[n2];
        array[n2] = var;
    }

    static void CycleSort(int[] sortArray){
        for (int cycleStart = 0; cycleStart < sortArray.length - 1; cycleStart++) {
            int val = sortArray[cycleStart];
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < sortArray.length; i++) if (sortArray[i] < val) pos++;
            if (pos == cycleStart) continue;
            while (val == sortArray[pos]) pos++;
            int tmp = sortArray[pos];
            sortArray[pos] = val;
            val = tmp;
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < sortArray.length; i++) if (sortArray[i] < val) pos++;
                while (val == sortArray[pos]) pos++;
                tmp = sortArray[pos];
                sortArray[pos] = val;
                val = tmp;
            }
        }
    }

    public static void mergeSort(int[] sortArray) {
        if (sortArray.length > 1) {
            int[] left = leftHalf(sortArray);
            int[] right = rightHalf(sortArray);

            mergeSort(left);
            mergeSort(right);

            merge(sortArray, left, right);
        }
    }

    public static int[] leftHalf(int[] sortArray) {
        int size1 = sortArray.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = sortArray[i];
        }
        return left;
    }

    public static int[] rightHalf(int[] sortArray) {
        int size1 = sortArray.length / 2;
        int size2 = sortArray.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = sortArray[i + size1];
        }
        return right;
    }

    public static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

}
