package pokemon.model;

public class Bibarel extends Pokemon implements Water
{
	public Bibarel(int number, String name)
	{
		super(number, name);
	}
	
	public Bibarel()
	{
		super(2222, "Bibarel");
		
	}
	
	public void splash()
	{
		System.out.println("Sploosh");
	}
	
	public int waterAmount()
	{
		return 2000000;
	}
	
	public boolean canTurnIntoWater()
	{
		boolean isWater = false;
		
		return isWater;
	}
}
