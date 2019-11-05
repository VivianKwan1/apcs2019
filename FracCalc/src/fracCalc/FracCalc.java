package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner input = new Scanner(System.in);
    	boolean repeat = true;
    	while (repeat) {
        	System.out.println("What would you like to calculate? Type \"quit\" to exit.");
        	String expression = input.nextLine();
    		if (expression.equals("quit")) {
    			repeat = false;
    		} else {
    			System.out.println(produceAnswer(expression));
    		}
       	}
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
        String result = "";
        if (splitEx[1].equals("+")) {
        	result = simplify(add(fracNumbers(splitEx)));
        } else if (splitEx[1].equals("-")) {
        	result = simplify(subtract(fracNumbers(splitEx)));
        } else if (splitEx[1] == ("*")) {
        	result = simplify(multiply(fracNumbers(splitEx)));
        } else {
        	result = simplify(divide(fracNumbers(splitEx)));
        }
//		int[] numAndDenom = fracNumbers(splitEx);
//    	return splitEx[splitEx.length-1];
		return result;
//		return Arrays.toString(fracNumbers(splitEx));
    }
    
    public static int[] fracNumbers (String[] frac) {
    	int[] numAndDenoms = new int[frac.length + 1];
    	for (int i = 0; i < frac.length; i+=2){
        	System.out.println(Arrays.toString(numAndDenoms));

    		if (frac[i].indexOf("/")!=-1) {
    			String[] splitFrac = frac[i].split("/");
    			if (splitFrac[0].indexOf("_") != -1) {
        			String[] mixedNumSplit = splitFrac[0].split("_");
        			splitFrac[0] = Integer.toString(Integer.parseInt(mixedNumSplit[0]) * Integer.parseInt(frac[2]) + Integer.parseInt(mixedNumSplit[2]));
    			}
    			numAndDenoms[i] = Integer.parseInt(splitFrac[0]);
    			numAndDenoms[i+1] = Integer.parseInt(splitFrac[1]);
    		} else {
    			numAndDenoms[i] = Integer.parseInt(frac[i]);
    			numAndDenoms[i+1] = 1;
    		}
    	}
    	System.out.println(Arrays.toString(numAndDenoms));
    	return numAndDenoms;
    }

    public static int[] add (int[] operands) {
    	System.out.println("yes");

    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int commonDenom = denom1 * denom2;
    	int numer = (denom2 * numer1) + (denom1 * numer2);
    	int[] newFrac = {numer, commonDenom};
    	System.out.println(Arrays.toString(newFrac));
    	return newFrac;
    }
    
    public static int[] subtract (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int commonDenom = denom1 * denom2;
    	int numer = (denom2 * numer1) - (denom1 * numer2);
    	int[] newFrac = {numer, commonDenom};
    	return newFrac;
    }
    
    public static int[] multiply (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int[] newFrac = {numer1 * numer2, denom1 * denom2};
    	return newFrac;
    }
    
    public static int[] divide (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int[] newFrac = {numer1 * denom2, numer2 * denom1};
    	return newFrac;
    }
    
    public static String simplify (int[] impropFrac) {
    	int numer = impropFrac[0];
    	int denom = impropFrac[1];
    	if (denom == 1) {
    		return Integer.toString(numer);
    	} else if (numer % denom == 0) {
    		return Integer.toString(numer/denom);
    	} else if (numer > denom) {
    		return (numer/denom + "_" + numer%denom + "/" + denom);
    	} else {
    		return numer + "/" + denom;
    	}
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
     
}

/* initiate scanner
 * get string
 * split on space, return array - method
 * parse operands for numbers - int array
 * convert input numbers to improper fractions or integer, simplify - method
 * do the operation - separate methods
 * 		add - multiply fractions by other denominator, add two numerators, return new fraction as int[]
 * 			take int array with 4 ints, (numer1, denom1, numer2, denom2), mult numer1 and denom1 
 * 			by denom2, mult numer 2 and denom2 by denom 1, add numer1 and numer2, return sum
 * 		sub - multiply fractions by other denominator, subtract, return
 * 			take int array with 4 ints, (numer1, denom1, numer2, denom2), mult numer1 and denom1 
 * 			by denom2, mult numer 2 and denom2 by denom 1, numer1 minus numer2, return difference
 * 		mult - multiply numerator and denominator, return
 * 			int array with 4 ints, (numer1, denom1, numer2, denom2), mult numerators,
 * 			mult denominators, return numerator/denominator
 * 		div - multiply opposite numerator and denominator, return
 * 			int array with 4 ints, (numer1, denom1, numer2, denom2), mult numer1 and denom2 (top),
 * 			mult numer2 and denom1 (bot), return top/bot
 * simplify and change answer to mixed num or keep as int or fraction(if statement)
 */
