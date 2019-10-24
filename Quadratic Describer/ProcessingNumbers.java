//Vivian Kwan
//APCS Period 3
//October 2, 2019
//Returns min, max, sum of even numbers, and largest even number from a set of numbers provided by the user

import java.util.*;
public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers would you like to input?");
		int runs = input.nextInt();
		while(runs <= 0) {
			System.out.println("Please input a number greater than 0.");
			runs = input.nextInt();
		}
		System.out.println("1:");
		int num = input.nextInt();
		int max = num;
		int min = num;
		int evenMax = -1000000000;
		int evenSum = 0;
		int evenNums = 0;
		if (num % 2 == 0) {
			evenSum = num;
		}
		for (int i = 0; i < runs - 1; i++) {
			System.out.println(i + 2 + ": ");
			num = input.nextInt();
			if (num > max) {
				max = num;
			} else if (num < min) {
				min = num;
			}
			if (num % 2 == 0) {
				evenSum += num;
				evenNums += 1;
				if (num > evenMax) {
					evenMax = num;
				}
			}
		}
		System.out.println("Smallest Number: " + min);
		System.out.println("Largest Number: " + max);
		if (evenNums == 0) {
			System.out.println("No even numbers. ");
		} else {
			System.out.println("Sum of Even Numbers: " + evenSum);
			System.out.println("Largest Even Number: " + evenMax);
		}
		input.close();
	}
}