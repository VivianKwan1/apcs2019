//Vivian Kwan
//APCS Period 3
//October 29, 2019
//does basic operations with fractions

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
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
    public static String produceAnswer(String input) { 
        String[] splitEx = input.split(" ");
        //check spacing issues/missing operands or operator issues
        if (!errorScanning(splitEx)) {
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
    	//checks if alphabetical
    	for(int i = 0; i < splitEx.length - 1; i++) {
    		for(int j = 0; j < splitEx[i].length(); j++) {
    			char c = splitEx[i].charAt(j);
    			if ((c >= 'A' && c <= 'Z') && (c >= 'a' && c <= 'z')) {
    				valid = false;
    			}
    		}
    	}
    	//checks if not enough spacing aka not enough operands or no operator
    	if (splitEx.length < 3) {
    		valid = false;
    	}
    	return valid;
    }
    //splits into numerator and denominator for improper fractions to do operations
    public static int[] fracNumbers (String[] frac) {
    	int[] numAndDenoms = new int[frac.length + 1];
    	for (int i = 0; i < frac.length; i += 2) {
        	//fraction processing
    		if (frac[i].indexOf("/") != -1) {
    			String[] splitFrac = frac[i].split("/");
    			//frac error processing
    			if (!isInt(splitFrac[splitFrac.length - 1]) || splitFrac.length < 2) {
    				return numAndDenoms;
    			}
    			//mixed num processing
    			if (splitFrac[0].indexOf("_") != -1) {
        			String[] mixedNumSplit = splitFrac[0].split("_");
        			//mixed num error processing, checks for invalid mixed num format
        			if (mixedNumSplit.length < 2 || !isInt(mixedNumSplit[1]) || mixedNumSplit[0].equals("") || mixedNumSplit[1].equals("")) {
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
    		}
    	}
    	return numAndDenoms;
    }
    //add
    public static int[] add (int[] operands) {
    	int numer1 = operands[0];
    	int denom1 = operands[1];
    	int numer2 = operands[2];
    	int denom2 = operands[3];
    	int commonDenom;
   		commonDenom = denom1 * denom2;
    	int numer = (denom2 * numer1) + (denom1 * numer2);
    	int[] newFrac = {numer, commonDenom};
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
    	return newFrac;
    }
    
    public static String simplify (int[] impropFrac) {
    	int numer = impropFrac[0];
    	int denom = impropFrac[1];
    	int smallerNum = Math.min(Math.abs(numer), Math.abs(denom));
    	//reduce
    	for (int i = smallerNum; i > 0; i--) {
    		if (numer % i == 0 && denom % i == 0) {
    			numer /= i;
    			denom /= i;
    		}
    	}
    	//checks div 0 
    	if (denom == 0) {
    		return "Error: Invalid Expression";
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
    		return (numer/denom + "_" + Math.abs(numer%denom) + "/" + denom);
    	//frac
    	} else {
    		return numer + "/" + denom;
    	}
    }
    //checks int
    public static boolean isInt(String num) {
      int base = 0;
  	  if(num.charAt(0) == '-') {
  		  base = 1;
  	  }
  	  for(int i = base; i < num.length(); i++) {
  		  if (!(Character.isDigit(num.charAt(i)))) {
  			  return false;
  		  }
  	  }
  	  return true;
    }
         
}