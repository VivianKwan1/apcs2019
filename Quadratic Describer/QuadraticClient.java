//Vivian Kwan
//APCS Period 3
//September 13, 2019
//Handles user interactions for the Quadratic Describer project

import java.util.Scanner;

public class QuadraticClient {
	public static void main(String[] args) {
		boolean repeat = true;
		Scanner input = new Scanner(System.in);
		while (repeat) {
			System.out.println("Welcome to Quadratic Describer.\nPlease input some numbers for coefficients a, b, and c.\n");
			System.out.print("a: ");
			while(!(input.hasNextDouble())) {
				System.out.print("That is not a number. Please try again. ");
				input.next();
			}
			double a = input.nextDouble();
			System.out.print("b: ");
			while(!(input.hasNextDouble())) {
				System.out.print("That is not a number. Please try again. ");
				input.next();
			}
			double b = input.nextDouble();
			System.out.print("c: ");
			while(!(input.hasNextDouble())) {
				System.out.print("That is not a number. Please try again. ");
				input.next();
			}
			double c = input.nextDouble();
			
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Continue? (enter \"quit\" to exit.)");
			String keepGoing = input.next();
			if (keepGoing.equals("quit")) {
				repeat = false;
			}
		}
		input.close();
	}

}
