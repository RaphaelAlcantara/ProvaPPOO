package telephone;
import java.util.List;

/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {

    public Screen(PhoneModel model) {
        addFirstObserver(model);
        addSecondObserver(model);
    }

    private void addFirstObserver(PhoneModel model) {
        model.addListener(evt -> {
            int lastDigit = (Integer) evt.getOldValue();

            System.out.println("inserting: " + lastDigit);

        });
    }
    private void addSecondObserver(PhoneModel model) {
        model.addListener(evt -> {
            List<Integer> all = (List<Integer>) evt.getNewValue();

            if(all.size() >  model.getMaxLength() - 1){

                StringBuilder text = new StringBuilder();
                for (Integer i :all) {
                    text.append(i);
                }

                System.out.println("Calling for: " + text + "...");
            }
        });
    }


}
