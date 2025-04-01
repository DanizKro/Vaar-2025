package Uke13;

import java.util.LinkedList;

public class BilskiltHashTable {
    private static final int TABLE_SIZE = 10;
    private String[] table;

    public BilskiltHashTable() {
        table = new String[TABLE_SIZE];
    }

    // Hash-funksjon som returnerer siste siffer i bilnummeret
    private int hash(String bilskilt) {
        bilskilt = bilskilt.trim().toUpperCase();
        
        // Finner det siste sifferet
        for (int i = bilskilt.length() - 1; i >= 0; i--) {
            char c = bilskilt.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c) % TABLE_SIZE;
            }
        }
        return 0;
    }

    // Linear probing
    public void insert(String bilskilt) {
        int index = hash(bilskilt);
        int originalIndex = index;
        
        while (table[index] != null) {
            index = (index + 1) % TABLE_SIZE; // Linear probing
            if (index == originalIndex) {
                System.out.println("Tabellen er full, kan ikke sette inn " + bilskilt);
                return;
            }
        }
        
        table[index] = bilskilt;
    }

    public void displayTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("Index " + i + ": " + (table[i] != null ? table[i] : "tom"));
        }
    }
}