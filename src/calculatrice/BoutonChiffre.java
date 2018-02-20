package calculatrice;

@SuppressWarnings("serial")
public class BoutonChiffre extends Bouton {

	String chiffreN = ""; // variable String
	Calculatrice calc;

	public BoutonChiffre(Calculatrice calcu, String chiffre) {
														/*
														 * A l'appel de ce constructeur, je lui rentre 2 données: - un parametre calc de
														 * la classe Calculatrice donc dans ses attributs ensuite il faut lui rentrer
														 * calculatrice. Comme elle est dans la classe de qui Bouton dépend ALORS mot
														 * clé super - un chiffre (correspond à celui que je veux affecter)=> 1°;2°;3°
														 */
		super(calcu);// Appel du constructeur Bouton (parent) avec calc comme parametre.
														// En fait pour construire un bouton chiffre, il me faut construire un bouton
														// (parent)
														// donc il me faut l'appeler.
														// Si jamais j'ai un constructeur vide dans la classe parent (ex la Super classe
														// Objet)
														// alors je n'ai pas besoin d'appeler le parent, ca se fait par defaut. Ici je
														// n'ai pas de constructeur vide
														// dans la classe parent (Bouton) donc, j'appelle via super().

		chiffreN = chiffre; // 1°/ce chiffre est affecté à chiffreN
		setText(chiffre); // 2°/ Du coup je lui demande de m'afficher ce chiffreN sur le bouton (setText)
		this.calc = calcu;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {

													// j'appelle getCalculatrice de ma classe mère (bouton)
													// 3°/ j'affiche ce chiffre sur le panel affichage
											
													// J'appelle la methode stockerAffichage dans la classe calculatrice
													// Je ne peux pas accéder à cette classe directement. Il me faut:
													// 1- Accéder a cette classe via le constructeur ci dessus. J'y rentre calcu,
													// que je stocke en local
													// en tant que calc (voir l'usage du this). Et je peux accéder à calc
													//
													// Dans cette classe calculatrice (connue comme calc ici), j'y cree une methode
													// qui prend un double
													// Ce double est présent quand je cree mes boutons. Je le recupere et je fais la
													// methode
		String toto = super.getCalculatrice().getNbSaisie();
		if (super.getCalculatrice().isrAZ()) toto = ""; // si RAZ est true (apres une operation), l'affichage a saisir est vide.
		String tata = toto + chiffreN;
		super.getCalculatrice().afficher(tata);
		super.getCalculatrice().setrAZ(false); // en cas de chiffre le boolean est false

	}

}