
public class QuadType <T>
{
	
	private T F;
	private T S;
	private T T;
	private T U;
	
	public QuadType(T f, T s, T t, T u)
	{
		setF(f);
		setS(s);
		setT(t);
		setU(u);
		
	}

	public T getF()
	{
		return F;
	}

	public void setF(T f)
	{
		F = f;
	}

	public T getS()
	{
		return S;
	}

	public void setS(T s)
	{
		S = s;
	}

	public T getT()
	{
		return T;
	}

	public void setT(T t)
	{
		T = t;
	}

	public T getU()
	{
		return U;
	}

	public void setU(T u)
	{
		U = u;
	}

	@Override
	public String toString()
	{
		return String.format("<%s, %s, %s, %s>\n", getF(), getS(), getT(), getU());
	}
	
	
	

}
