package Gui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class Window extends JFrame{
	
	Container cp;
	JTabbedPane tabbPane = new JTabbedPane();
	JPanel gender = new JPanel(null, true);
	
	JLabel arrowLeft;
	JLabel arrowRight;
	
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
		
		Image arLeft = Toolkit.getDefaultToolkit().getImage(
		        getClass().getResource("arrowLeft.png"));
		Image scaledImage = arLeft.getScaledInstance(100, 100, Image.SCALE_SMOOTH);		
		ImageIcon IconArLeft = new ImageIcon(scaledImage);
		
		Image arRight = Toolkit.getDefaultToolkit().getImage(
		        getClass().getResource("arrowRight.png"));
		scaledImage = arRight.getScaledInstance(100, 100, Image.SCALE_SMOOTH);		
		ImageIcon IconArRight = new ImageIcon(scaledImage);
		
		// Komponenten 
		tabbPane.setBounds(0, 150, 600, 450);
		tabbPane.add("Geschlächt", gender);
		cp.add(tabbPane);
		
		arrowLeft = new JLabel(IconArLeft);
		arrowLeft.setBounds(10, 20, 100, 100);
		arrowLeft.setCursor(new Cursor(HAND_CURSOR));
		cp.add(arrowLeft);
		
		arrowRight = new JLabel(IconArRight);
		arrowRight.setBounds(frameWidth - 115, 20, 100, 100);
		arrowRight.setCursor(new Cursor(HAND_CURSOR));
		cp.add(arrowRight);
		
		// Ende Komponenten
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Window("Test");
	}
}
