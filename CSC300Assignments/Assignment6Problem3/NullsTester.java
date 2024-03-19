import java.util.ArrayList;
import java.util.Random;

public class NullsTester
{

		public static void main(String[] args)
		{
			Random randy = new Random(5);
			
			ArrayList<Integer> numList = new ArrayList<Integer>();
			
			ArrayList<String> stringList = new ArrayList<String>();
			
			
			for(int i = 0; i < 9; i++)
			{
				numList.add(randy.nextInt(5,16));
			}
			
			// TODO: Test for a null value using hasNoNulls.
			
			// TODO: Print the result as shown below.
			
			// TODO: Add a null value at the end of the ArrayList.
			
			// TODO: Re-test using hasNoNulls.
			
			// TODO: Print the result as shown below.
			
			// TODO: Then print out the ArrayList as shown.
			
			for(int i = 0; i < 6; i++)
			{
				stringList.add("wxy" + randy.nextInt(9,28));
			}
			
			// TODO: Test for a null value using hasNoNulls.
			
			// TODO: Print the result as shown below.
			
			// TODO: Add a null value at index 3 of the ArrayList.
			
			// TODO: Re-test using hasNoNulls.
			
			// TODO: Print the result as shown below.
			
			// TODO: Then print out the ArrayList as shown

		}
		
}

/*
	OUTPUT:
	It is true that intArrayL has no null value
	It is false that intArrayL has no null value
	[5, 6, 14, 15, 8, 12, 7, 15, 13, null]
	It is true that stringArrayL has no null value
	It is false that stringArrayL has no null value
	[wxy12, wxy14, wxy11, null, wxy12, wxy9, wxy14]
*/