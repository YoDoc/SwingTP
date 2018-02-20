package calculatrice;

@SuppressWarnings("serial")
public class OperationCarre extends BoutonOperation {

	public OperationCarre(Calculatrice c, String toto) {
		super(c, toto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		return nbMemorise*nbMemorise;
	}

}
