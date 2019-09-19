//gets description for quadratic function
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		if (a == 0) throw new IllegalArgumentException("This is not a quadratic equation!");
		String open = "upward";
		if(a < 0) {
			open = "downward";
		}
		double xvertex = -b/(2 * a);
		double yvertex = (a * Calculate.square(xvertex)) + (b * xvertex) + c;
		return "This string opens " + open + ". The vertex is at " + xvertex + ", " + yvertex +"). The x-intercept is at " + " and the y-intercept is at " + c + ".";
		
	}
}
