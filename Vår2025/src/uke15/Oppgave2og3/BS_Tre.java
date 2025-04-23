package uke15.Oppgave2og3;

public class BS_Tre<T extends Comparable<? super T>> extends BinaerTre<T> implements SoeketreADT<T> {
	BS_Tre() {
		super();
	}

	BS_Tre(T rotElement) {
		super(rotElement, null, null);
	}

	@Override
	public void setTre(T rotData) {
		// Vi ønskjer ikkje at denne metoden skal være tilgjengeleg
		// Ville i så fall være mulig å øydelegge det binære søketreet
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTre(T rotData, BinaerTre<T> venstre, BinaerTre<T> hogre) {
		// Vi ønskjer ikkje at denne metoden skal være tilgjengeleg
		// Ville i så fall være mulig å øydelegge det binære søketreet
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean inneholder(T element) {

		return finn(element) != null;
	}

	@Override
	public T finn(T element) {
		return finn(element, getRot());
	}

	private T finn(T element, BinaerTreNode<T> p) {

		T svar = null;
		// Basis: p == null -> Tomt tre, element finnes ikke
		if (p != null) {
			int sml = element.compareTo(p.getElement()); // negativ og den er mindre, 0 om likt, posetiv og større

			if (sml == 0) {
				// Andre basistilfellet , elementet finnes fra før
				return p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}

		return svar;
	}

	@Override
	public T leggTil(T nyttElement) {

		if (getRot() == null) {
			setRot(new BinaerTreNode<T>(nyttElement));
			return null;
		} else {
			return leggTil(nyttElement, getRot());
		}
	}

	private T leggTil(T nyttElement, BinaerTreNode<T> p) {
		// Vet at p != null pga metoden ovenfor sjekker det

		T resultat = null;
		int sml = nyttElement.compareTo(p.getElement());

		if (sml == 0) {
			resultat = p.getElement();
			p.setElement(nyttElement);

			// Hvis elemenetet er mindre enn 0 - skal på Venstre side
		}
		if (sml < 0) {
			if (p.getVenstre() == null) { // Hvis venstre er ledig, funnet rett plass
				p.setVenstre(new BinaerTreNode<T>(nyttElement));
			} else {
				resultat = leggTil(nyttElement, p.getVenstre());
			}
			// Hvis Elementet er større en 0 -> skal på høyre side
		} else {
			if (p.getHogre() == null) { // Hvis venstre er ledig, funnet rett plass
				p.setHogre(new BinaerTreNode<T>(nyttElement));
			} else {
				resultat = leggTil(nyttElement, p.getHogre());
			}
		}

		return resultat;
	}

	@Override
	public T fjern(T element) {
		/*
		 * Det er ikkje pensum å kunne skrive kode for denne.
		 */

		throw new UnsupportedOperationException();
	}

	public void skrivVerdier(T nedre, T ovre) {
		skrivVerdierRek(getRot(), nedre, ovre);
	}

	private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
		if (t != null) {
			
			skrivVerdierRek(t.getVenstre(), min, maks);
			
			if ((t.getElement().compareTo(min) >= 0) && (t.getElement().compareTo(maks) <= 0)) {
				System.out.print(t.getElement() + " ");
			}
			skrivVerdierRek(t.getHogre(), min, maks);
		}
	}
	
	public void skrivVerdierRek(T nedre, T ovre) {
		skrivVerdierRek2(getRot(), nedre, ovre);
	}
	
	
	private void skrivVerdierRek2(BinaerTreNode<T> t, T min, T maks) {
		if (t != null) {
			
			
			//sjekker først om det er verdt å gå til neste node dvs. om noden har større element enn min-parameter
			if(t.getElement().compareTo(min) > 0) {
				skrivVerdierRek2(t.getVenstre(), min, maks);
			}
			
			//skriver ut om det er mellom min og maks
			if(t.getElement().compareTo(min) >= 0 && t.getElement().compareTo(maks) <= 0) {
				System.out.print(t.getElement() + " " );
				
			}
			
			//sjekker høyre del på samme måte som venstre - stopper om noden inneholder høyere verdi enn maks-parameter
			if(t.getElement().compareTo(maks) < 0) {
				skrivVerdierRek2(t.getHogre(), min, maks);
			}
		}
	}

}
