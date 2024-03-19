
public class Dinosaur
{
	private static int dinoCounter = 1;
	private int dinoWeight;
	private String dinoName;
	
	public Dinosaur()
	{
		setDinoName("Barney");
	}
	
	public Dinosaur(int weight)
	{
		setDinoWeight(weight);
		setDinoName("DINO" + dinoCounter);
		dinoCounter++;
	}

	public int getDinoWeight()
	{
		return dinoWeight;
	}

	public void setDinoWeight(int dinoWeight)
	{
		this.dinoWeight = dinoWeight;
	}

	public String getDinoName()
	{
		return dinoName;
	}

	public void setDinoName(String dinoName)
	{
		this.dinoName = dinoName;
	}

	@Override
	public String toString() 
	{
		return String.format("%-10s %10d",getDinoName(), getDinoWeight());
	}
	
	
}
