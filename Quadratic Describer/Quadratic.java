//gets description for quadratic function
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		if (a == 0) throw new IllegalArgumentException("This is not a quadratic equation!");
		String open = "Upward";
		if(a < 0) {
			open = "Downward";
		}
		double xvertex = -b/(2 * a);
		double yvertex = (a * Calculate.square(xvertex)) + (b * xvertex) + c;
		String xint = Calculate.quadForm(a, b, c);
		return "Opens: " + open + "\nVertex: (" + xvertex + ", " + yvertex +")" + "\nX-intercept(s): " + xint + "\nY-intercept: " + c + "\n";
		
	}
}
