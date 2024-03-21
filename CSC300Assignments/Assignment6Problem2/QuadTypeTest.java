
public class QuadTypeTest
{
	
	public static void main(String[] args)
	{
		
		QuadType <Integer, String, Boolean, Double> quad = new QuadType<>(1, "one", true, 1.4);

		System.out.printf("%s %s", "Original", quad);
		
		quad.setF(2);
		quad.setS("Second");
		quad.setT(false);
		quad.setU(9.97);

		System.out.printf("%s %s", "Modified", quad);
		
	}
	
}
