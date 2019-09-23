//Vivian Kwan
//APCS Period 3
//September 13, 2019
//Handles user interactions for the Quadratic Describer project

import java.util.Scanner;
public class QuadraticClient {
	public static void main(String[] args) {
		boolean repeat = true;
			while (repeat) {
			Scanner input = new Scanner(System.in);
			System.out.println("a: ");
			double a = input.nextDouble();
			System.out.println("b: ");
			double b = input.nextDouble();
			System.out.println("c: ");
			double c = input.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("Continue? (enter \"quit\" to exit.)");
			String keepGoing = input.next();
			if (keepGoing.equals("quit")) {
				repeat = false;
			}
			input.close();
		}
	}

}
