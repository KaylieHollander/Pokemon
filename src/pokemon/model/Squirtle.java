package pokemon.model;

public class Squirtle extends Pokemon implements Water
{
	public Squirtle(int number, String name)
	{
		super(number, name);
	}
	
	public Squirtle()
	{
		super(5464231, "Squritle");
	}
	
	public void splash()
	{
		System.out.println("Splooosh");
	}
	
	public int waterAmount()
	{
		return this.getHealthPoints();
	}
	
	public boolean canTurnIntoWater()
	{
		boolean isWater = true;
		
		return isWater;
	}
}
