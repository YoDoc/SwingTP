package calculatrice;

@SuppressWarnings("serial")
public class OperationBack extends Bouton {

	public OperationBack(Calculatrice c, String back) {
		super(c);
		back ="<";
		setText(back);
	}

	@Override
	public void execute() {
		String nbAffiche="";
		super.getCalculatrice().afficher(nbAffiche);
	}

	

}
