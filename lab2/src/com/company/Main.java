package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int negSum = 0, sum = 0, negativeCount = 0, minValue = 5;

		System.out.print("Сколько целых чисел вы собираетесь ввести? ");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		if (size == 0) {
			System.out.print("Программа завершена.");
			System.exit(0);
		}
		int[] sourceNumbers = new int[size];
		System.out.print("Введите целые числа через пробел "
				+ "и нажмите <Enter>: ");
		for (int i = 0; i < size; i++) {
			sourceNumbers[i] = in.nextInt();
		}

		//Находим положительные элементы массива
		System.out.print("Положительные числа массива: " );
		for (int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i]>0){
				System.out.print(sourceNumbers[i] + " ");
			}
		}

		//Находим сумму элементов больше чем число 3
		for(int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i]>3){
				sum=sum+sourceNumbers[i];
			}
		}
		System.out.println("\nСумма чисел больше 3: " + sum);

		//Вывод самого большого элемента массива
		System.out.println("Самый большой елемент: " + Arrays.stream(sourceNumbers).max().getAsInt());

		//К-во отрицательных чисел в массиве
		for(int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i]<0) negativeCount++;
		}
		System.out.println("Количество отрицательных чисел: " + negativeCount);

		//сумма этих элементов
		for(int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i]<0)negSum=negSum+sourceNumbers[i];
		}
		System.out.println("Сумма отрицательных чисел: " + negSum);

		for(int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i] % 5 == 0){
				minValue = sourceNumbers[i];
			}
		}

		for (int i = 0; i < sourceNumbers.length; i++){
			if(sourceNumbers[i] < minValue && sourceNumbers[i] % 5 == 0){
				minValue = sourceNumbers[i];
			}
		}
		System.out.println("Минимальное кратное: " + minValue);

	}
}