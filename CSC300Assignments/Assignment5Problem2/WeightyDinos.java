import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class WeightyDinos
{
	
	public static void main(String[] args)
	{
		
		ArrayList<Dinosaur> dinoList = new ArrayList<Dinosaur>();
		Random randy = new Random(4);
		
		for(int i = 0; i < 12; i++)
		{
			Dinosaur dino = new Dinosaur(randy.nextInt(75000, 200001));
			dinoList.add(dino);
		}
		
        Collections.sort(dinoList, new ComparatorDinosaur());

		System.out.printf("%-10s %10s\n", "Name", "Weight");
		
		Iterator<Dinosaur> dinos = dinoList.iterator();
		
		while(dinos.hasNext())
		{
			System.out.println(dinos.next());
		}
		
	}

}
