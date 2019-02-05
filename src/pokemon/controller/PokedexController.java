package pokemon.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.*;


public class PokedexController
{
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	private void addPokemon()
	{
		pokemonList.add(new Bibarel());
		pokemonList.add(new Squirtle());
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		
	}
}
