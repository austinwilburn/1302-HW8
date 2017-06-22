//Palindrome.java by Austin Wilburn, austinwilburn93@gmail.com
//The program takes a word as input and tests if it is a palindrome
//first using iteration then recursion.
import java.util.Scanner;
public class Palindrome {
	//main method
	public static void main(String[] args) {
		//create a scanner and store the word
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word to test: ");
		String userWord = sc.next();
		//create new palindrome object
		Palindrome palindrome = new Palindrome();
		//if the iteration method returns true
		if(palindrome.isIterationPalindrome(userWord) == true)
			//its a palindrome
			System.out.println("Iteration says it IS a Palindrome");
		else
			//its NOT a palindrome
			System.out.println("Iteration says it is NOT a Palindrome");
		//if the recursive method returns true
		if(palindrome.isRecursivePalindrome(userWord) == true)
			//its a palindrome
			System.out.println("Recursion says it IS a Palindrome");
		else
			//its NOT a palindrome
			System.out.println("Recursion says it is NOT a Palindrome");
		sc.close();

	}
//iteration method that returns true or false
	public boolean isIterationPalindrome(String str){
		//store the length of the original string
		int length = str.length();
		//set to true
		boolean isPalindrome = true;
		//loop through the string
		for(int x = 0;x < str.length(); x++){
			//if character at x and opposite of x are NOT the same
			if(!(str.charAt(x) == str.charAt(str.length() - (x+1))))
				//set it to false
				isPalindrome = false;
		}
	//return the boolean
	return isPalindrome;
	}
	//recursive method that returns true or false
	public boolean isRecursivePalindrome(String str){
		//if the length is only 1
		if(str.length() == 1)
			//its true
			return true;
		//if beginning character is equal to last
		else if(str.charAt(0) == str.charAt(str.length() - 1))
			//return a substring minus the part already tested
			return isRecursivePalindrome(str.substring(1,str.length() -1));
		else
			//otherwise return false
			return false;
	}
}
