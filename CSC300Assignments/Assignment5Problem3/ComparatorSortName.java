import java.util.Comparator;

public class ComparatorSortName implements Comparator<Contractor>

{

	@Override
	public int compare(Contractor con1, Contractor con2)
	{
        return con1.getName().compareTo(con2.getName());
	}

}
