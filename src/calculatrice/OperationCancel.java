package calculatrice;


@SuppressWarnings("serial")
public class OperationCancel extends Bouton {

	public OperationCancel(Calculatrice c, String toto) {
		super(c);
		toto ="C";
		setText(toto);
		
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		// recupere mon Objet de calculatrice qui stocke ce qui est affiche
		//double nbAffiche = Double.parseDouble(super.getCalculatrice().getNbSaisie()); 
		// recupere mon Objet de calculatrice qui stocke la memoire																				// l'affichage
		//double nbMemorise = super.getCalculatrice().getMemoire(); 
		String nbAffiche="";
		double nbMemorise = 0;
		super.getCalculatrice().afficher(nbAffiche);
		super.getCalculatrice().setMemoire(nbMemorise);
	}
	
	
	
}	