import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListSortGenericTester
{
    
    public static void main(String[] args)
    {
        long timeStart, timeEnd, totalTime;
        
        Scanner keyboard = new Scanner(System.in);
        
        ArrayListSortGeneric<Integer> sorterInt = new ArrayListSortGeneric<>();
        ArrayListSortGeneric<String> sorterString = new ArrayListSortGeneric<>();
        
        System.out.printf("Enter the size of the array: \n");
        int size = keyboard.nextInt();
                
        // Sorting an ArrayList of Integers
        ArrayList<Integer> numbers = new ArrayList<>(size);
        Random randy = new Random();
        for (int i = 0; i < size; i++)
            numbers.add(randy.nextInt(2000));
        
        System.out.println("Sorting an ArrayList of Integers:");
        timeStart = System.currentTimeMillis();
        sorterInt.insertionSort(numbers);
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        
        System.out.printf("The total time for sorting Integers is %d millisecs\nSorted: ", totalTime);
        for (int num : numbers)
            System.out.print(num + " ");
        System.out.println();
        
        System.out.println();
        
        // Sorting an ArrayList of Strings
        ArrayList<String> strings = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++)
            {
                char c = (char) ('A' + randy.nextInt(26));
                sb.append(c);
            }
            strings.add(sb.toString());
        }
        
        System.out.printf("Sorting an ArrayList of Strings:\n");
        timeStart = System.currentTimeMillis();
        sorterString.insertionSort(strings);
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        
        System.out.printf("The total time for sorting Strings is %d millisecs\nSorted: ", totalTime);
        for (String str : strings)
            System.out.print(str + " ");
        System.out.println();
    
        keyboard.close();
    }
}
