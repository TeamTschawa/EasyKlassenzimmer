package Gui;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class Window extends JFrame {

	Controller con;

	Container cp;

	JTabbedPane tabbPane = new JTabbedPane();
	JPanel gender = new JPanel(null, true);

	JButton arrowLeft;
	JButton arrowRight;
	JButton blazon = new JButton();

	public Window(String title, Controller _con) {
		super(title);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int frameWidth = 800;
		int frameHeight = 800;
		this.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		this.setResizable(false);
		cp = getContentPane();
		cp.setLayout(null);

		con = _con;

		Image arLeft = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("arrowLeft.png"));
		Image scaledImage = arLeft.getScaledInstance(100, 100,
				Image.SCALE_SMOOTH);
		ImageIcon IconArLeft = new ImageIcon(scaledImage);

		Image arRight = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("arrowRight.png"));
		scaledImage = arRight.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon IconArRight = new ImageIcon(scaledImage);

		// Komponenten
		tabbPane.setLocation(0, 150);
		tabbPane.setSize(frameWidth, frameHeight - tabbPane.getY());
		tabbPane.add("Geschlecht", gender);
		cp.add(tabbPane);

		arrowLeft = new JButton(IconArLeft);
		arrowLeft.setSize(100, 100);
		arrowLeft.setLocation((int) (frameWidth * 0.2 - arrowLeft.getWidth() / 2), 20);
		arrowLeft.setFocusable(false);
		arrowLeft.setContentAreaFilled(false);
		arrowLeft.setCursor(new Cursor(HAND_CURSOR));
		arrowLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.left(e);

			}
		});
		cp.add(arrowLeft);

		arrowRight = new JButton(IconArRight);
		arrowRight.setSize(100, 100);
		arrowRight.setLocation((int) (frameWidth * 0.79 - arrowLeft.getWidth() / 2), 20);
		arrowRight.setFocusable(false);
		arrowRight.setContentAreaFilled(false);
		arrowRight.setCursor(new Cursor(HAND_CURSOR));
		arrowRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.right(e);

			}
		});
		cp.add(arrowRight);

		blazon.setSize(100, 100);
		blazon.setLocation(frameWidth / 2 - blazon.getWidth() / 2, 20);
		blazon.setText("TEST");
		blazon.setFocusable(false);
		blazon.setContentAreaFilled(false);
		blazon.setCursor(new Cursor(HAND_CURSOR));
		blazon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.actionBlaze(e);
			}
		});
		cp.add(blazon);

		// Ende Komponenten

		this.setVisible(true);
	}

}
