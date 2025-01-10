package uke3;

public class Heltall {
	
	private int tall;

	public Heltall(int n) {
		tall = n;
	}

	public void inkrementer() {
		tall++;
	}

	@Override
	public String toString() {
		return "" + tall;
	}
}
