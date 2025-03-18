package oppgave4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	Set<T> JavaSet;

	// Constructor
	public JavaSetToMengde() {

		JavaSet = new HashSet<>();
	}

	public JavaSetToMengde(T Element) {

		JavaSet = new HashSet<>();
		JavaSet.add(Element);
	}

	@Override
	public boolean erTom() {
		return JavaSet.isEmpty();
	}

	@Override
	public boolean inneholder(Object element) {
		return JavaSet.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT annenMengde) {

		// En delmengde kan ikke være størren enn mengden den er delmengde av
		if (JavaSet.size() > annenMengde.antallElementer()) {
			return false;
		} else {
			for (T element : JavaSet) {
				if (!annenMengde.inneholder(element)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean erLik(MengdeADT annenMengde) {

		if (JavaSet.size() != annenMengde.antallElementer()) {
			return false;
		} else {
			for (T element : JavaSet) {
				if (!annenMengde.inneholder(element)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT annenMengde) {

		for (T element : JavaSet) {
			if (annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT snitt(MengdeADT annenMengde) {

		MengdeADT snitt = new JavaSetToMengde<T>();

		for (T element : JavaSet) {
			if (annenMengde.inneholder(element)) {
				snitt.leggTil(element);
			}
		}
		return snitt;
	}

	@Override
	public MengdeADT union(MengdeADT annenMengde) {

		// Legger til alle elementer fra JavaSet
		MengdeADT union = new JavaSetToMengde<>();
		for (T element : JavaSet) {
			union.leggTil(element);
		}
		// Legger til alle elementer fra annenMengde
		T[] tab = (T[]) annenMengde.tilTabell();
		for (T element : tab) {
			union.leggTil(element);
		}
		return union;
	}

	@Override
	public MengdeADT minus(MengdeADT annenMengde) {

		MengdeADT minus = new JavaSetToMengde<>();

		for (T element : JavaSet) {
			if (!annenMengde.inneholder(element)) {
				minus.leggTil(element);
			}
		}
		return minus;
	}

	@Override
	public void leggTil(T element) {
		JavaSet.add((T) element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT annenMengde) {

		T[] tab = (T[]) annenMengde.tilTabell();

		for (int i = 0; i < tab.length; i++) {
			JavaSet.add((T) tab[i]);
		}
	}

	@Override
	public T fjern(T element) {

		if (JavaSet.remove(element)) {
			return element;
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		return (T[]) JavaSet.toArray();
	}

	@Override
	public int antallElementer() {
		return JavaSet.size();
	}

}
