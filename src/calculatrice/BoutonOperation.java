package calculatrice;

@SuppressWarnings("serial")
public abstract class BoutonOperation extends Bouton implements I_Operation {

	public BoutonOperation(Calculatrice c, String toto) {
		super(c);
		setText(toto);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// Objet mon Objet de calculatrice qui stocke mon operation en cours
		I_Operation operationMemoire = super.getCalculatrice().getMemoireOperation();
		// recupere mon Objet de calculatrice qui stocke ce qui est affiche
		double nbAffiche = Double.parseDouble(super.getCalculatrice().getNbSaisie()); 
		// recupere mon Objet de calculatrice qui stocke la memoire																				// l'affichage
		double nbMemorise = super.getCalculatrice().getMemoire(); 

		
		double resultat = nbAffiche;
		
		// Gere le cas de départ ou il n'y a rien en mémoire;
		if (operationMemoire != null) resultat = operationMemoire.toModeDeCalcul(nbMemorise, nbAffiche);
		
		//Methode pour afficher cree dans Calculatrice
		super.getCalculatrice().afficher(Double.toString(resultat));
		super.getCalculatrice().setMemoire(resultat);
		
		super.getCalculatrice().setMemoireOperation (this);
		super.getCalculatrice().setrAZ(true); // passe le boolean de RAZ en true;

		// TODO Auto-generated method stub
		// super.getCalculatrice().effaceEcran(operation);

	}

}
