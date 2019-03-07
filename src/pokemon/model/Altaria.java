package pokemon.model;

public class Altaria extends Pokemon implements Dragon
{
	public Altaria()
	{
		super(334, "Altaria");
	}
	
	public boolean dragonDance()
	{
		return true;
	}
	
	public String breathsFire()
	{
		return "Fire!";
	}
	
	public double flyingDistance()
	{
		return 900088800;
	}

}
