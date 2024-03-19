
public class Quadratic 
{
	private int a, b, c;
	private String comment;
	
	
	public Quadratic(int a, int b, int c)
	{
		this.a = a;
        this.b = b;
        this.c = c;
        setComment();
    }
	
	public int discriminant()
	{
		return (int) (Math.pow(b, 2)) - (4 * a * c);
	}
	
	public ComplexPair solveQuadratic()
	{
		ComplexPair result;
		Complex firstRoot, secondRoot;
		
		int discrim = discriminant();
		
		if(a == 0)
		{
			 firstRoot = new Complex(-c / b, 0);
			 result = new ComplexPair(firstRoot, firstRoot);
		}
		else if (discrim == 0)
		{
			firstRoot = new Complex( -b / (2 * a), 0);
			result = new ComplexPair(firstRoot, firstRoot);
		}
		else if (discrim > 0)
		{
			firstRoot = new Complex((-b + Math.sqrt(discrim)) / (2 * a), 0 );
			secondRoot = new Complex((-b - Math.sqrt(discrim)) / (2 * a), 0 );
			result = new ComplexPair(firstRoot, secondRoot);
		}
		else
		{
			firstRoot = new Complex(-b / (2 * a), Math.sqrt(-discrim) / (2 * a));
			secondRoot = new Complex( -b / (2 * a), - Math.sqrt(-discrim) / (2 * a));
			result = new ComplexPair(firstRoot, secondRoot);
		}

		return result;
	}
	
	public boolean equals(Object obj) 
	{
        if(obj instanceof Quadratic)
        {
        	return true;
        }
        
        else if(!(obj instanceof Quadratic)) 
        {
        	return false;
        }
        
        Quadratic quadratic = (Quadratic) obj;
        return this.a == quadratic.getA() && this.b == quadratic.getB() && this.c == quadratic.getC();
    }

		
	public double getA() 
	{
		return a;
	}


	public void setA(int a) 
	{
		this.a = a;
	}


	public double getB() 
	{
		return b;
	}


	public void setB(int b)
	{
		this.b = b;
	}


	public double getC()
	{
		return c;
	}


	public void setC(int c) 
	{
		this.c = c;
	}


	public String getComment() 
	{
		return comment;
	}


	public void setComment() 
	{
		if(a == 0)
		{
			comment = "Linear equation: one real root";
		}
		else if(discriminant() == 0)
		{
			comment = "Quadratic with one real root";
		}
		else if(discriminant() > 0)
		{
			comment = "Two distinct real roots";
		}
		else
		{
			comment = "Two distinct complex roots";
		}	
	}

	@Override
	public String toString() 
	{
		String quadraticString = "";
		if (a != 0) 
		{
			if(a == 1 || a == -1)
			{
				quadraticString += String.format("%sx^2 ", (a == -1) ? "-" : "");
			}
			else
			{
				quadraticString += String.format("%dx^2 ", a);
			}
		}
		if (b != 0) 
		{
			quadraticString += String.format("%s%dx ", (b > 0 && a != 0) ? "+ " : "", b);
		}
		if (c != 0) 
		{
			quadraticString += String.format("%s%d", (c > 0 && (a != 0 || b != 0)) ? "+ " : "", c);
		}

		return quadraticString + " = 0";
	}
	
}
