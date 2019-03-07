package pokemon.model;

public class Aurorus extends Pokemon implements Ice
{
	public Aurorus()
	{
		super(699, "Aurorus");
	}
	
	public boolean isCold()
	{
		return true;
	}
	
	public String typeOfIce()
	{
		return "Snow";
	}
	
	public double snowFall()
	{
		return 897897821;
	}

}
