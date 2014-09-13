package Gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Window extends JFrame{
	
	Container cp;
	JTabbedPane tabbPane = new JTabbedPane();
	JPanel gender = new JPanel(null, true);
	
	
	public Window(String title) {
		super(title);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int frameWidth = 600;
		int frameHeight = 600;		
		this.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		
		setLocation(x, y);
		this.setResizable(false);
		cp = getContentPane();
		cp.setLayout(null);
		
		// Komponenten 
		tabbPane.setBounds(0, 200, 590, 400);
		tabbPane.add("Geschlächt", gender);
		cp.add(tabbPane);
		
		// Ende Komponenten
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		new Window("Test");
	}
}
