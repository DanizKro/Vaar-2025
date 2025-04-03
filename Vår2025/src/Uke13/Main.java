package Uke13;

public class Main {

	public static void main(String[] args) {

		String[] skilt = { "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944" };

		BilskiltHashTable hashTable = new BilskiltHashTable();

		System.out.println("Bruk av Linjær probing:");
		hashTable.add(skilt[0]);
		hashTable.add(skilt[1]);
		hashTable.add(skilt[2]);
		hashTable.add(skilt[3]);
		hashTable.add(skilt[4]);
		hashTable.add(skilt[5]);
		hashTable.add(skilt[6]);

		hashTable.skrivUt();
		
		System.out.println();

		System.out.println("Bruk av LinkedList:");
		SkiltLinkedList tabell = new SkiltLinkedList();

		tabell.leggTil("EL65431");
		tabell.leggTil("TA14374");
		tabell.leggTil("ZX87181");
		tabell.leggTil("EL47007");
		tabell.leggTil("VV50000");
		tabell.leggTil("UV14544");
		tabell.leggTil("EL32944");

		tabell.skrivUtTabell();
		System.out.println();
		
		System.out.println();
		
		String[] skilt2 = { "EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944" };

		BilskiltHashTable hashTable2 = new BilskiltHashTable(20);

		System.out.println("Med ny generert hash kode (String.hashCode() % 10) metode");
		hashTable2.add2(skilt2[0]);
		hashTable2.add2(skilt2[1]);
		hashTable2.add2(skilt2[2]);
		hashTable2.add2(skilt2[3]);
		hashTable2.add2(skilt2[4]);
		hashTable2.add2(skilt2[5]);
		hashTable2.add2(skilt2[6]);
		hashTable2.skrivUt2();
		
		System.out.println();

//		System.out.println("Bruk av LinkedList med ny hashCode:");
//		SkiltLinkedList tabell2 = new SkiltLinkedList();
//		tabell2.leggTil2("EL65431");
//		tabell2.leggTil2("TA14374");
//		tabell2.leggTil2("ZX87181");
//		tabell2.leggTil2("EL47007");
//		tabell2.leggTil2("VV50000");
//		tabell2.leggTil2("UV14544");
//		tabell2.leggTil2("EL32944");
//		tabell2.skrivUtTabell();
//		System.out.println();
		

		
	}
	
	 

}
