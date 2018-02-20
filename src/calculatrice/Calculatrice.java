package calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculatrice extends JFrame {

	// Declaration des Variables. Elles sont privees donc Getter/Setter
	private JTextField affichage = new JTextField(); // TextField= champ de saisie de texte
	private JPanel chiffres = new JPanel(); // Nouveau panel qui contiendra les chiffres
	private JPanel commandes = new JPanel(); // Nouveau panel qui contiendra les commandes
	private double memoire = 0; //TODO va stocker la memoire pour pouvoir vider
	private boolean rAZ;
	I_Operation memoireOperation; // Objet de type I_Operation qui va me servir pour stocker l'operation precedente 
	
	public boolean isrAZ() { //getter de boolan
		return rAZ;
	}

	public void setrAZ(boolean rAZ) {
		this.rAZ = rAZ;
	}

	
	/*-----------   GETTER SETTERS -------------*/
	
	

	public I_Operation getMemoireOperation() {
		return memoireOperation;
	}

	public void setMemoireOperation(I_Operation memoireOperation) {
		this.memoireOperation = memoireOperation;
	}

	public double getMemoire() {
		return memoire;
	}
	
	public void setMemoire(double memoire) {
		this.memoire = memoire;
	}
	public JTextField getAffichage() {
		return affichage;
	}

	public JPanel getChiffres() {
		return chiffres;
	}

	public void setChiffres(JPanel chiffres) {
		this.chiffres = chiffres;
	}

	public JPanel getCommandes() {
		return commandes;
	}

	public void setCommandes(JPanel commandes) {
		this.commandes = commandes;
	}

	public void setAffichage(JTextField affichage) {
		this.affichage = affichage;
	}

	/*-----------   CONSTRUCTEUR -------------*/
	public Calculatrice() {

		// JFRAME: titre, ferme si close, layout en border et visible
		setTitle("Calculatrice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);

		// JPanel affichage
		affichage.setPreferredSize(new Dimension(200, 50));
		affichage.setLayout(new BorderLayout()); // D�finition de la border Layout de ce champ
		affichage.setBackground(Color.LIGHT_GRAY); // affichage du fond du champ selon la regle de la BorderLayout
		add(affichage, BorderLayout.PAGE_START); // position de ce champ

		// JPanel chiffres qui contiendra les chiffres
		chiffres.setLayout(new GridLayout(4, 3)); // type de rangement, type grille de 4 colonnes et 2 lignes
		//chiffres.setFont(new Font("arial", NORMAL, 40));
		add(chiffres, BorderLayout.LINE_START); // ajout du panel dans la frame et position de ce panel
		chiffres.add(new BoutonChiffre(this, "1")); // comme argument Bouton, il veut un
		chiffres.add(new BoutonChiffre(this, "2"));// TODO
		chiffres.add(new BoutonChiffre(this, "3"));
		chiffres.add(new BoutonChiffre(this, "4"));
		chiffres.add(new BoutonChiffre(this, "5"));
		chiffres.add(new BoutonChiffre(this, "6"));
		chiffres.add(new BoutonChiffre(this, "7"));
		chiffres.add(new BoutonChiffre(this, "8"));
		chiffres.add(new BoutonChiffre(this, "9"));
		chiffres.add(new BoutonChiffre(this, "0"));
		chiffres.add(new BoutonChiffre(this, "."));
		chiffres.add(new OperationEgal(this, "="));

		// JPanel commandes qui contiendra les commandes (IDEM)
		commandes.setLayout(new GridLayout(4, 2));
		add(commandes, BorderLayout.LINE_END);
		commandes.add(new OperationCancel(this, "C"));
		commandes.add(new OperationBack(this, "<"));
		commandes.add(new OperationPlus(this, "+"));
		commandes.add(new OperationMoins(this, "-"));
		commandes.add(new OperationMult(this, "*"));
		commandes.add(new OperationDiv(this, "/"));
		commandes.add(new OperationCarre(this, "^"));
		commandes.add(new OperationRacine(this, "R"));

		pack(); // compacter le tout (un peu identique a repaint)

	}

	public void afficher(String n) {
		affichage.setText(n);
		// commandes.setText(n);
	}

	public void effaceEcran() {
		this.affichage=null;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Calculatrice calculatrice = new Calculatrice();
		// TODO Auto-generated method stub

	}

	public String getNbSaisie() {
		// TODO Auto-generated method stub
		return affichage.getText();
	}

	// Methode pour stocker l'affichage. le 1er chiffre devient une dizaine et ainsi
	// de suite.
}
