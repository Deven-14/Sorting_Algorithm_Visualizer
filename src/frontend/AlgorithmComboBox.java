package frontend;

import java.awt.Color;

import javax.swing.JComboBox;

public class AlgorithmComboBox extends JComboBox<String> {
    
    private static String[] sortingAlgorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Heap Sort", "Quick Sort", "Quick Sort 3"};
    public static final int BUBBLE_SORT = 0;
    public static final int SELECTION_SORT = 1;
    public static final int INSERTION_SORT = 2;
    public static final int MERGE_SORT = 3;
    public static final int HEAP_SORT = 4;
    public static final int QUICK_SORT = 5;
    public static final int QUICK_SORT_3 = 6;
    public static int SELECTED_SORT = 0;
    
    public AlgorithmComboBox()
    {
        super(sortingAlgorithms);

        this.setBackground(new Color(0xffffff));
        this.addActionListener( e -> { SELECTED_SORT = this.getSelectedIndex(); } );

    }

}
