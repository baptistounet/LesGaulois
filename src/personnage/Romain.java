package personnage;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert isForcePositive(force);
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
		assert isForcePositive(force);
		int forceDebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert isForceInferieur(forceDebut, force);
	}

	private Boolean isForcePositive(int force) {
		if (force > 0) {
			return true;
		} else {
			System.out.println("Force n�gative");
			return false;
		}
	}

	private Boolean isForceInferieur(int forceDebut, int forceFin) {
		if (forceDebut - forceFin > 0) {
			return true;
		} else {
			System.out.println("La force n'a pas diminu�");
			return false;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Ciao !");
		minus.recevoirCoup(1);
		minus.recevoirCoup(30);
	}
}
