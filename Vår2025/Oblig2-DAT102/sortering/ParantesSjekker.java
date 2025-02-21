package sortering;

public class ParantesSjekker {
	
	private static final char[] START_PARENTESER = { '(', '[', '{' };
    private static final char[] SLUTT_PARENTESER = { ')', ']', '}' };

	public boolean sjekkParenteser(String s) {
		
		//Lager en stack av typen fra LenketStabel klassen
		StabelADT<Character> stabel = new LenketStabel<>();

		//Lager en array av hvert enkelt tegn hver for seg
        char[] tegnArray = s.toCharArray();
        
        for (int i = 0; i < tegnArray.length; i++) {
            char tegn = tegnArray[i];

            if (erStartParentes(tegn)) {
                stabel.push(tegn);
                
         // Hvis erParentesPar er true, altså den tar å sammenligner "tegn" med øverste node i stacken
         // samtidig som den fjerner den, så går den bare videre. Er den false, er 
         // stacken ikke korrekt i forhold til parenteser
            } else if (erSluttParentes(tegn)) {
                if (stabel.isEmpty() || !erParentesPar(stabel.pop(), tegn)) {
                    return false;
                }
            }
        }

        return stabel.isEmpty();
    }
	
	public boolean erStartParentes(char c) {
		
		for(int i = 0; i < START_PARENTESER.length; i++) {
			if(c == START_PARENTESER[i]) {
				return true;
			} 
		}
		
		return false;
	}
	
	
	public boolean erSluttParentes(char c) {
		
		for(int i = 0; i< SLUTT_PARENTESER.length; i++) {
			if(SLUTT_PARENTESER[i] == c) {
				return true;
			}
		} return false;
	}
	
	public boolean erParentesPar(char start, char slutt) {
		
		for (int i = 0; i < START_PARENTESER.length; i++) {
            if (START_PARENTESER[i] == start && SLUTT_PARENTESER[i] == slutt) {
                return true;
            }
        }
        return false;
    }
}
