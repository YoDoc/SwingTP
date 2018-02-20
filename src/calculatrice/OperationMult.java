package calculatrice;


@SuppressWarnings("serial")
public class OperationMult extends BoutonOperation {

	public OperationMult(Calculatrice c, String toto) {
		super(c, toto);
		// TODO Auto-generated constructor stub
	}

	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		
		return nbMemorise*nbAffiche;
	}

}
