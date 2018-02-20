package calculatrice;

@SuppressWarnings("serial")
public class OperationMoins extends BoutonOperation {

	public OperationMoins(Calculatrice c, String toto) {
		super(c, toto);
	}
	
	
	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		// TODO Auto-generated method stub
		return nbMemorise-nbAffiche;
	}

}
