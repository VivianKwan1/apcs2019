//Vivian Kwan
//APCS Period 3
//September 13, 2019
//Handles user interactions for the Quadratic Describer project

import java.util.Scanner;
public class QuadraticClient {
	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		System.out.println("Enter a value for a.");
		double a = num.nextDouble();
		System.out.println("Enter a value for b.");
		double b = num.nextDouble();
		System.out.println("Enter a value for c.");
		double c = num.nextDouble();
		quadrDescriber(a, b, c);
	}

}
