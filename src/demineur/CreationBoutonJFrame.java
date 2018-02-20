package demineur;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreationBoutonJFrame extends JFrame {
	private JFrame f;
	private JPanel p;
	private JButton bouton;

	public CreationBoutonJFrame() {
		// TODO Auto-generated constructor stub
	
		f = new JFrame("Test");
		f.setVisible(true);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(null);// set du panel a 0 0 sinon je peux pas placer le bouton;

		int x = 0;
		int y = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				addButtons(x, y);
				x += 21;
			}
			x = 0;
			y += 21;
		}
		addBlack();
	
	
	}
	public void addButtons(int x, int y) {
		bouton = new JButton();
		bouton.setBackground(Color.RED);
		bouton.setBorderPainted(false);
		bouton.setOpaque(true);// sinon on voit rien (sous Mac en tt cas)
		bouton.setBounds(x, y, 20, 20);// positionner le bouton

		
		p.add(bouton);
		f.add(p);
		//f.setLocationRelativeTo(null);
	}

	public void addBlack() {
		JButton bouton2 = new JButton();
		bouton2.setBackground(Color.BLACK);
		bouton.setBorderPainted(false);

		bouton2.setOpaque(true);// sinon on voit rien (sous Mac en tt cas)
		bouton2.setBounds(63, 63, 40, 40);// positionner le bouton

		
		p.add(bouton2);
		f.add(p);
	}
	public static void main(String[] args) {
		new CreationBoutonJFrame();

	}
}
