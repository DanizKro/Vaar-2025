package Uke13;

import java.util.HashSet;
import java.util.Hashtable;

public class main {

	public static void main(String[] args) {

		String[] skilt = { "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944" };

		BilskiltHashTable hashTable = new BilskiltHashTable();

		hashTable.insert(skilt[0]);
		hashTable.insert(skilt[1]);
		hashTable.insert(skilt[2]);
		hashTable.insert(skilt[3]);
		hashTable.insert(skilt[4]);
		hashTable.insert(skilt[5]);
		hashTable.insert(skilt[6]);

		hashTable.displayTable();
	}

}
