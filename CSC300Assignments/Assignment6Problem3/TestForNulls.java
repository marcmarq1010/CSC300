import java.util.ArrayList;
import java.util.Random;

public class TestForNulls
{

		public static void main(String[] args)
		{
			Random randy = new Random(5);
						
			ArrayList<Integer> intArrayL = new ArrayList<Integer>();
			
			ArrayList<String> stringArrayL = new ArrayList<String>();
			
			boolean nulls;
			
			
			for(int i = 0; i < 9; i++)
			{
				intArrayL.add(randy.nextInt(5,16));
			}
			
			nulls = hasNoNulls(intArrayL);
			
			System.out.printf("It is %b that %s has no null value\n", nulls, "intArrayL");
			
			intArrayL.add(intArrayL.size(), null);
			
			nulls = hasNoNulls(intArrayL);
			
			System.out.printf("It is %b that %s has no null value\n", nulls, "intArrayL");
			
			System.out.println(intArrayL);
			
			for(int i = 0; i < 6; i++)
			{
				stringArrayL.add("wxy" + randy.nextInt(9,28));
			}
			
			nulls = hasNoNulls(stringArrayL);
			
			System.out.printf("It is %b that %s has no null value\n", nulls, "stringArrayL");
			
			stringArrayL.add(3, null);
			
			nulls = hasNoNulls(stringArrayL);
			
			System.out.printf("It is %b that %s has no null value\n", nulls, "stringArrayL");
			
			System.out.println(stringArrayL);

		}
		
		public static boolean hasNoNulls(ArrayList<?> arrayList)
		{

			for(Object element : arrayList)
			{
				if(element != null)
				{
					continue;
				}
				else
				{
					return false;
				}
			}
			
			return true;
			
		}
		
}
