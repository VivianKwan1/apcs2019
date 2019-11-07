//Vivian Kwan
//APCS 3rd Period
//October 21, 2019
//splits a string at a given word
//returns ingredients of a "sandwich"

public class Split {
	public static void main(String[] args) {
		System.out.println(sandwichSpace("applespineapplesbreadlettucetomatobaconmayohambreadcheese"));
	}
	
//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array

// Example: "I like apples!".split(" ");

// it will split at spaces and return an array of ["I","like","apples!"]

// Example 2: "I really like really red apples!".split("really")

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

//play around with String.split!

//What happens if you "I reallyreally likeapples".split("really") ?
	 
		

//Your task Part 1:

/*Write a method that take in a string like

* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

* describing a sandwich.

* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

* the sandwich and ignores what's on the outside

* What if it's a fancy sandwich with multiple pieces of bread?

*/

	public static String sandwich(String sandwich) {
		if (sandwich.split("bread").length < 2) {
			return "Not a sandwich";
		}
		String inside = sandwich.substring(sandwich.indexOf("bread") + 5);
		while(!inside.endsWith("bread")) {
			inside = inside.substring(0, inside.length() - 1);
		}
		inside = inside.substring(0, inside.length() - 5);
		return inside;
	}
//Your task pt 2:

	public static String sandwichSpace(String sandwich) {
		if (sandwich.split("bread").length < 2) {
			return "Not a sandwich";
		}
		String inside = sandwich.substring(sandwich.indexOf("bread") + 5);
		while(!inside.endsWith("bread")) {
			inside = inside.substring(0, inside.length() - 1);
		}
		inside = inside.substring(0, inside.length() - 5);
		String[] insideArr = inside.split(" ");
		String insideReturn = "";
		for (int i = 0; i < insideArr.length; i++) {
			insideReturn += insideArr[i];
			insideReturn += " ";
		}
		return insideReturn;
	}
/*Write a method that take in a string like

* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

* describing a sandwich

* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

* the sandwich and ignores what's on the outside.

* Again, what if it's a fancy sandwich with multiple pieces of bread?

*/

}


