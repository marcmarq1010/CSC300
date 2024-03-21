
public class QuadType <Thing, Thing2, Thing3, Thing4>
{
	
	private Thing F;
	private Thing2 S;
	private Thing3 T;
	private Thing4 U;
	
	public QuadType()
	{
		
	}
	
	public QuadType(Thing f, Thing2 s, Thing3 t, Thing4 u)
	{
		setF(f);
		setS(s);
		setT(t);
		setU(u);
		
	}

	public Thing getF()
	{
		return F;
	}

	public void setF(Thing f)
	{
		F = f;
	}

	public Thing2 getS()
	{
		return S;
	}

	public void setS(Thing2 s2)
	{
		S = s2;
	}

	public Thing3 getT()
	{
		return T;
	}

	public void setT(Thing3 t2)
	{
		T = t2;
	}

	public Thing4 getU()
	{
		return U;
	}

	public void setU(Thing4 u2)
	{
		U = u2;
	}

	@Override
	public String toString()
	{
		return String.format("%s: <%s, %s, %s, %s>\n","QuadType", getF(), getS(), getT(), getU());
	}
	
}
