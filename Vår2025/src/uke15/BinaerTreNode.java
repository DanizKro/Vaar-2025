package uke15;

public class BinaerTreNode<T>{
    private T element;    
    private BinaerTreNode<T> venstre;
    private BinaerTreNode<T>  hogre;
    
    BinaerTreNode (T el) {
    	element = el;
    	venstre = null;
    	hogre   = null;
    }
    
    // Flere konstruktører og objektmetoder
    
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