import java.util.Comparator;

public class ComparatorSortOwnerID implements Comparator<Contractor>
{
	@Override
	public int compare(Contractor con1, Contractor con2)
	{
        return con1.getOwnerID()- con2.getOwnerID();
	}
}
