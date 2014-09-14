package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window extends JFrame implements MouseListener {

	Controller con;

	Container cp;

	JTabbedPane tabbPane = new JTabbedPane();
	Gender gender = new Gender(this);
	Immigration immigration = new Immigration(this);

	ComboboxPanel combobox = new ComboboxPanel(this);

	JButton arrowLeft;
	JButton arrowRight;
	JButton blazon = new JButton();

	public Window(String title, Controller _con) {
		super(title);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int frameWidth = 700;
		int frameHeight = 800;
		this.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		this.setResizable(false);
		this.addMouseListener(this);
		cp = getContentPane();
		cp.setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("ClassroomIcon.png"));
		this.setIconImage(icon);

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

		combobox.setLocation(frameWidth / 2 - combobox.getWidth() / 2, 140);
		combobox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		cp.add(combobox);

		tabbPane.setLocation(0, 150);
		tabbPane.setSize(frameWidth, frameHeight - tabbPane.getY());
		tabbPane.addTab("Geschlecht", gender);
		tabbPane.addTab("Immigranten", immigration);

		cp.add(tabbPane);

		arrowLeft = new JButton(IconArLeft);
		arrowLeft.setSize(100, 100);
		arrowLeft.setLocation(
				(int) (frameWidth * 0.2 - arrowLeft.getWidth() / 2), 30);
		arrowLeft.setFocusable(false);
		arrowLeft.setContentAreaFilled(false);
		arrowLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
		arrowLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.left(e);

			}
		});
		cp.add(arrowLeft);

		arrowRight = new JButton(IconArRight);
		arrowRight.setSize(100, 100);
		arrowRight.setLocation(
				(int) (frameWidth * 0.79 - arrowLeft.getWidth() / 2), 30);
		arrowRight.setFocusable(false);
		arrowRight.setContentAreaFilled(false);
		arrowRight.setCursor(new Cursor(Cursor.HAND_CURSOR));
		arrowRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.right(e);

			}
		});
		cp.add(arrowRight);

		Image img = Toolkit.getDefaultToolkit().getImage(
				"blazon/" + combobox.fileList[con.currentState].getName());

		blazon.setSize(100, 100);
		blazon.setLocation(frameWidth / 2 - blazon.getWidth() / 2, 30);
		blazon.setFocusable(false);
		blazon.setContentAreaFilled(false);
		blazon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		blazon.setIcon(new ImageIcon(img.getScaledInstance(blazon.getWidth(),
				blazon.getHeight(), Image.SCALE_SMOOTH)));
		blazon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				con.actionBlaze(e);
			}
		});
		cp.add(blazon);

		this.repaint();

		for (Component c : cp.getComponents()) {
			c.addMouseListener(this);
		}

		// Ende Komponenten

		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (combobox.isVisible()) {
			int x = e.getXOnScreen() - this.getX() - combobox.getX() - 1;
			int y = e.getYOnScreen() - this.getY() - combobox.getY() - 32;

			if (!combobox.contains(x, y)) {
				combobox.setVisible(false);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}