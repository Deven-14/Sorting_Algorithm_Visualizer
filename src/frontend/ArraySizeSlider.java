package frontend;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class ArraySizeSlider extends JSlider{
    
    public static int SIZE = 15;

    public ArraySizeSlider(JLabel sizeLabel)
    {
        super(1, 20, 10);

        this.setPaintTicks(true);
        this.setMinorTickSpacing(5);
        
        this.setPaintTrack(true);
        this.setMajorTickSpacing(10);

        this.addChangeListener((e) -> {
            sizeLabel.setText("size = " + this.getValue());
            SIZE = this.getValue();
        });
        
    }
}
