package websearch;

/**
 * Watches the search queries
 */
public class Snooper {

    public Snooper(WebSearchModel model) {
        model.addQueryObserver(query -> {
            if(query.contains("gallon")){
                System.out.println("[Gallon Found]: " + query);
            }else {
                System.out.println("[Long Query..]:" + query);
            }
        },
                texto -> texto.contains("gallon") || texto.length() >= 35);


    }
}
