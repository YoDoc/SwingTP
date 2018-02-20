package calculatrice;

@SuppressWarnings("serial")
public class OperationRacine extends BoutonOperation {

	public OperationRacine(Calculatrice c, String toto) {
		super(c, toto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double toModeDeCalcul(double nbMemorise, double nbAffiche) {
		// TODO Auto-generated method stub
		return Math.sqrt(nbAffiche);
	}

}
