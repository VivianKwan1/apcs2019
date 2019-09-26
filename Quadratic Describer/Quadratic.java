//gets description for quadratic function
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		if (a == 0) throw new IllegalArgumentException("This is not a quadratic equation!");
		String open = "Upward";
		if(a < 0) {
			open = "Downward";
		}
		double xvertex = -b/(2 * a);
		double yvertex = (a * square(xvertex)) + (b * xvertex) + c;
		String xint = quadForm(a, b, c);
		return "Description of the graph of " + a + "x^2 + " + b + "x + " + c + "\n\nOpens: " + open + "\nAxis of Symmetry: " + round2(xvertex) + "\nVertex: (" + round2(xvertex) + ", " + round2(yvertex) +")" + "\nX-intercept(s): " + xint + "\nY-intercept: " + c + "\n";
		
	}
	//approximate real roots of quadratic equation with doubles
	public static String quadForm(double a, double b, double c) {
		if (discriminant(a, b, c) < 0) {
			return "No real roots";
		} else {
			double root1 = (-b + sqrt(discriminant(a, b, c)))/(2 * a);
			double root2 = (-b - sqrt(discriminant(a, b, c)))/(2 * a);
			if (root1 == root2) {
				return round2(root1) + "";
			} else {
				return (round2(root1) + " and " + round2(root2));
			}
		}
	}
	
	//finds approximate square root
	public static double sqrt(double num) {
		if (num < 0) throw new IllegalArgumentException("Cannot compute square root of negative numbers.");
		double sqrt = 0;
		while (sqrt * sqrt - num > 0.005 || sqrt * sqrt - num < -0.005) {
			sqrt += 0.00001;
		}
		return round2(sqrt);
	}
	
	//rounds to two decimal places
	public static double round2(double num) {
		num = num * 100;
		if (num < 0) {
			num -= 0.5;
		} else {
			num += 0.5;
		}
		double numInt = (int) num;
		return numInt/100;
	}
	
	//returns discriminant of 3 numbers
	public static double discriminant(double a, double b, double c) {
		return (b * b) + (-4 * a * c);
	}
	
	//squares double 
	public static double square(double num) {
		return num * num;
	}
}
