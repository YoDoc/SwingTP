/* Pas de frame a declarer vu qu'on est a extendsJFrame 
 * Donc si je fais un setTitle, alors c'est equivalent aframe.setTitle, comme un this.seTitle
 * 
 * 
 * IL va falloir fixer les tailles des boutons en fonction de la taille de la frame*/

package demineur;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DemineurVersionQuiMarche extends JFrame {
	// La grille de jeu
	private int[][] grille;
	// La grille des cases ouvertes par le joueur
	private boolean[][] ouvertes;
	private int largeurGrid;
	private int hauteurGrid;
	private int nombreBombes;
	int sizeFrameLargeur = 500;
	int sizeFrameHauteur = 500;
	boolean perdu;
	boolean[][] bombeMarquee;

	// mes coordonees x et y qui vont me servir pour construire label et bouton
	int x = 0;
	int y = 0;

	public DemineurVersionQuiMarche(int largeur, int hauteur, int nombreBombes) {
		this.largeurGrid = largeur;
		this.hauteurGrid = hauteur;
		this.nombreBombes = nombreBombes;

		setTitle("Demineur");
		setSize(sizeFrameLargeur, sizeFrameHauteur);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		initialise();
		placerBombes();
		// afficher(); TODO M�thode d�sactiv�e
		rafraichir();
		setVisible(true);
	}

	// Methode de construction du Label en fonction des valeurs � afficher
	/*
	 * private void factoryLabel() { JLabel label = new JLabel();
	 * label.setText("X"); label.setBounds(x, y, (sizeFrameLargeur / largeur),
	 * (sizeFrameHauteur / hauteur)); add(label); }
	 */

	/*
	 * private void factoryBouton() { JButton bouton = new JButton();
	 * bouton.setBackground(Color.GRAY); bouton.setBorderPainted(false);
	 * bouton.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
	 * bouton.setBounds(x, y, (sizeFrameLargeur / largeur), (sizeFrameHauteur /
	 * hauteur));// positionner le // bouton bouton.addActionListener(new
	 * ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * //System.out.println("click"); ouvertes[i][j] = true; // rafraichir();
	 * 
	 * } }); add(bouton); }
	 */

	/*------------ METHODE RAFRAICHIR    Rafraichit la fen�tre en fonction de l'�tat courant de la grille  */
	// Methode afficher label si Case ouverte
	
	/* public void factoryLabel(int i, int j) {

		if (ouvertes[i][j] == true) {

			//Plus tard au besoin ce sera la m�thode: factoryLabel() 
			JLabel label = new JLabel();
			label.setText(Integer.toString(grille[i][j]));
			if ((grille[i][j]) == 0) {
				label.setText("");
			}

			label.setBounds(i * (sizeFrameLargeur / largeurGrid), j * (sizeFrameHauteur / hauteurGrid),
					(sizeFrameLargeur / largeurGrid), (sizeFrameHauteur / hauteurGrid));
			add(label);
		}
	}
	*/

	/*
	 * UNUSED private void factoryButton (int a, int b){ JButton bouton = new
	 * JButton(); // bouton cree ici pour le passer rouge en cas de bombe marquee;
	 * 
	 * bouton.setBackground(Color.GRAY); bouton.setBorderPainted(true);
	 * bouton.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
	 * bouton.setBounds(a * (sizeFrameLargeur / largeurGrid), b * (sizeFrameHauteur
	 * / hauteurGrid), (sizeFrameLargeur / largeurGrid), (sizeFrameHauteur /
	 * hauteurGrid));// positionner le bouton if (bombeMarquee[a][b] == true) {
	 * bouton.setBackground(Color.RED); } bouton.addMouseListener(new
	 * MouseListener() {
	 * 
	 * @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void mousePressed(MouseEvent e) { // TODO Auto-generated
	 * method stub }
	 * 
	 * @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
	 * method stub }
	 * 
	 * @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
	 * method stub }
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { e.getButton(); if
	 * (e.getButton() == MouseEvent.BUTTON1) { ouvrirCase(a, b);
	 * //testerVictoire(ouvertes); rafraichir(); } else if (e.getButton() ==
	 * MouseEvent.BUTTON3) { // e.getComponent().setBackground(Color.RED);
	 * bombeMarquee[a][b] = true; rafraichir(); // testerVictoire(ouvertes);
	 * 
	 * }
	 * 
	 * } });
	 * 
	 * // if (grille[a][b] == -1) // bouton.setBackground(Color.RED);// TODO A virer
	 * juste pour tricher // if (grille[a][b] == 0) //
	 * bouton.setBackground(Color.WHITE);// TODO A virer juste pour tricher
	 * 
	 * add(bouton); }
	 */

	private void rafraichir() {
		testerVictoire(ouvertes); /* TODO PB Sur la Methode, le sysOUT est OK pas l'ajout du bouton */

		if (perdu == true) { // Si case bombe d�voil�e, fin de partie (boolean)

			JButton perdu = new JButton();
			perdu.setBackground(Color.RED);
			perdu.setBorderPainted(true);
			perdu.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
			perdu.setBounds(200, 200, 100, 100);
			perdu.setText("PERDU");
			add(perdu);
			repaint();
			System.out.println("PERDU");
			/* SHOW GRID */
			return;
		}
		getContentPane().removeAll(); // Premi�re �tape : on supprime tous les composants d�j� pr�sents

		// Deuxi�me �tape : on construit la fen�tre en ajoutant les composants (boutons
		// et labels)
		for (int i = 0; i < largeurGrid; i++) {
			for (int j = 0; j < hauteurGrid; j++) {
				int a = i;
				int b = j;

				if (ouvertes[i][j] == true) {

					// Plus tard au besoin ce sera la m�thode: factoryLabel()
					JLabel label = new JLabel();
					label.setText(Integer.toString(grille[i][j]));
					if ((grille[i][j]) == 0) {
						label.setText("");
					}

					label.setBounds(i * (sizeFrameLargeur / largeurGrid), j * (sizeFrameHauteur / hauteurGrid),
							(sizeFrameLargeur / largeurGrid), (sizeFrameHauteur / hauteurGrid));
					add(label);
				}
				
				// Sinon Case ferm�e : un bouton:
				else {
				JButton bouton = new JButton(); // bouton cree ici pour le passer rouge en cas de bombe marquee;

				bouton.setBackground(Color.GRAY);
				bouton.setBorderPainted(true);
				bouton.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
				bouton.setBounds(a * (sizeFrameLargeur / largeurGrid), b * (sizeFrameHauteur / hauteurGrid),
						(sizeFrameLargeur / largeurGrid), (sizeFrameHauteur / hauteurGrid));// positionner le bouton
				if (bombeMarquee[a][b] == true) {
					bouton.setBackground(Color.RED);
				}
				bouton.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						e.getButton();
						if (e.getButton() == MouseEvent.BUTTON1) {
							ouvrirCase(a, b);
							// testerVictoire(ouvertes);
							rafraichir();
						} else if (e.getButton() == MouseEvent.BUTTON3) {
							// e.getComponent().setBackground(Color.RED);
							bombeMarquee[a][b] = true;
							rafraichir();
							// testerVictoire(ouvertes);

						}

					}
				});

				// if (grille[a][b] == -1)
				// bouton.setBackground(Color.RED);// TODO A virer juste pour tricher
				// if (grille[a][b] == 0)
				// bouton.setBackground(Color.WHITE);// TODO A virer juste pour tricher

				add(bouton);
			}
			// UNUSED : else factoryButton(a,b);

		}
		repaint(); // A la fin, on appelle repaint()
	}
	}
	/*------------        FIN METHODE RAFRAICHIR   ------------  */

	// Methode de test de case, la methode me return un boolean donc le test est
	// dans dans CE retour;
	public boolean maCaseEstValide(int i, int j) {
		return (i >= 0 && i < largeurGrid && j >= 0 && j < hauteurGrid);

	}

	/* PB Sur la Methode, le sysOUT est OK pas l'ajout du bouton */
	public void testerVictoire(boolean[][] ouvertes) {
		int drapeau = 0;
		for (int i = 0; i < largeurGrid; i++) {
			for (int j = 0; j < hauteurGrid; j++) {
				if (ouvertes[i][j] == false)
					drapeau++;
			}
		}
		if (drapeau == nombreBombes) {
			JButton gagne = new JButton();
			gagne.setBackground(Color.BLUE);
			gagne.setBorderPainted(true);
			gagne.setOpaque(true);// sinon on voit rien, sous Mac en tt cas
			gagne.setBounds(200, 200, 100, 100);
			gagne.setText("GAGNE");
			add(gagne);
			repaint();
			System.out.println("GAGNE");
			/* SHOW GRID */
			return;

		}
	}

	// Ouvre une case et propage l'ouverture si elle vaut z�ro
	@SuppressWarnings("unused")
	private void ouvrirCase(int i, int j) {
		if (ouvertes[i][j]) // A NE PAS OUBLIER: condition d'arret de la r�cursive
			return; // COMMENT ARRETER UNE FONCTION? Faire un Return
		ouvertes[i][j] = true;
		if ((grille[i][j]) == -1) {
			perdu = true;
		}

		// System.out.println("Fin de partie");

		if (grille[i][j] == 0) {
			for (int a = (i - 1); a <= (i + 1); a++) {
				for (int b = (j - 1); b <= (j + 1); b++) {
					if (maCaseEstValide(a, b)) {
						ouvrirCase(a, b);
					}
				}
			}
		}

	}

	// Place des bombes de fa�on al�atoire sur la grille
	private void placerBombes() {
		// On place autant de bombes que nombreBombes
		for (int i = 0; i < nombreBombes; i++) {
			int x = 0, y = 0;
			Random random = new Random();
			// On tire deux entiers tant qu'on tombe sur une bombe
			do {
				x = random.nextInt(largeurGrid);
				y = random.nextInt(hauteurGrid);
			} while (grille[x][y] == -1);

			// On pose la bombe
			grille[x][y] = -1;
			// On incr�mente les cases adjacentes
			incremente(x - 1, y - 1);
			incremente(x - 1, y);
			incremente(x - 1, y + 1);
			incremente(x, y - 1);
			incremente(x, y + 1);
			incremente(x + 1, y - 1);
			incremente(x + 1, y);
			incremente(x + 1, y + 1);
		}
	}

	// Incremente une case si elle est valide : elle est bien dans la grille et elle
	// ne contient pas d�j� une bombe.

	public void incremente(int x, int y) {
		if (x >= 0 && x < largeurGrid && y >= 0 && y < hauteurGrid && grille[x][y] != -1)
			grille[x][y]++;
	}

	// Initialise la grile avec des z�ros

	public void initialise() {
		grille = new int[largeurGrid][hauteurGrid];
		ouvertes = new boolean[largeurGrid][hauteurGrid];
		bombeMarquee = new boolean[largeurGrid][hauteurGrid];
		for (int i = 0; i < largeurGrid; i++) {
			for (int j = 0; j < hauteurGrid; j++) {

				// Aucune bombe � proximit� : valeur z�ro

				grille[i][j] = 0;
				// La case n'a pas �t� ouverte : valeur � false
				ouvertes[i][j] = false;
				bombeMarquee[i][j] = false;
			}
		}
	}

	// Affiche la grille
	public void afficher() {
		for (int i = 0; i < largeurGrid; i++) {
			for (int j = 0; j < hauteurGrid; j++) {
				System.out.print(grille[j][i] + "\t");

			}

			System.out.print("\n");
		}

	}

	public static void main(String[] args) {
		DemineurVersionQuiMarche demineur = new DemineurVersionQuiMarche(20, 20, 5);
		demineur.setVisible(true);
	}

}