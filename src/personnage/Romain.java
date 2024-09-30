package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert isForcePositive(force);
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isForcePositive(force);
		int forceDebut = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert isForceInferieur(forceDebut, force);
	}

	public void sEquiper(Equipement nouveauEquipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déja bien protégé !");
			break;
		case 1:
			if (nouveauEquipement == equipement[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + nouveauEquipement.toString());
			} else {
				ajouterEquipement(nouveauEquipement);
			}
			break;
		default:
			ajouterEquipement(nouveauEquipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement nouveauEquipement) {
		equipement[nbEquipement] = nouveauEquipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + nouveauEquipement.toString());
	}

	private Boolean isForcePositive(int force) {
		if (force > 0) {
			return true;
		} else {
			System.out.println("Force négative");
			return false;
		}
	}

	private Boolean isForceInferieur(int forceDebut, int forceFin) {
		if (forceDebut - forceFin > 0) {
			return true;
		} else {
			System.out.println("La force n'a pas diminué");
			return false;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
//		System.out.println(minus.prendreParole());
//		minus.parler("Ciao !");
//		minus.recevoirCoup(1);
//		minus.recevoirCoup(30);
//		System.out.println(Equipement.BOUCLIER);
//		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
