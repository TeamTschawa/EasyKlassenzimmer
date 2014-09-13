package Gui;

import javax.swing.JFrame;

public class TestGui extends JFrame{
	KomboboxPanel kp = new KomboboxPanel();
	
	public TestGui() {
		super();
		this.setSize(700, 700);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setPreferredSize(kp.size());
		this.add(kp);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new TestGui();
	}
}
