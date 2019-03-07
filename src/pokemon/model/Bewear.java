package pokemon.model;

public class Bewear extends Pokemon implements Ice
{
	public Bewear()
	{
		super(760, "Bewear");
	}
	
	public boolean isCold()
	{
		return false;
	}
	
	public String typeOfIce()
	{
		return "Slippery Ice";
	}
	
	public double snowFall()
	{
		return 858258;
	}
}
