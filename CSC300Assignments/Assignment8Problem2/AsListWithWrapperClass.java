import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AsListWithWrapperClass
{
    public static void main(String[] args)
    {
        Random randy = new Random(6);

        int[] array = useArray(randy); // Populate array and return it

        convertArray(array);
        
        useList(convertArray(array));
    }

    public static int[] useArray(Random randy)
    {
        int[] array = new int[4];

        for (int i = 0; i < array.length; i++)
            array[i] = randy.nextInt(10); // Generate random integers from 0 to 9
        
        return array;
    }
    
    public static void useList(Integer[] integers)
    {
    	 // Create a List of type Integer and populate it using Arrays.asList()
        List<Integer> integerList = Arrays.asList(integers);

        // Print out the List
        System.out.printf("Original List: ");
        
        System.out.println(integerList);
        
        integerList.set(3, 11);
        

        // Reprint the elements in the List
        System.out.printf("Modified List: ");
        
        System.out.println(integerList);
    }
    
    public static Integer[] convertArray(int[] array)
    {
        Integer[] integerArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
            integerArray[i] = array[i];
        
        return integerArray;
    }
    
}
