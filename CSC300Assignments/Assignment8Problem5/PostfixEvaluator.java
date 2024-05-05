import java.util.*;

public class PostfixEvaluator
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.printf("Please enter a postfix expression:\n");
        String postfixExpression = keyboard.nextLine();
        
        System.out.printf("The original postfix expression is:\n");
        System.out.println(postfixExpression);
        
        int result = evaluatePostfixExpression(postfixExpression);
        
        System.out.printf("The value of the expression is: %d\n", result);
        
        keyboard.close();
    }

    public static int evaluatePostfixExpression(String postfix)
    {
        Stack<Integer> stack = new Stack<>();
        StringBuilder number = new StringBuilder();

        postfix = postfix + " ";
        for (char c : postfix.toCharArray())
        {
            if (Character.isDigit(c))
                number.append(c);
            else if (c == ' ')
            {
                if (number.length() > 0)
                {
                    stack.push(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }
            else
            {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = calculate(operand1, operand2, c);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static int calculate(int operand1, int operand2, char operator)
    {
        switch (operator)
        {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
            case '%':
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
