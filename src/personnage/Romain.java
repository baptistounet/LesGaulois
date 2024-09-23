package personnage;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
//		Romain francois = new Romain("Fran�ois", 3);
//		System.out.println(francois.prendreParole());
//		francois.parler("Ciao !");
//		francois.recevoirCoup(1);
//		francois.recevoirCoup(30);
	}
}
