package uke3;

public class Rektangel implements Figur {

	private double hoyde;
	private double bredde;

	Rektangel(double hoyde, double bredde) {
		this.hoyde = hoyde;
		this.bredde = bredde;
	}

	@Override
	public double areal() {
		return hoyde * bredde;
	} 
	@Override
	public String navn() {
		return "Rektangel:";
	}

	@Override
	public void tegn() {
		for (int i = 0; i < hoyde; i++) {
			for (int j = 0; j < bredde; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Rektangel rektangel1 = new Rektangel(2, 2);
		System.out.print(rektangel1.areal());
	}
}
