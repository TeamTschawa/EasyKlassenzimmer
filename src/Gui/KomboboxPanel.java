package Gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class KomboboxPanel extends JPanel{
	ArrayList<String> textlist = new ArrayList<>();
	

	
	
	 

	
	
	ArrayList<JButton> buttonlist = new ArrayList<>();
	public KomboboxPanel(){
		setSize(700, 700);
		textlist.add("Baden-Württemberg");
		textlist.add("Bayern");
		textlist.add("Berlin ");
		textlist.add("Brandenburg");
		textlist.add("Bremen");
		textlist.add("Hamburg");
		textlist.add("Hessen");
		textlist.add("Mecklenburg-Vorpommern");
		textlist.add("Niedersachsen");
		textlist.add("Nordrhein-Westfalen");
		textlist.add("Rheinland-Pfalz");
		textlist.add("Saarland");
		textlist.add("Sachsen");
		textlist.add("Sachsen-Anhalt");
		textlist.add("Schleswig-Holstein");
		textlist.add("Thüringen");
		textlist.add("Berlin");
		
		this.setLayout(null);
		for(int i = 0; i < 16;i++){
			buttonlist.add(new JButton());
			buttonlist.get(i).setSize(230, 40);
			buttonlist.get(i).setLocation(0, i*45);
			buttonlist.get(i).setText(textlist.get(i));
			buttonlist.get(i).setContentAreaFilled(false);
			buttonlist.get(i).setBorderPainted(false);
			buttonlist.get(i).setFocusPainted(false);
			this.add(buttonlist.get(i));
		}
	}
	
	

}
