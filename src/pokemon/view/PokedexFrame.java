package pokemon.view;

import javax.swing.*;
import pokemon.controller.*;

public class PokedexFrame extends JFrame
{
	private PokedexController app;
	private PokedexPanel appPanel;
	
	public PokedexFrame(PokedexController app)
	{
		super();
		
		this.app = app;
		this.appPanel = new PokedexPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 600);
		this.setTitle("Pokemon");
		this.setResizable(true);
		this.setVisible(true);
	}
}
