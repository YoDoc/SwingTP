package calculatrice;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// Cette classe bouton va avoir tout d'un JButton en plus riche
@SuppressWarnings("serial")
public abstract class Bouton extends JButton {

	public abstract void execute(); // Cette classe fait appel a la methode generale execute

	private Calculatrice calculatrice; // Il a besoin d'interagir avec calculatrice

	
	public Calculatrice getCalculatrice() {
		return calculatrice;
	}


	public void setCalculatrice(Calculatrice calculatrice) {
		this.calculatrice = calculatrice;
	}

 
	public Bouton(Calculatrice c) {
		// TODO Auto-generated constructor stub
		
		setPreferredSize(new Dimension(80,80));
		this.calculatrice = c;
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				execute();

			}

			// TODO Ajouter la commande executer

		});

	}
}
