
public interface PetMatcher
{
	
}

/*
	PetMatcher is a functional interface with both an abstract and default method.
	
	method matchPet is the abstract method (don’t use the word abstract since we are in an interface.) This method returns a List of type Pet and has a Pet as an input parameter
	
	default method firstPet has an input of type Pet and a return value of type Pet.
	Get the index of the first matching Pet in Pet.pets (the ArrayList in Pet) (use indexOf)
	if the index is less than 0 (indexOf does this for you)
		return null
	else
	return a reference to the Pet at that index
*/