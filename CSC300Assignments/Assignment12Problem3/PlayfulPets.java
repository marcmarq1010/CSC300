
public class PlayfulPets
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

/*
	This class has a main method and one additional method called matchPet.  It also creates two different implementations of the PetMatcher’s functional interface’s abstract method.
	
	method main
	Create five Pets and add them to the Pet.pets (the static ArrayList of Pet)
	You can use the following:
	“Scruffy","dog","poodle","white",895.00
	“Meow","cat","siamese","white",740.25
	“Max","dog","poodle","black",540.50
	“Cuddles","dog","pug","black",1282.75
	 “Slider","snake","garden","green",320.00
	
	Please use a Lambda Expression for breedMatcher
	Create a new PetMatcher called breedMatcher that implements petMatch returning a List of all those Pets of the same breed. In this case we don’t override the firstPet method.  
	
	The following instances of PetMatcher (priceMatcher and color Matcher) can be done using inner classes; This is necessary in order to override the default method the easiest way.
	
	Create a new PetMatcher called priceMatcher that implements petMatch returning a List of all those Pets less than or equal to the price of the input parameter Pet. priceMatcher also overrides the firstPet method, creating a new firstPet that searches Pets.pet for a Pet less than or equal to the price of the input Pet, returning a reference to the first such instance of such a Pet. If no such Pet exists return null.
	
	Create a new PetMatcher called colorMatcher that implements petMatch returning a List of all those Pets equal to the color of the input parameter Pet.(Remember color is a String so use the equals method on the colors.)  colorMatcher also overrides the firstPet method, creating a new firstPet that searches Pets.pet for a Pet with a color that equals the color of the input Pet, returning a reference to the first such instance of such a Pet. If no such Pet exists return null.
	
	
	
	Make the following calls in main:
	matchPetsFromTheList("Poodles",breedMatcher, new Pet(null, "dog", "poodle", null, 0.0));
	matchPetsFromTheList("Pets for $700 or less",priceMatcher, new Pet(null, null, null, null, 700.0));
	matchPetsFromTheList("Pets that are white",colorMatcher, new Pet(null, null, null, "white", 0.0));
	
	method matchPetsFromTheList has a void return and three parameters – String criteria, PetMatcher matcher and Pet called myPet. Note: The second parameter allows you to send code as a parameter.
	In this method you will first use matcher with firstPet to print out the first Pet.
	Then create a List with all the matches using the matcher and print out the results.
	
	
	Sample output for this example:
	Poodles:
	First: Scruffy: a white poodle dog purchased for $895.00
	
	All matches:
	Scruffy: a white poodle dog purchased for $895.00
	Max: a black poodle dog purchased for $540.50
	
	Pets for $700 or less:
	First: Max: a black poodle dog purchased for $540.50
	
	All matches:
	Max: a black poodle dog purchased for $540.50
	Slider: a green garden snake purchased for $320.00
	
	Pets that are white:
	First: Scruffy: a white poodle dog purchased for $895.00
	
	All matches:
	Scruffy: a white poodle dog purchased for $895.00
Meow: a white siamese cat purchased for $740.25
*/