package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	boolean repeat = true;
    	System.out.println("What would you like to calculate?");
    	String expression = input.next();
    	while (repeat) {
    		if (!(expression.equals("quit"))) {
    			repeat = false;
    		}
       	}
    	System.out.println(produceAnswer(expression));
    	input.close();
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
        String[] splitEx = input.split(" ");
		int[] numAndDenom = fracNumbers(splitEx);
    	return splitEx[2];
    }
    
    public static int[] fracNumbers (String[] frac) {
    	int[] numAndDenoms = new int[frac.length + 1];
    	for (int i = 0; i < frac.length - 1; i+=2){
    		if (frac[i].indexOf("/")==-1) {
    			String[] splitFrac = frac[i].split("/");
    			numAndDenoms[i] = Integer.parseInt(splitFrac[0]);
    			numAndDenoms[i+1] = Integer.parseInt(splitFrac[1]);
    		}
    	}
    	return numAndDenoms;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
     
}

/* initiate scanner
 * get string
 * check valid input - method
 * split on space, return array - method
 * parse operands for numbers - int array
 * convert input numbers to improper fractions or integer, simplify - method
 * store numbers (2 int arrays?)
 * store operation as char or string
 * do the operation - separate methods
 * 		add - multiply fractions by other denominator, add two numerators, return new fraction as int[]
 * 			
 * 		sub - multiply fractions by other denominator, subtract, return
 * 		mult - multiply numerator and denominator, return
 * 		div - multiply opposite numerator and denominator, return
 * simplify and change answer to mixed num or keep as int or fraction(if statement)
 */
