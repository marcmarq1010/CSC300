
public class Complex 
{
	private double real;
	private double imaginary;
	
	public Complex(double real, double imaginary)
	{
		setReal(real);
		setImaginary(imaginary);
	}
	
	public boolean equals(Object obj)
	{
	    Complex complex = (Complex) obj;
	    
	    boolean realEqual = Double.compare(complex.real, real) == 0;
	    
	    boolean imaginaryEqual = Double.compare(complex.imaginary, imaginary) == 0;

	    return realEqual && imaginaryEqual;
	}

	public double getReal() 
	{
		return real;
	}

	public void setReal(double real) 
	{
		this.real = real;
	}

	public double getImaginary() 
	{
		return imaginary;
	}

	public void setImaginary(double imaginary) 
	{
		this.imaginary = imaginary;
	}
	

	@Override
	public String toString() 
	{
	    if (imaginary != 0) 
	    {
	        return String.format("%.2f %s %.2fi", real, (imaginary > 0 ? "+" : ""), Math.abs(imaginary));
	    } 
	    else 
	    {
	        return String.format("%.2f", real);
	    }
	}
	
}
