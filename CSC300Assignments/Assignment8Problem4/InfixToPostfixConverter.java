import java.util.*;

public class InfixToPostfixConverter
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("Please enter an infix expression:\n");
        String infixExpression = keyboard.nextLine();
        
        System.out.printf("The original infix expression is:\n");
        System.out.println(infixExpression);
        
        String postfixExpression = convertToPostfix(infixExpression);
        
        System.out.printf("The expression in postfix notation is:\n");
        System.out.println(postfixExpression);
        
        keyboard.close();
    }

    public static String convertToPostfix(String infix)
    {
        Stack<Character> charStack = new Stack<>();
        
        StringBuilder postfixExpression = new StringBuilder();

        infix = "(" + infix + ")";
        charStack.push('(');

        for (char c : infix.toCharArray())
        {
            if (Character.isDigit(c))
                postfixExpression.append(c).append(" ");
            else if (c == '(')
                charStack.push(c);
            else if (isOperator(c))
            {
                while (isOperator(charStack.peek()) && precedence(c, charStack.peek()))
                {
                    postfixExpression.append(charStack.pop()).append(" ");
                }
                charStack.push(c);
            }
            else if (c == ')')
            {
                while (charStack.peek() != '(')
                {
                    postfixExpression.append(charStack.pop()).append(" ");
                }
                charStack.pop();
            }
        }
        return postfixExpression.toString().trim();
    }

    public static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    public static boolean precedence(char op1, char op2)
    {
        Map<Character, Integer> precedenceMap = new HashMap<>();
        precedenceMap.put('^', 3);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('%', 2);
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);

        return precedenceMap.get(op1) <= precedenceMap.get(op2);
    }
}
