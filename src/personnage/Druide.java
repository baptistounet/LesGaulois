package personnage;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	private Random random = new Random();
	private static final int FORCE_MOYENNE = 7;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (forcePotion > FORCE_MOYENNE) {
			parler("J'ai pr�par� une super potion de force " + forcePotion);
		} else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force " + forcePotion);
		}
	}

	public void booster(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		if (nomGaulois != null && nomGaulois.equals("Ob�lix")) {
			parler(" � Non, Ob�lix !... Tu n�auras pas de potion magique!�");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();

	}
}
