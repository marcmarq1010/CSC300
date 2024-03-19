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
		
		printAll(animalList);
		
		printAll(brownDogList);
		
		// TODO: Use deleteDog to delete the first item in the brownDogList.
		deleteDog();

		printAll(brownDogList);
		
	}
	
	// TODO: Has two parameters, an ArrayList with a lower bound of BrownDog, and a String with the name of a Dog.
	public static void addDog(String dogName)
	{
		
		//TODO: Adds the identified Dog reference to the ArrayList, and prints out a line as shown in the sample output below.
		
	}
	
	// TODO: Has two parameters, an ArrayList with an upper bound of Dog, and a String with the name of a Dog to be deleted.
	public static void deleteDog(String dogName)
	{
		
		// TODO: Deletes the identified Dog reference to the ArrayList, and prints out a line as shown in the sample output below.
		
	}
	
	// TODO: Has a single parameter of an ArrayList with a wildcard type.
	public static void printAll()
	{
		
		// TODO: Prints out all the items in the ArrayList.

		
	}
	
}

/*					
	OUTPUT:
	Sample Output:
		Doggie named GreyHound was added
		Doggie named Boxer was added
		Doggie named Spaniel was added
		Doggie named Dachsund was added
		The list of animals:
		GreyHound 
		The list of Brown Dogs:
		Boxer Spaniel Dachsund 
		Doggie named Boxer was removed
		The list of Brown Dogs after a deletion of the first Dog in the list:
		Spaniel Dachsund
*/