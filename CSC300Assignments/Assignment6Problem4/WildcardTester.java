import java.util.ArrayList;

public class WildcardTester
{
	
	public static void main(String [] args)
	{
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		ArrayList<BrownDog> brownDogList = new ArrayList<BrownDog>();
		
		
		addDog(animalList,"Greyhound");
		
		addDog(brownDogList, "Tom");
		
		addDog(brownDogList, "Siamese");
		
		addDog(brownDogList, "Tiger");
		
		System.out.println("The list of animals:");
		printAll(animalList);
		
		System.out.println("The list of Brown Dogs:");
		printAll(brownDogList);
		
		deleteDog(brownDogList, "Tom");
		
		System.out.println("The list of Brown Dogs after a deletion of the first Dog in the list:");
		printAll(brownDogList);
	}
	
	public static void addDog(ArrayList<? super BrownDog> dogList, String dogName)
	{
		dogList.add(new BrownDog(dogName));
		System.out.printf("Doggie named %s was added.\n", dogName);
	}
	

	public static void deleteDog(ArrayList<? extends Dog> dogList, String dogName)
	{
		dogList.removeFirst();
		System.out.printf("Doggie named %s was removed.\n", dogName);
	}
	
	public static void printAll(ArrayList<?> list)
	{
		for(Object dog : list)
		{
			System.out.printf("%s ",dog);
		}
		System.out.println();
	}
	
}
