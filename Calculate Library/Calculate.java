//Vivian Kwan
//APCS Period 3
//August 29, 2019
//library of math functions

public class Calculate {
	//squares int
	public static int square(int num) {
		return num * num;
	}
	
	//squares double 
	public static double square(double num) {
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
	public static String toImproperFrac(int whole, int numer, int denom) {
		int newnumer = whole * denom + numer;
//		String mixed = newnumer + "/" + denom;
		return Integer.toString(newnumer) + "/" + Integer.toString(denom);
	}
	
	//converts improper fraction to a mixed number
	public static String toMixedNum(int numer, int denom) {
		if (denom == 0) throw new IllegalArgumentException("Cannot divide by 0");
		int newNumer = numer % denom;
		int wholeNum = numer / denom;
		return Integer.toString(wholeNum) + "_" + Integer.toString(newNumer) + "/" + Integer.toString(denom);
	}
	
	//foils a binomial
	public static String foil(int coeff1, int num1, int coeff2, int num2, String var) {
		int a = coeff1 * coeff2;
		int b = coeff1 * num2 + num1 * coeff2;
		int c = num2 * num1;
		return Integer.toString(a) + var + "^2 + " + Integer.toString(b) + var + " + " + Integer.toString(c);
	}
	
	//checks if a number is divisible by another
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (divisor == 0) throw new IllegalArgumentException("Cannot divide by 0.");
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
	
	//rounds to two decimal places
	public static double round2(double num) {
		num = num * 100 + 0.5;
		double numInt = (int) num;
		return numInt/100;
	}
	
	//returns result of number and exponent
	public static double exponent(double base, int exponent) {
		if (exponent < 0) throw new IllegalArgumentException("Cannot compute negative exponent.");
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	//returns factorial of number
	public static int factorial(int num) {
		if (num < 0) throw new IllegalArgumentException("Cannot compute factorial of negative numbers.");
		for (int i = num - 1; i > 1; i--) {
			num *= i;
		}
		return num;
	}
	
	//says whether number is prime or not
	public static boolean isPrime(int num) {
		for (int i = num -1; i > 1; i--) {
			if (isDivisibleBy(num, i)) {
				return false;
			}
		}
		return true;
	}
	
	//finds greatest common factor
	public static int gcf(int num1, int num2) {
		for (int i = min(num1, num2); i > 1; i--) {
			if (isDivisibleBy(num1, i)) {
				if (isDivisibleBy(num2, i)) {
					return i;
				}
			}
		}
		return 1;
	}
	
	//finds approximate square root
	public static double sqrt(double num) {
		if (num < 0) throw new IllegalArgumentException("Cannot compute square root of negative numbers.");
//		double sqrt = 0;
//		while (sqrt * sqrt - num > 0.005 || sqrt * sqrt - num < -0.005) {
//			sqrt += 0.00001;
//		}
//		return round2(sqrt);
		double N = 1;
		double A = num/2;
		while (!(A - N < 0.005)) {
			N = A - (A * A - num)/(num);
			A = N;
		}
		return round2(N);
	}
	
	//approximate real roots of quadratic equation with ints
	public static String quadForm(int a, int b, int c) {
		if (discriminant(a, b, c) < 0) {
			return "No real roots";
		} else {
			double root1 = (-b + sqrt(discriminant(a, b, c)))/(2 * a);
			double root2 = (-b - sqrt(discriminant(a, b, c)))/(2 * a);
			if (root1 == root2) {
				return round2(root1) + "";
			} else {
				return round2(root1) + " and " + round2(root2);
			}
		}
	}
	
}
