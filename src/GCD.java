//GCD.java by Austin Wilburn, austinwilburn93@gmail.com
//The program takes two integers as input and then
//calculates the greatest common denominator between them
//first using iteration and then recursion
import java.util.*;
public class GCD {
	//main method
	public static void main(String[] args) {
		//new scanner for int input
		Scanner sc = new Scanner(System.in);
		//new GCD object
		GCD gcd = new GCD();
		//Take in first integer
		System.out.println("Enter first integer: ");
		int firstNumber = sc.nextInt();
		//Take in second integer
		System.out.println("Enter second integer: ");
		int secondNumber = sc.nextInt();
		//calculate the iteration GCD and store it
		int iterationGCD = gcd.iterationGCD(firstNumber,secondNumber);
		//if the value is greater than 0
		if(iterationGCD > 0)
			//print result
			System.out.println("The iteration GCD is: " + iterationGCD);
		else
			//print error
			System.out.println("Iteration: There is no GCD between the two numbers");
		//calculate recursive GCD and store it
		int recursionGCD = gcd.recursionGCD(firstNumber,secondNumber);
		//if the value is greater than 0
		if(recursionGCD > 0)
			//print result
			System.out.println("The recursion GCD is: " + recursionGCD);
		else
			//print error
			System.out.println("Recursion: There is no GCD between the two numbers");
		//close scanner
		sc.close();
		
		

	}
	//iteration method takes two ints as input
	public int iterationGCD(int a, int b){
		//sets the GCD to 0
		int iterationGCD = 0;
		//loops through until gets to the smaller value
		for(int x = 1; x <= a && x <= b; x++){
			//for each loop, checks x to see 
			//if it is a common denominator
			if(a % x == 0 && b % x == 0)
				//store it if so
				iterationGCD = x;
		}
		//return it
		return iterationGCD;
	}
	//recursion method for GCD
	public int recursionGCD(int a, int b){
		//if a is less than b
		if(a<b){
			//if b mod a is 0
			if(b % a == 0)
				//gcd is a
				return a;
			else
				//otherwise return the method with b subtracted by a
				return recursionGCD(a, b - a);
		}
		//if b is less than a
		else if(b<a){
			//if a mod b is 0
			if(a % b == 0)
				//gcd is b
				return b;
			else
				//otherwise return the method with a subtracted by b
				return recursionGCD(a - b, b);
		}
		//otherwise if a and b equal
		else
			//return a
			return a;
			
		
	}

}
