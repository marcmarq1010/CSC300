
public class LambdaPowers
{
	public static void main(String[] args)
	{
		
	}
	
	public static void input()
	{
		System.out.printf("Please enter two values as type double: ");
	}
	
	public static void output()
	{
		System.out.printf("Without return the power is %.2f");
		
		System.out.printf("With return the power is %.2f");
	}
}

/*	
	Write a simple class LambdaPowers with a main method that implements the interface
	so that it returns the result of raising he first variable to the power of the second.
	
	The interface should be implemented two ways.
	e1 creates a function without a return statement.
	e2 creates a function with a return statement inside the lambda expression. 
	For each case read in the inputs.
	
	Write simple output statements to demonstrate the two functions.
	
	Sample input/output:
	Please enter two values as type double: 3.0 4.1
	Without return the power is 90.406  
	Please enter two values as type double: 64 .33
	With return the power is 3.945
*/