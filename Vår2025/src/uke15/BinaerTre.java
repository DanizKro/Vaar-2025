package uke15;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaerTre<T> implements BinaerTreADT<T>, Iterable<T> {
	private BinaerTreNode<T> rot;

	public BinaerTre() {
		rot = null;
	}

	public BinaerTre(T data) {
		rot = new BinaerTreNode<>(data);
	}

	public BinaerTre(T rotData, BinaerTre<T> venstre, BinaerTre<T> hogre) {
		privateSetTre(rotData, venstre, hogre);
	}

	@Override
	public int getAntall() {
		return getAntall(rot);
	}

	private int getAntall(BinaerTreNode<T> t) {
		
		//Basis
		if(t == null) {
			return 0;
		}
		int antVenstre = getAntall(t.getVenstre());
		int antHoyre = getAntall(t.getHogre());

		return 1 + antVenstre + antHoyre;
	}
	
	@Override
	public int getAntallPaaNivaa(int k) {
		return getAntallPaaNivaa(rot, k);
	}
	
	private int getAntallPaaNivaa(BinaerTreNode<T> t, int k) {
		
		//1.Basis
		if(t == null) {
			return 0;
		}
		//2.Basis
		if(k == 1) {
			return 1;
		}
		
		int aV = getAntallPaaNivaa(t.getVenstre(), k-1);
		int aH = getAntallPaaNivaa(t.getHogre(), k-1);
		
		return aV + aH;
		
	}

	@Override
	public int getHogde() {
		return getHogde(rot);
	}

	private int getHogde(BinaerTreNode<T> t) {
			if (t == null) {
				return 0;
			}
			
			int hV = getHogde(t.getVenstre());
			int hH = getHogde(t.getHogre());
			return 1 + Math.max(hV, hH);
	}

	/*
	 * Dei tre vis-metodane nedanfor er tatt med for å vise rekursiv gjennnomgang av
	 * tre. Bruk av iteratorar er meir generelt for det er ikkje sikkert at du
	 * ønskjer å skrive ut elementa.
	 */
	public void visPreorden() {
		visPreorden(rot);
		System.out.println();
	}

	private void visPreorden(BinaerTreNode<T> t) {
		if (t == null) {
			// basis: gjer ingenting
		} else {
			System.out.print(t.getElement() + " ");
			visPreorden(t.getVenstre());
			visPreorden(t.getHogre());
		}
		
		/*
		 // basis gjer ingenting
		 if (t != null){
		    dei tre kodelinjene
		 }
		 */
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> t) {
		if (t == null) {
			// basis: gjer ingenting
		} else {
			visInorden(t.getVenstre());
			System.out.print(t.getElement() + " ");
			visInorden(t.getHogre());
		}
	}

	public void visPostorden() {
		visPostorden(rot);
	}

	private void visPostorden(BinaerTreNode<T> t) {
		
		//Basistilfellet
		if(t == null) {
			
		} else {
			visPostorden(t.getVenstre());
			visPostorden(t.getHogre());
			System.out.print(t.getElement());
		}
	}

	@Override
	public Iterator<T> getInordenIterator() {
		return new InordenIterator();
	}

	private class InordenIterator implements Iterator<T> {
		private StabelADT<BinaerTreNode<T>> nodeStack;
		private BinaerTreNode<T> currentNode;

		public InordenIterator() {
			nodeStack = new LenketStabel<>();
			currentNode = rot;
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext

		public T next() {
			BinaerTreNode<T> nextNode = null;

			// Find leftmost node with no left child
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getVenstre();
			} // end while

			// Get leftmost node, then move to its right subtree
			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null; // Since nodeStack was not empty
				// before the pop
				currentNode = nextNode.getHogre();
			} else
				throw new NoSuchElementException();

			return nextNode.getElement();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public T getRotData() {
		if (rot == null) {
			return null;
		} else {
			return rot.getElement();
		}
	}

	@Override
	public boolean erTom() {
		return rot == null;
	}

	@Override
	public void toem() {
		rot = null;
	}

	@Override
	public Iterator<T> getPreordenIterator() {
		// TODO Auto-generated method stub
		return new PreordenIterator();
	}

	private class PreordenIterator implements Iterator<T> {
		private StabelADT<BinaerTreNode<T>> nodeStack;
		private BinaerTreNode<T> currentNode;

		public PreordenIterator() {
			nodeStack = new LenketStabel<>();
			currentNode = rot;
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		public T next() {
			BinaerTreNode<T> nextNode = null;
			if (currentNode != null) {
				nextNode = currentNode;
				if (currentNode.getHogre() != null) {
					nodeStack.push(currentNode.getHogre());
					currentNode = currentNode.getVenstre();
				} else {
					if (!nodeStack.isEmpty()) {
						currentNode = nodeStack.pop();
					} else {
						currentNode = null;
					}
				}
			} else {
				if (!nodeStack.isEmpty()) {
					nextNode = nodeStack.pop();
					currentNode = nextNode.getVenstre();
				}
			}

			return nextNode.getElement();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new PreordenIterator();
	}
	@Override
	public Iterator<T> getPostOrdenIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getNivaaIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTre(T rotData) {
		rot = new BinaerTreNode<T>(rotData);
	}

	@Override
	public void setTre(T rotData, BinaerTreADT<T> venstre, BinaerTreADT<T> hogre) {
		// Generelt må vi gå gjennom venstre og høgre for å lage nye nodar
		// Metoden nedanfor fungerer for vår implementasjon
	}

	public void setTre(T rotData, BinaerTre<T> venstre, BinaerTre<T> hogre) {
		privateSetTre(rotData, venstre, hogre);
	}

	private void privateSetTre(T rotData, BinaerTre<T> venstre, BinaerTre<T> hogre) {
		rot = new BinaerTreNode<T>(rotData);

		if (venstre != null) {
			rot.setVenstre(venstre.rot);
		}

		if (hogre != null) {
			rot.setHogre(hogre.rot);
		}
	}
}