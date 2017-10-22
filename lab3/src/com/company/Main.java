package com.company;
//Lab 3 task

// Create an array of numbers that consists of 150 elements. The contents of the array generate with Random#nextInt.
// Implement five types of data sorts.
// Use two libraries to sort the data.
// Three times perform each of the sorts, including sorts with libraries, with the working time measurement of each of them.
// Gather the performance (resources and time) metrics of your sorting and libraries sorting.
// The time for working of the each sort is output to the console.
// Keep in mind: Generate an array once, and all sorting algorithms, including libraries for sorting, should use this array.
import java.util.Random;
import java.util.Arrays;

public class Main {

    //    bubble sort, insertion sort, quick sort, cycle sort, merge sort;

    public static void main(String[] args) {
        int[] randomArray = new int[150];
        int[] sortArray = new int[150];
        Random random = new Random();
        for (int i = 0; i < 150; i++)
            randomArray[i] = random.nextInt(100500) - 12345;

        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Sorts.bubbleSort(sortArray);
            long end = System.nanoTime();
            System.out.println("Bubble Sort " + (i + 1) + ", time: " + (end - start));
        }
        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Sorts.doInsertionSort(sortArray);
            long end = System.nanoTime();
            System.out.println("Insertion Sort " + (i + 1) + ", time " + (end - start));
        }
        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Sorts.QuickSort(sortArray, 0, sortArray.length - 1);
            long end = System.nanoTime();
            System.out.println("Quick Sort " + (i + 1) + ", time: " + (end - start));
        }
        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Sorts.CycleSort(sortArray);
            long end = System.nanoTime();
            System.out.println("Cycle Sort " + (i + 1) + ", time: " + (end - start));
        }
        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Sorts.mergeSort(sortArray);
            long end = System.nanoTime();
            System.out.println("Merge Sort " + (i + 1) + ", time: " + (end - start));
        }
        for (int i = 0; i < 3; i++) {
            zeroArray(sortArray);
            System.arraycopy(randomArray, 0, sortArray, 0, 150);
            long start = System.nanoTime();
            Arrays.sort(sortArray);
            long end = System.nanoTime();
            System.out.println("(library)Array Sort " + (i + 1) + ", time: " + (end - start));
        }
        //        for (int v : sortArray) System.out.println(v);

    }

    static void zeroArray(int[] array) {
        for (int i = 0; i < 150; i++)
            array[i] = 0;
    }
}
