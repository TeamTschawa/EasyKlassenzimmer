package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Calculatings.Calculator;
import Calculatings.Classroom;

public class Gender extends JPanel {

	Classroom cr;

	Image female;
	Image scaledFemale;
	Image male;
	Image scaledMale;
	
	Color ownePink;

	Window win;

	public Gender(Window _win) {
		super(null, true);
		win = _win;
		cr = new Calculator().classroom;

		female = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("maennchenRosa.png"));
		scaledFemale = female.getScaledInstance(25, 50, Image.SCALE_SMOOTH);

		male = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("maennchenBlau.png"));
		scaledMale = male.getScaledInstance(25, 50, Image.SCALE_SMOOTH);
		
		ownePink = new Color(255, 0, 220);

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("Consolas", Font.BOLD, 40));
		for (int i = 0; i < 6; i++) {
			for (int u = 0; u < 3; u++) {
				g2d.drawImage(scaledFemale, 100 + u * 40, 100 + i * 60, this);
			}
		} 
		g2d.drawImage(scaledFemale, 100 + 3 * 40, 100, this);
		g2d.drawString("" + cr.getGirlsInClass(), 150, 70);
		
		for(int y = 0; y < 6; y++){
			for(int x = 0; x < 3; x++){
				g2d.drawImage(scaledMale, 400 + x * 40, 100 + y * 60, this);
			}
		}
		for(int y = 0; y < 3; y++){
			g2d.drawImage(scaledMale, 400 + 3 * 40, 100 + y * 60, this);
		}
		g2d.drawString("" + cr.getBoysInClass(), 450, 70);
		
		
		g2d.setFont(new Font("Consolas", Font.BOLD, 18));
		g2d.drawString("Weiblich", 130, 525);
		g2d.drawString("Männlich", 430, 525);
		g2d.setColor(ownePink);
		g2d.fillRect(100, 510, 20, 20);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(400, 510, 20, 20);
		
		g2d.dispose();
		g.dispose();
	}
}
