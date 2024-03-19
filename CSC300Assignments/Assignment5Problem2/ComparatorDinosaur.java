import java.util.Comparator;

public class ComparatorDinosaur implements Comparator<Dinosaur>
{

    public int compare(Dinosaur dino1, Dinosaur dino2)
    {
        // Compare based on weight
        return dino1.getDinoWeight() - dino2.getDinoWeight();
    }
}


/*
	class ComparatorDinosaur implements the Comparator for Dinosaur (20)
	Comparator is simply based on the lower weight preceding the higher weight
	Don’t forget the necessary import statement

 */
