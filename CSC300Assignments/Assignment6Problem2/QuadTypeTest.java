
public class QuadTypeTest
{
	
	public static void main(String[] args)
	{
		
		QuadType original = new QuadType(1, "one", true, 1.4);

		System.out.printf("%s", original);
		
		original.setF(2);
		original.setS("Second");
		original.setT(false);
		original.setU(9.97);

		System.out.printf("%s", original);
		
	}
	
}

/*	
	OUTPUT:
	Original QuadType: <1, one, true, 1.40>
	Modified QuadType: <2, Second, false, 9.97>
*/