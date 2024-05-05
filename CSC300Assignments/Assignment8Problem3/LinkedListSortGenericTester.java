import java.util.*;

public class LinkedListSortGenericTester
{
    public static void main(String[] args)
    {
        long timeStart, timeEnd, totalTime;
        
        Scanner keyboard = new Scanner(System.in);
        
        LinkedListSortGeneric<Integer> sorterInt = new LinkedListSortGeneric<>();
        LinkedListSortGeneric<String> sorterString = new LinkedListSortGeneric<>();

        System.out.printf("Enter the size of the list: \n");
        int size = keyboard.nextInt();

        // Sorting a LinkedList of Integers
        LinkedList<Integer> numbers = new LinkedList<>();
        Random randy = new Random();
        for (int i = 0; i < size; i++)
            numbers.add(randy.nextInt(2000));

        System.out.printf("Sorting a LinkedList of Integers:\n");
        timeStart = System.currentTimeMillis();
        sorterInt.insertionSort(numbers);
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        
        System.out.printf("The total time for sorting Integers is %d millisecs\nSorted: ", totalTime);
        for (int num : numbers)
            System.out.print(num + " ");
        System.out.println();

        System.out.println();

        // Sorting a LinkedList of Strings
        LinkedList<String> strings = new LinkedList<>();
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

        System.out.println("Sorting a LinkedList of Strings:");
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
