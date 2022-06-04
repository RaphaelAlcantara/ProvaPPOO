package websearch;

/**
 * Watches the search queries
 */
public class Snooper {

    public Snooper(WebSearchModel model) {
        model.addQueryObserver(query -> System.out.println("[Gallon Found]: " + query), texto -> texto.contains("gallon"));

        model.addQueryObserver(query -> System.out.println("[Long Query..]: " + query), texto -> texto.length() > 35);
    }
}



