package calculatrice;

@SuppressWarnings("serial")
public class OperationDiv extends BoutonOperation {

	public OperationDiv(Calculatrice c, String toto) {
		super(c, toto);
	}

	@Override
	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		return nbMemorise/nbAffiche;
	}

}
