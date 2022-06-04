package websearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a  file), notify the interested observers of each query.
 */
public class WebSearchModel {
    private final File sourceFile;
    private final List<QueryObserver> observers = new ArrayList<>();
    private PoliticaDeFiltragem politicaDeFiltragem ;

    public interface QueryObserver {
        void onQuery(String query);
    }

    public interface PoliticaDeFiltragem {
        boolean GoNotification(String texto);
    }

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }


    // 01 entry point of execution
    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                if(deveNotificar(line)){
                    notifyAllObservers(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addQueryObserver(QueryObserver queryObserver, PoliticaDeFiltragem pf) {
        observers.add(queryObserver);
        politicaDeFiltragem = pf;
    }
    private void notifyAllObservers(String line) {
        for (QueryObserver obs : observers) {
            obs.onQuery(line);
        }
    }

    private boolean deveNotificar(String texto){

        if(politicaDeFiltragem != null){
            return politicaDeFiltragem.GoNotification(texto);
        }
        return true;
    }
}
