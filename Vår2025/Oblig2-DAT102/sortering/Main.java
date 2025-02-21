package sortering;

public class Main {
	
	public static void main(String[]args) {
		
//		Node<String> forste = new Node("hei");
//		
//		Node<String> s1 = new Node("på", forste);
//		
//		System.out.print(forste.data);
		
		
		ParantesSjekker sjekker = new ParantesSjekker();

        String korrekt = "{ [ ( ) ] }";
        String feil1 = "{ [ ( ) }";
        String feil2 = "[ ( ) ] }";
        String feil3 = "{ [ ( ] ) }";
        String javaprogram = """
                class HelloWorld {
                  public static void main(String[] args) {
                    System.out.println("Hello World!");
                  }
                }
                """;
        
        //Her kan man se hvordan .toCharArray() metoden fungerer:
        
//        char[] tegnArray = javaprogram.toCharArray();
//        for(char e : tegnArray) {
//        	System.out.print(e + "-");
//        }

        System.out.println(korrekt + " " + sjekker.sjekkParenteser(korrekt)); 
        System.out.println(feil1 + " " + sjekker.sjekkParenteser(feil1)); 
        System.out.println(feil2 + " " + sjekker.sjekkParenteser(feil2)); 
        System.out.println(feil3 + " " + sjekker.sjekkParenteser(feil3)); 
        System.out.println(javaprogram + " " + sjekker.sjekkParenteser(javaprogram)); 
    }
	
}
