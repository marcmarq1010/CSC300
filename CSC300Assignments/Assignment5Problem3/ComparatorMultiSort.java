import java.util.Comparator;

public class ComparatorMultiSort implements Comparator<Contractor>
{

	@Override
	public int compare(Contractor con1, Contractor con2)
	{
        
		if(con1.getName().compareTo(con2.getName()) == 0)
        {
        	if(con1.getLocation().compareTo(con2.getLocation()) == 0)
        	{
        		return con1.getOwnerID() - con2.getOwnerID();
        	}
        	else
        	{
                return con1.getLocation().compareTo(con2.getLocation());
        	}
        }
        else
        {
            return con1.getName().compareTo(con2.getName());

       
        }   
	
	}
}
