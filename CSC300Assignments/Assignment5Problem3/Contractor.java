
public class Contractor
{
	
	private String name = "";
	private String location = "";
	private int ownerID;
	
	public Contractor()
	{
		
	}
	
	public Contractor(String name, String location, int ownerID)
	{
		setName(name);
		setLocation(location);
		setOwnerID(ownerID);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public int getOwnerID()
	{
		return ownerID;
	}

	public void setOwnerID(int ownerID)
	{
		this.ownerID = ownerID;
	}

	@Override
	public String toString()
	{
		return String.format("%-10s %-10s %-10d", getName(), getLocation(), getOwnerID());
	}

}
