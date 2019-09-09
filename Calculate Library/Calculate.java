//Vivian Kwan
//APCS Period 3
//August 29, 2019
//library of math functions

public class Calculate {
	//squares a number
	public static int square(int num) {
		return num * num;
	}
	
	//cubes a number
	public static int cube(int num) {
		return num * num * num;
	}
	
	//returns the average of 2 numbers
	public static double average(double num1, double num2) {
		return (num1 + num2)/2;
	}
	
	//returns the  average of 3 numbers
	public static double average(double num1, double num2, double num3) {
		return (num1 + num2 + num3)/3;
	}
	
	//converts radians to degrees
	public static double toDegrees(double radians) {
		return radians*(180/3.14159);
	}
	
	//converts degrees to radians
	public static double toRadians(double degrees) {
		return degrees*(3.14159/180);
	}
	
	//returns discriminant of 3 numbers
	public static double discriminant(double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	//converts mixed number to improper fraction
	public String toImproperFrac(int whole, int numer, int denom) {
		int newnumer = whole * denom + numer;
//		String mixed = newnumer + "/" + denom;
		return Integer.toString(newnumer) + "/" + Integer.toString(denom);
	}
	
	//checks if a number is divisible by another
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (dividend % divisor == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//returns absolute value
	public static double absValue(double num) {
		if (num < 0) {
			return num/-1;
		}else {
			return num;
		}
	}
		
	//returns larger of 2 numbers
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	//returns largest of 3 numbers
	public static double max(double num1, double num2, double num3) {
		if (num1 >= num2 && num1 >= num3) {
				return num1;
		} else if (num2 >= num1 && num2 >= num3) {
				return num2;
		} else {
			return num3;
		}
	}
	
	//returns smaller of 2 numbers
	public static int min(int num1, int num2) {
		if (num1 < num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	//mult 100, add.5, cast int, div 100
	public static double round2(double num) {
		return ((int) (num * 100 + 0.5)/100);
	}
	
	//returns result of number and exponent
	public static double exponent(double base, int exponent) {
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
}
