package personnage;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantSatisfied();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private boolean isInvariantSatisfied() {
		return force >= 0;
	}

//	public void recevoirCoup(int forceCoup) {
//		int var_loc = force;
//		force -= forceCoup;
//		assert isInvariantSatisfied();
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceCoup < var_loc;
//	}

	public int getForce() {
		return force;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force = force - forceCoup;
		
		assert isInvariantSatisfied();
		if (force > 0 ) {

			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texte = texte + resistanceEquipement + "!";
		}
		parler(texte);
		if (resistanceEquipement > forceCoup) {
			System.out.println("La force du coup est totalement recouvert par les" + " equipements :)");
			nbEquipement = 0; 
			forceCoup = 0;
			
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {

		switch (nbEquipement) {
		case 2: {
			System.out.println("le soldat " + nom + " est deja bien protege !");
			break;
		}
		case 1: {
			if (equipements[0].equals(equipement)) {
				System.out.println("le soldat " + nom + " possede deja un " + equipement);
			} else {
				extracted(equipement);
			}
			break;
		}

		default:
			extracted(equipement);
			break;
		}
	}

	private void extracted(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement += 1;
		System.out.println("le soldat " + getNom() + " s equipe avec un " + equipement);
	}

	public static void main(String[] args) {

		Romain minus = new Romain("minus", 10);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.parler("On va conquerir l amazonie !!");
		do {
			minus.recevoirCoup(2);
		} while (minus.getForce() > 0);

	

	}

}