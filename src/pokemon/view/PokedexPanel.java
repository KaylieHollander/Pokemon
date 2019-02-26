package pokemon.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pokemon.controller.*;
import pokemon.model.Pokemon;

public class PokedexPanel extends JPanel
{
	private SpringLayout appLayout;
	private PokedexController app;
	
	private JButton changeButton;
	private JButton saveButton;
	private JComboBox<String> pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/Pokemon/Giraffe.png"));
		
		numberField = new JTextField("0");
		evolveField = new JTextField("False");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		nameField = new JTextField("My Pokename");
		
		
		numberLabel = new JLabel("This Pokemon number is");
		healthLabel = new JLabel("This Pokemon health is");
		evolveLabel = new JLabel("This Pokemon can evolve");
		attackLabel = new JLabel("This Pokemon attack level is");
		enhanceLabel = new JLabel("This Pokemon enhancement level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("Pokemon goes here", pokemonIcon, JLabel.CENTER);
		
		changeButton = new JButton("Click here to change the pokevalues");
		saveButton = new JButton("Click here to save the Pokemon");
		pokedexDropdown = new JComboBox<String>();
		
		
		setupListeners();
		setupLayout();
		setupPanel();
		setupDropdown();
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, numberField, 545, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolveField, -61, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, -117, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -253, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 40, SpringLayout.SOUTH, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 38, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 271, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -192, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -50, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 40, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 54, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 43, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 27, SpringLayout.SOUTH, changeButton);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, -1, SpringLayout.NORTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -45, SpringLayout.WEST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 23, SpringLayout.SOUTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 21, SpringLayout.SOUTH, nameField);
	}
	
	private void setupPanel()
	{	
		this.setLayout(appLayout);
		this.add(numberField);
		numberField.setEnabled(false);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		
		this.add(nameField);
		this.add(healthField);

		this.add(numberLabel);
		this.add(healthLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
		});
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/Pokemon";
		String defaultName = "Bibarel";
		String extension = ".png";
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
}
