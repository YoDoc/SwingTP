package demineur;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*--------   			CLASSE   		      --------*/

@SuppressWarnings("serial")
public class Demineur extends JFrame {
	int hauteur;
	int largeur;
	int grille[][];
	int bombes;

	private JFrame f;
	private JPanel p;
	private JButton bouton;

	/* J'ai 2 constructeurs mais en fait je peux les fusionner */

	/*--------   	CONSTRUCTEUR 1  Faire la page Demineur		      --------*/
	public Demineur(int largeur, int hauteur) {

		f = new JFrame("Demineur");
		f.setVisible(true);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setLayout(null);// set du panel a 0 0 sinon je peux pas placer le bouton;

		int x = 0;
		int y = 0;

		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				addButtons(x, y);
				x += 21;
			}
			x = 0;
			y += 21;
		}

		/*
		 * // Faire une methode de type Repaint Style Component.paint(java.awt.Graphics)
		 * 
		 * repaint
		 * 
		 * public void repaint(long time, int x, int y, int width, int height)
		 */
	}

	/*--------   CONSTRUCTEUR 2  Genere la Matrice		      --------*/

	public Demineur(int largeur, int hauteur, int bombes) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.bombes = bombes;
		grille = new int[largeur][hauteur];
		bombes = -1;

		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				grille[i][j] = 0;

			}
		}
		generateBombs();
		showgrid();
		rafraichir();
	}

	/*--------  		METHODE Refresh grille 	  	      --------*/

	private void rafraichir() {
		// Première étape : on supprime tous les composants déjà présents
		getContentPane().removeAll();
		// Deuxième étape : on construit la fenêtre en ajoutant les composants (boutons
		// et labels)
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				// Case ouverte : un label
				// Sinon : un bouton
				// TODO
			}
		}
		// A la fin, on appelle repaint()
		repaint();
	}
	
	/*--------  		METHODE VISUALISATION BOUTONS 	  	      --------*/
	public void addButtons(int x, int y) {
		bouton = new JButton();
		bouton.setBackground(Color.RED);
		bouton.setFont(new Font("Arial", Font.BOLD, 25));// ESSAI DE TEXT MAIS TROP PETIT
		bouton.setText("A");// TEXT
		bouton.setBorderPainted(false);
		bouton.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
		bouton.setBounds(x, y, 20, 20);// positionner le bouton

		p.add(bouton);
		f.add(p);
		repaint();
	}

	/*--------  		 METHODE GENERATE BOMB 	  	      --------*/

	public void generateBombs() {
		int n = 0;
		while (n < bombes) {
			int x = 0;
			int y = 0;

			do {
				Random random = new Random();
				x = random.nextInt(largeur);
				y = random.nextInt(hauteur);
			} while (grille[x][y] == -1);

			grille[x][y] = -1;
			increment(x - 1, y - 1);
			increment(x - 1, y);
			increment(x - 1, y + 1);
			increment(x, y - 1);
			increment(x, y + 1);
			increment(x + 1, y - 1);
			increment(x + 1, y);
			increment(x + 1, y + 1);
			n++;
		}
	}

	/*--------   METHODE INCREMENT         --------*/
	public void increment(int x, int y) {
		if (x >= 0 && x < largeur && y >= 0 && y < hauteur && (grille[x][y] != -1))
			grille[x][y]++;
	}

	/*--------   METHODE SHOWGRID         --------*/
	public void showgrid() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {

				System.out.print(grille[i][j] + "\t");
			}
			System.out.println();

		}
	}

	/*--------         MAIN          --------*/
	public static void main(String[] args) {
		int hauteur = 15;
		int largeur = 15;
		int bombes = 5;

		new Demineur(hauteur, largeur, bombes);
		new Demineur(hauteur, largeur);
	}

}
