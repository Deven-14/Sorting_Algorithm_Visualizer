package frontend;

import javax.swing.JSlider;

public class ArraySizeSlider extends JSlider{

    public ArraySizeSlider()
    {
        super(1, 20, 10);

        this.setPaintTicks(true);
        this.setMinorTickSpacing(5);
        
        this.setPaintTrack(true);
        this.setMajorTickSpacing(10);
        
    }
}
