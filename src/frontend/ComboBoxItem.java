package frontend;

public class ComboBoxItem {
    String label;
    int value;
    
    ComboBoxItem () {
        this.label = "NULL";
        this.value = 0;
    }
    ComboBoxItem (String label, int value) {
        this.label = label;
        this.value = value;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return label;
    }
}
