package calculatrice;

@SuppressWarnings("serial")
public class OperationPlus extends BoutonOperation {

	public OperationPlus(Calculatrice c, String toto) {
		super(c, toto);
	}

	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		return nbAffiche+nbMemorise;
	}

	
}
