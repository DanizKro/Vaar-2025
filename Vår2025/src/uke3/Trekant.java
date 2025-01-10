package uke3;

public class Trekant implements Figur{
	
	private int sideLengde;
	
	Trekant(int sideLengde){
		this.sideLengde = sideLengde;
		
		
	} 

	@Override
	public double areal() {
		return (sideLengde * sideLengde)/2;
	}
	 
	@Override
	public String navn() {
		return "Trekant:";
	}
	
	@Override
	public void tegn() {
		for(int i = 0; i < sideLengde; i ++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			} System.out.println("*");
		}
	}
	public static void main(String[] args) {
		Trekant t1 = new Trekant(3);
		t1.areal();
	}
}
