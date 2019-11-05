import java.lang.Math;
import java.util.*;
public class Hourglass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What size would you like your hourglass to be? ");
		int size = input.nextInt();
		for (int i = size; i >= -size; i--) {
			if (Math.abs(i) == size) {
				System.out.print("|");
				for(int j = 0; j < 2 * (Math.abs(i)); j++){
					System.out.print("\"");
				}
				System.out.println("|");
			} else if (i == 0) {
				for (int j = 0; j < size; j ++){
					System.out.print(" ");
				}
				System.out.println("||");
			} else {
				if (i > 0) {
					for (int j = 0; j < size - i; j++) {
						System.out.print(" ");
					}
					System.out.print("\\");
					for (int j = 0; j < 2 * Math.abs(i); j++) {
						System.out.print(":");
					}
					System.out.println("/");
				} else {
					for (int j = 0; j < size + i; j++) {
						System.out.print(" ");
					}
					System.out.print("/");
					for (int j = 0; j < 2 * Math.abs(i); j++) {
						System.out.print(":");
					}
					System.out.println("\\");
				}
			}
		}
		input.close();
	}
}
