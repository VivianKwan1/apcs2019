//Vivian Kwan
//APCS Period 3
//August 29, 2019
//Call the code from the Calculate class
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(-5));
		System.out.println(Calculate.cube(-7));
		System.out.println(Calculate.average(2, 8));
		System.out.println(Calculate.average(2, 6, 12));
		System.out.println(Calculate.toDegrees(7));
		System.out.println(Calculate.toRadians(7));
		System.out.println(Calculate.discriminant(1, 5, -7));
		System.out.println(Calculate.toImproperFrac(1, 5, 2));
		System.out.println(Calculate.toMixedNum(8, 3));
		System.out.println(Calculate.foil(1, 5, 1, -7, "x"));
		System.out.println(Calculate.isDivisibleBy(9, 3));
		System.out.println(Calculate.absValue(7));
		System.out.println(Calculate.max(-5, -7));
		System.out.println(Calculate.max(1, -5, -7));
		System.out.println(Calculate.min(-5, -7));
		System.out.println(Calculate.round2(7.424673322));
		System.out.println(Calculate.exponent(5, 3));
		System.out.println(Calculate.factorial(7));
		System.out.println(Calculate.isPrime(17));
		System.out.println(Calculate.gcf(15, 35));
		System.out.println(Calculate.sqrt(11.1));
		System.out.println(Calculate.quadForm(1, -5, -7));
	}

}
