package com.company;
/*
Given an integer square matrix of order 8. Find the least of the values of the column items that have the largest amount
 of modules elements of If there are several columns, then take the first one.;
The given positive integer n is an integer square matrix of order n Obtain bi, ..., bn, where bi is: a) the least of the
 values of the elements that are at the beginning of the i-th matrix line to the element belonging to the main diagonal
 including; b) the value of the first in the order of the positive element of the i-th line (if there are no such
 elements, then take bi = l).
 */
import java.util.Scanner;
import java.util.Random;

public class partTwo {
    public static  void main(String args[]){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Part 2");

        int colNum = 0,cur,max = 0,min = 0;
        int[][] baseMatrix = new int[8][8];
        for(int j = 0; j < 8; j++)
            for(int i = 0; i < 8; i++) baseMatrix[i][j] = rand.nextInt()%100;
        for(int j = 0; j < 8; j++){
            cur = 0;
            for(int i = 0; i < 8; i++) {
                cur += Math.abs(baseMatrix[i][j]);
            }
            if(cur > max) {
                max = cur;
                colNum = j;
            }
        }
        for(int i = 0; i < 8; i++) {
            if(baseMatrix[i][colNum] < min) {
                min = baseMatrix[i][colNum];
            }
        }
        showMatrix(baseMatrix);
        System.out.println("Value: " + min);

        int n = 0;
        while(n <= 0) {
            System.out.print("Elements num: ");
            n = in.nextInt();
        }

        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) matrix[i][j] = rand.nextInt()%100;
        showMatrix(matrix);
        int minEl;
        System.out.print("Min: ");
        for(int i = 0; i < n ; i++){
            minEl = matrix[i][0];
            int j = 0;
            while(j <= i){
                if(matrix[i][j] < minEl) minEl = matrix[i][j];
                j++;
            }
            System.out.print(minEl + " ");
        }

        int[] arrayB = new int[n];
        System.out.print("First positive: ");
        for(int i = 0; i < n ; i++){
            arrayB[i] = 1;
            int j = 0;
            while(j < n && matrix[i][j] <= 0) j++;
            arrayB[i] = matrix[i][j];
            System.out.print(arrayB[i] + " ");
        }
    }

    public static void  showMatrix(int[][] array){
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}