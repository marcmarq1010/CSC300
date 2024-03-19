
public class ComplexPair 
{
	private Complex first;
	private Complex second;
	
	public ComplexPair(Complex first, Complex second)
	{
		setFirst(first);
		setSecond(second);
	}
	
	// You can add equals(Object o) method optionally.


	public Complex getFirst() 
	{
		
		return first;
	}

	public void setFirst(Complex first) 
	{
		this.first = first;
	}

	public Complex getSecond()
	{
		return second;
	}

	public void setSecond(Complex second) 
	{
		this.second = second;
	}

	@Override
	public String toString() 
	{
		String firstString, secondString;
		
	    if(first.getImaginary() != 0)
	    {
			if(first.getImaginary() < 0)
			{
		    	firstString = String.format("%.2f%s%.2fi", first.getReal(), "", first.getImaginary());
			}
			else
			{
		    	firstString = String.format("%.2f%s%.2fi", first.getReal(), "+", first.getImaginary());
			}
	    }
	    else
	    {
	    	firstString = String.format("%.2f", first.getReal());

	    }
	    
	    if(second.getImaginary() != 0)
	    {
	    	if(second.getImaginary() < 0)
	    	{
		    	secondString = String.format("%.2f%s%.2fi", second.getReal(), "", second.getImaginary());
	    	}
	    	else
	    	{
		    	secondString = String.format("%.2f%s%.2fi", second.getReal(), "+", second.getImaginary());
	    	}
	    }
	    else
	    {
	    	secondString = String.format("%.2f", second.getReal());

	    }
	    
	    return String.format("first: %s; second: %s", firstString, secondString);
	}
	
}
