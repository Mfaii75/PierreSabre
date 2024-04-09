package personnages;

import java.util.Random;

public class Grandmere extends Humains {

	public Grandmere(String nom, int nbargent) {
		super(nom, "tisane", nbargent);
	}

	public void memoriser(Humains autreHumain) {
		if (nbConnaissance < 5) {
			memoire[nbConnaissance] = autreHumain;
			nbConnaissance++;
		} else {
			for (int i = 0; i < 5 - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[memoire.length - 1] = autreHumain;
		}

	}

	private String humainHasard() {
		Random random = new Random();
		TypeHumain[] types = TypeHumain.values();
		return types[random.nextInt(types.length)].toString();
	}

	public void ragoter() {
		String TypeHumains = "";
		Humains humain;
		for (int i = 0; i < nbConnaissance; i++) {
			humains = memoire[i];
			if (humains instanceof Traitre) {
				parler("Je sais que " + humain.getNom() + " est un Traitre. Petit chenapan ");
			} else {
				parler("Je croit que " + humain.getNom() + " est un " + humainHasard());
			}
		}
	}

}
