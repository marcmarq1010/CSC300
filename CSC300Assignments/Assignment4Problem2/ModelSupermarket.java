import java.io.IOException;
import java.util.Scanner;

public class ModelSupermarket 
{
    public static void main(String[] args) throws IOException 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Please enter the name of the Supermarket:\n");
        String supermarketName = keyboard.nextLine();

        System.out.printf("Please enter an int for the seed:\n");
        int seedValue = keyboard.nextInt();

        Supermarket supermarket = new Supermarket(supermarketName, seedValue);

        System.out.printf("Please enter the name of the output file for Supermarket results:\n");
        String outputFileName = keyboard.next();

        System.out.printf("Please enter the number of minutes to operate the Supermarket:\n");
        int minutesToOperate = keyboard.nextInt();

        supermarket.openSupermarket();

        supermarket.operateSupermarket(minutesToOperate);

        supermarket.generateSupermarketResults(outputFileName);

        keyboard.close();
    }
}
