//Vivian Kwan
//APCS Period 3
//October 29, 2019
//does basic operations with fractions

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
    		//manages error returns
    		} else if (!produceAnswer(expression).equals("error")){
    			System.out.println(produceAnswer(expression));
    		} else {
    			System.out.println("Error: Invalid Input");
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
        //check spacing issues/missing operands or operator issues
        if (errorScanning(splitEx)) {
        	return "error";
        }
        //gets numerators and denominators for operands
        int[] numbers = fracNumbers(splitEx);
        int[] result;
        //does operation
        if (splitEx[1].equals("+")) {
        	result = add(numbers);
        } else if (splitEx[1].equals("-")) {
        	result = subtract(numbers);
        } else if (splitEx[1].equals("*")) {
        	result = multiply(numbers);
        } else {
        	result = divide(numbers);
        }
        //simplifies result of operation and returns final answer
        return simplify(result);
    }
    //check for short expressions and some invalid expressions
    public static boolean errorScanning(String[] splitEx) {
    	boolean valid = true;
    	for(int i = 0; i < splitEx.length - 1; i++) {
    		for(int j = 0; j < splitEx[i].length(); j++) {
    			char c = splitEx[i].charAt(j);
    			if (!(c <= 'A' && c >= 'Z') && !(c <= 'a' && c >= 'z')) {
    				valid = false;
    			}
    		}
    	}
    	if (splitEx.length < 3) {
    		valid = false;
    	}
    	return valid;
    }
    //splits into numerator and denominator for improp fracs to do operations
    public static int[] fracNumbers (String[] frac) {
    	int[] numAndDenoms = new int[frac.length + 1];
    	for (int i = 0; i < frac.length; i += 2){
        	System.out.println(Arrays.toString(frac));
        	//fraction processing
    		if (frac[i].indexOf("/") != -1) {
    			String[] splitFrac = frac[i].split("/");
    			System.out.println(Arrays.toString(splitFrac));
    			//frac error processing
    			if (!isInt(splitFrac[splitFrac.length - 1]) || splitFrac.length < 2) {
        			System.out.println(Arrays.toString(splitFrac));
    				return numAndDenoms;
    			}
    			//mixed num processing
    			if (splitFrac[0].indexOf("_") != -1) {
    				System.out.println(":/");
        			String[] mixedNumSplit = splitFrac[0].split("_");
        			//mixed num error processing
        			System.out.println(Arrays.toString(mixedNumSplit));
        			if (mixedNumSplit.length < 2 || !isInt(mixedNumSplit[1]) || mixedNumSplit[0].equals("") || mixedNumSplit[1].equals("")) {
            			System.out.println(Arrays.toString(splitFrac) + "yes");
            			return numAndDenoms;
        			}
        			//get whole num
        			int wholeNum = Integer.parseInt(mixedNumSplit[0]);
        			//split numerator and denominator
        			String[] splitMixedFrac = frac[i].split("/");
        			String numer = mixedNumSplit[1];
        			String denom = splitMixedFrac[1];
        			//set up improper fraction numerator
        			if (wholeNum < 0) {
            			splitFrac[0] = Integer.toString(wholeNum * (Integer.parseInt(denom)) - Integer.parseInt(numer));
        			} else {
        				splitFrac[0] = Integer.toString(wholeNum * (Integer.parseInt(denom)) + Integer.parseInt(numer));
    			    
        			}
    			} 
    			//improper fraction put into returned array
    			numAndDenoms[i] = Integer.parseInt(splitFrac[0]);
    			numAndDenoms[i+1] = Integer.parseInt(splitFrac[1]);
    		//integer processing
    		} else if (isInt(frac[i])){
    			numAndDenoms[i] = Integer.parseInt(frac[i]);
    			numAndDenoms[i+1] = 1;
    			System.out.println(Arrays.toString(numAndDenoms) + ":(");
    		//idk what this is for
    		} else {
    			System.out.println(":|");
    			return numAndDenoms;
    		}
    	}

    	return numAndDenoms;
    }
//    
//    public static int[] fracNumbers (String[] frac) {
//    	int[] numAndDenoms = new int[frac.length + 1];
//    	for (int i = 0; i < frac.length; i+=2){
//        	System.out.println(Arrays.toString(frac));
//        	//fraction processing
//    		if (frac[i].indexOf("/") != -1) {
//    			String[] splitFrac = frac[i].split("/");
//    			//mixed num processing
//    			if (splitFrac[0].indexOf("_") != -1) {
//        			String[] mixedNumSplit = splitFrac[0].split("_");
//        			if (mixedNumSplit.length < 2) {
//        				return numAndDenoms;
//        			}
//        			int wholeNum = Integer.parseInt(mixedNumSplit[0]);
//        			String[] splitMixedFrac = frac[i].split("/");
//        			String numer = mixedNumSplit[1];
//        			String denom = splitMixedFrac[1];
//        			if (wholeNum < 0) {
//            			splitFrac[0] = Integer.toString(wholeNum * (Integer.parseInt(denom)) - Integer.parseInt(numer));
//        			} else {
//        				splitFrac[0] = Integer.toString(wholeNum * (Integer.parseInt(denom)) + Integer.parseInt(numer));
//    			
//        			}
//    			} 
//    			numAndDenoms[i] = Integer.parseInt(splitFrac[0]);
//    			numAndDenoms[i+1] = Integer.parseInt(splitFrac[1]);
//    		} else {
//    			numAndDenoms[i] = Integer.parseInt(frac[i]);
//    			numAndDenoms[i+1] = 1;
//    		}
//    	}
//    	System.out.println(Arrays.toString(numAndDenoms));
//    	return numAndDenoms;
//    }
    //add
    public static int[] add (int[] operands) {
    	System.out.println(Arrays.toString(operands) + "yes");
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int commonDenom;
    	if (denom1 == 1) {
    		commonDenom = denom2;
    	} else if (denom2 == 1) {
    		commonDenom = denom1;
    	} else {
    		commonDenom = denom1 * denom2;
    	}
    	int numer = (denom2 * numer1) + (denom1 * numer2);
    	int[] newFrac = {numer, commonDenom};
    	System.out.println(Arrays.toString(newFrac));
    	return newFrac;
    }
    //subtract
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
    //multiply
    public static int[] multiply (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	System.out.println(numer1 + denom1 + numer2 + denom2);
    	int newNumer = numer1 * numer2;
    	int newDenom = denom1 * denom2;
    	int[] newFrac = {newNumer, newDenom};
    	return newFrac;
    }
    //divide
    public static int[] divide (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int newNumer = numer1 * denom2;
    	int newDenom = numer2 * denom1;
    	if (denom2 == 0) {
    		newDenom = 0;
    	}
    	int[] newFrac = {newNumer, newDenom};
    	System.out.println(Arrays.toString(newFrac));
    	return newFrac;
    }
    
    public static String simplify (int[] impropFrac) {
    	int numer = impropFrac[0];
    	int denom = impropFrac[1];
    	int smallerNum = Math.min(Math.abs(numer), Math.abs(denom));
    	//reduce
    	for (int i = smallerNum; i > 0; i--) {
    		if (numer % i == 0 && denom % i == 0) {
    			System.out.println(i);
    			numer /= i;
    			denom /= i;
    		}
    	}
    	if (denom == 0) {
    		return "Invalid expression.";
    	}
    	//negative denom check
    	if(denom < 1) {
    		denom /= -1;
    		numer /= -1;
    	}
    	//checks int
    	if (denom == 1) {
    		return Integer.toString(numer);
    	//checks reduce to whole num 
    	} else if (numer % denom == 0) {
    		return Integer.toString(numer/denom);
    	//checks improp frac
    	} else if (Math.abs(numer) > Math.abs(denom)) {
    		System.out.println(numer + denom);
    		return (numer/denom + "_" + Math.abs(numer%denom) + "/" + denom);
    	//frac
    	} else {
    		return numer + "/" + denom;
    	}
    }
    
    //checks int
    public static boolean isInt(String num) {
//    	String[] integers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9"};
//    	for (int i = 0; i < integers.length - 1; i++) {
//    		if (num.equals(integers[i])) {
//    			return true;
//    		}
//    	}
    	 try {
             Integer.parseInt(num);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
//    	return false;
    }
         
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
