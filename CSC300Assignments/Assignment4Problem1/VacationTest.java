
public class VacationTest
{

	public static void main(String[] args) 
	{
		AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 1000.00 , "Disney", 4, 989.49);
		System.out.printf("The first all-inclusive vacation is:\n");
		System.out.println(aiv1);
		printBudget(aiv1.overBudget());
		
		System.out.println();

		AllInclusiveVacation aiv2 = new AllInclusiveVacation("Bahamas", 2000.00, "ClubMed", 4, 2049.99);
		System.out.printf("The second all-inclusive vacation is:\n");
		System.out.println(aiv2);
		printBudget(aiv2.overBudget());
		
		System.out.println();
		
		aiv2.setBrand(aiv1.getBrand());
		aiv2.setPrice(aiv1.getPrice());
		
		if(aiv2.equals(aiv1))
		{
			System.out.printf("aiv1 and aiv2 are now equal\n");
		}
		else
		{
			System.out.printf("aiv1 and aiv2 are not equal\n");
		}
	
		aiv2.setDestination(aiv1.getDestination());
		aiv2.setBudget(aiv1.getBudget());
		
		if(aiv2.equals(aiv1))
		{
			System.out.printf("aiv1 and aiv2 are now equal\n");
		}
		else
		{
			System.out.printf("aiv1 and aiv2 are not equal\n");
		}
		
		System.out.println();
		
		String [] itemsList1 = { "hotel", "meals", "airfare", "windsurfing" };
		double [] costsList1 = { 750.00, 250.00, 400.00 };
		
		PieceMealVacation pmv1 =  new PieceMealVacation("Miami", 1500.00, itemsList1, costsList1);
		System.out.printf("The first piecemeal vacation is:\n");
		System.out.print(pmv1);
		printBudget(pmv1.overBudget());
		
		System.out.println();

		String [] itemsList2 = { "hotel", "meals", "airfare", "windsurfing" };
		double [] costsList2 = { 750.00, 250.00, 400.00, 120.00, 200.00 };
		
		PieceMealVacation pmv2 =  new PieceMealVacation("Miami", 1500.00, itemsList2, costsList2);
		System.out.printf("The second piecemeal vacation is:\n");
		System.out.print(pmv2);
		printBudget(pmv2.overBudget());
		
		System.out.println();
		
		if(pmv1.equals(pmv2))
		{
			System.out.printf("pmv1 and pmv2 are now equal\n");
		}
		else
		{
			System.out.printf("pmv1 and pmv2 are not equal\n");
		}
		
		pmv2.setItems(itemsList1);
		pmv2.setCosts(costsList1);
		
		if(pmv1.equals(pmv2))
		{
			System.out.printf("pmv1 and pmv2 are now equal\n");
		}
		else
		{
			System.out.printf("pmv1 and pmv2 are not equal\n");
		}
		
	}
	
	public static void printBudget(double budget)
	{
		if(budget < 0)
		{
			System.out.printf("It is under budget by $%,.2f\n", Math.abs(budget));
			// Stayed under budget
		}
		else if(budget > 0) 
		{
			System.out.printf("It is over budget by $%,.2f\n", Math.abs(budget));
		}
		else
		{
			System.out.printf("It is on budget.");
		}
	}

}
