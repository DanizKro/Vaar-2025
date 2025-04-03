package Uke13;

public class BilskiltHashTable {

	private static final int TABLE_SIZE = 10;
	private String[] table;
	private int storrelse;

	public BilskiltHashTable() {
		table = new String[TABLE_SIZE];
	}
	public BilskiltHashTable(int storrelse) {
		table = new String[storrelse];
		this.storrelse = storrelse;
	}

	public int hash(String bilskilt) {

		char lastChar = bilskilt.trim().toUpperCase().charAt(bilskilt.length() - 1);

		if (Character.isDigit(lastChar)) {
			return Character.getNumericValue(lastChar) % TABLE_SIZE;
		}

		return -1;
	}

	public static int hash2(String bilskilt) {

		int hash = -1;

		hash = Math.abs(bilskilt.hashCode() % 10);

		return hash;
	}

	// Linear probing
	public void add(String bilskilt) {

		int pos = hash(bilskilt);
		int teller = pos;

		while (table[pos] != null) {
			pos = (pos + 1) % TABLE_SIZE; // Linear probing
			if (pos == teller) {
				System.out.println("Tabellen er full, kan ikke sette inn " + bilskilt);
				return;
			}
		}
		table[pos] = bilskilt;
	}

	public void add2(String bilskilt) {

		int pos = Math.abs(hash2(bilskilt));
		int teller = pos;

		while (table[pos] != null) {
			pos = (pos + 1) % storrelse; // Linear probing
			if (pos == teller) {
				System.out.println("Tabellen er full, kan ikke sette inn " + bilskilt);
				return;
			}
		}
		table[pos] = bilskilt;
	}

	public void skrivUt() {
		for (int i = 0; i < TABLE_SIZE; i++) {

			if (table[i] != null) {
				System.out.println("Index " + i + ": " + table[i]);
			} else {
				System.out.println("Index " + i + ": " + "Null");
			}
		}
	}
	public void skrivUt2() {
		for (int i = 0; i < storrelse; i++) {

			if (table[i] != null) {
				System.out.println("Index " + i + ": " + table[i] + " --> HashCode: " + Math.abs(table[i].hashCode())%10);
			} else {
				System.out.println("Index " + i + ": " + "Null");
			}
		}
	}

}