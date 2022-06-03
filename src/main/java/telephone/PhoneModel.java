package telephone;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private List<Integer> digits = new ArrayList<>();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public PhoneModel() {

    }

    public void addListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void listageral(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
        pcs.toString();


    }



    public void addDigit(int newDigit) {
        digits.add(newDigit);
        pcs.firePropertyChange("digits",null, digits);
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public void setDigits(List<Integer> digits) {
        this.digits = digits;
    }






}
