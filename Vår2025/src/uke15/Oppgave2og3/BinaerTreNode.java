package uke15.Oppgave2og3;

public class BinaerTreNode<T>{
	
    private T element;    
    private BinaerTreNode<T> venstre;
    private BinaerTreNode<T>  hogre;
    private int hogdeU;
    
    BinaerTreNode (T el) {
    	element = el;
    	venstre = null;
    	hogre   = null;
    	hogdeU = 0;
    }
    
    // Flere konstruktører og objektmetoder
    
    public int getHogdeU() {
 		return hogdeU;
 	}

 	public void setHogdeU(int hogdeU) {
 		this.hogdeU = hogdeU;
 	}
 	
    public T getElement() {
    	return element;
    }

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public void setVenstre(BinaerTreNode<T> venstre) {
		this.venstre = venstre;
	}

	public BinaerTreNode<T> getHogre() {
		return hogre;
	}

	public void setHogre(BinaerTreNode<T> hogre) {
		this.hogre = hogre;
	}

	public void setElement(T element) {
		this.element = element;
	}
   
	public boolean harVenstreBarn() {
		return venstre != null;
	}
	
	public boolean harHogreBarn() {
		return hogre != null;
	}
	
	public boolean erLoev() {
		return (venstre == null) && (hogre == null);
	}
}