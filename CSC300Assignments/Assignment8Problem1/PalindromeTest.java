import java.util.Scanner;
import java.util.Stack;

public class PalindromeTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < 4; i++)
        {
	        System.out.printf("Enter any string:\n");
	        String input = scanner.nextLine();
	
	        if (isPalindrome(input))
	        	System.out.printf("The input String is a palindrome.\n");
	        else
	        	System.out.printf("The input String is not a palindrome.\n");
        }
        
        scanner.close();
    }

    private static boolean isPalindrome(String str)
    {
        String formattedStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < formattedStr.length(); i++)
        	stack.push(formattedStr.charAt(i));
        
        for (int i = 0; i < formattedStr.length(); i++)
        {
            if (stack.pop() != formattedStr.charAt(i))
                return false; 
        }
        
        return true; 
    }
    
}
