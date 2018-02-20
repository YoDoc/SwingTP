package calculatrice;


@SuppressWarnings("serial")
public class OperationEgal extends BoutonOperation {

	public OperationEgal(Calculatrice c, String toto) {
		super(c, toto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		
		return nbMemorise;
	}

}
