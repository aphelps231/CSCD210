package rationalNumbers;

public class Rational implements Comparable<Rational>
{
	private int num, den;
	
	//CONSTRUCTORS
	public Rational()
	{
		this.num = 1;
		this.den = 1;
	}
	
	public Rational(int num, int den)
	{
		this.num = num;
		this.den = den;
		
		this.reduce();
	}
	//----------
	
	//FUNCTIONS
	public Rational add(Rational r)
	{
		int commonDen = this.den * r.den;
		Rational tmp = this;
		
		tmp.num *= r.den;
		r.num *= tmp.den;
		
		tmp.num += r.num;
		tmp.den = commonDen;
		
		tmp.reduce();
		
		return tmp;
	}
	
	public Rational subtract(Rational r)
	{
		int commonDen = this.den * r.den;
		Rational tmp = this;
		
		tmp.num *= r.den;
		r.num *= tmp.den;
		
		tmp.num -= r.num;
		tmp.den = commonDen;
		
		tmp.reduce();
		
		return tmp;
	}
	
	private void reduce()
	{
		int gcd = GCD(this.num, this.den);
		
		this.num /= gcd;
		this.den /= gcd;
	}
	
	private int GCD(int num, int den)
	{
		return den == 0 ? num : GCD(den, num % den);
	}
	//----------
	
	//GET
	public int getNum()
	{
		return this.num;
	}
	
	public int getDen()
	{
		return this.den;
	}
	
	public double getValue()
	{
		int val = 1000 * this.num / this.den;
		
		return (double) val / 1000.0;
	}
	//----------
	
	//SET
	public void setNum(int num)
	{
		this.num = num;
		
		this.reduce();
	}
	
	public void setDen(int den)
	{
		this.den = den;
		
		this.reduce();
	}
	
	public void setValue(int num, int den)
	{
		this.num = num;
		this.den = den;
		
		this.reduce();
	}
	//----------
	
	//IMPLEMENTATIONS
	public String toString()
	{
		return this.num + "/" + this.den;
	}
	
	public boolean equals(Object r)
	{
		if(this == r)
		{
			return true;
		}
		if(r == null)
		{
			return false;
		}
		if(this.getClass() != r.getClass())
		{
			return false;
		}
		
		Rational other = (Rational) r;
		
		if(this.num != other.num || this.den != other.den)
		{
			return false;
		}
		
		return true;
	}
	
	public int compareTo(Rational r)
	{
		return (this.getValue() == r.getValue()) ? 0 : (this.getValue() > r.getValue() ? 1 : -1);
	}
	//----------
}
