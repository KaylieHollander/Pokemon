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
		
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Giraffe.png"));
		
		numberField = new JTextField("0");
		
		evolveField = new JTextField("False");
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, numberField);
		
		attackField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, -129, SpringLayout.EAST, this);
		
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 0, SpringLayout.EAST, numberField);
		
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -129, SpringLayout.EAST, this);
		
		nameField = new JTextField("My Pokename");
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, nameField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -129, SpringLayout.EAST, this);
		
		
		
		
		numberLabel = new JLabel("This Pokemon number is");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 152, SpringLayout.EAST, numberLabel);
		
		healthLabel = new JLabel("This Pokemon health is");
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		
		evolveLabel = new JLabel("This Pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		
		attackLabel = new JLabel("This Pokemon attack level is");
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 128, SpringLayout.EAST, attackLabel);
		
		enhanceLabel = new JLabel("This Pokemon enhancement level is");
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, enhanceLabel);
		
		nameLabel = new JLabel("My name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		
		
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
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -226, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 6, SpringLayout.SOUTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 0, SpringLayout.WEST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 96, SpringLayout.EAST, imageLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 80, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, enhanceLabel, -122, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 40, SpringLayout.SOUTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 51, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 36, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 133, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 133, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, 0, SpringLayout.SOUTH, this);
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
		this.add(saveButton);
		this.add(pokedexDropdown);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
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
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.savePokedex();
			}
		});
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = evolveField.getText();
			data[4] = numberField.getText();
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
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
