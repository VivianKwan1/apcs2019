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
			String a = input.next();
			System.out.print("b: ");
			String b = input.next();
			System.out.print("c: ");
			String c = input.next();
			
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
