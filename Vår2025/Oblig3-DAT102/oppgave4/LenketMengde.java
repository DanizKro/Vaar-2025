package oppgave4;

public class LenketMengde<T> implements MengdeADT<T> {
	
	T data;
	LenketMengde<T> neste;

	public LenketMengde(T data) {
		this.data = data;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inneholder(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTil(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] tilTabell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antallElementer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
