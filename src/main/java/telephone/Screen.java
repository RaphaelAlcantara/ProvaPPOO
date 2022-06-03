package telephone;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {

    public Screen(PhoneModel model) {
        model.addListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("digits")) {
                    List<Integer> digits = (List<Integer>) evt.getNewValue();
                    if(digits.size() == 0) {
                        System.out.println("pressionado: " + digits.get(digits.size()-1));
                    }
                    else {
                        System.out.println("pressionado: " + digits.get(digits.size()-1));
                    }

                }
            }
        });

        model.listageral(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("digits")) {
                    List<Integer> digits = (List<Integer>) evt.getNewValue();
                    //tirar o 10
                    if(digits.size() == 10 ) {
                        String lista = "";
                        for(int i = 0; i < digits.size(); i++) {
                            lista += digits.get(i);
                            lista += "";
                        }
                        System.out.println("Ligando para:" + lista + "...");
                    }
                }
            }
        });





    }
}
