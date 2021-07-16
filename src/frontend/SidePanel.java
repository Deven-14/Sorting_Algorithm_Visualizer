package frontend;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SidePanel extends JPanel{
 
    String[] timeComplexities;
    JLabel[] label;
    JLabel algorithmName;

    void stateChange(int selectedAlgorithmIndex)
    {
        switch(selectedAlgorithmIndex)
        {
            case AlgorithmComboBox.BUBBLE_SORT:
                algorithmName.setText("Bubble Sort");
                label[0].setText("Best Case: O(n\u00B2)");
                label[1].setText("Avg Case: O(n\u00B2)");
                label[2].setText("Worst Case: O(n\u00B2)");
                break;
            case AlgorithmComboBox.SELECTION_SORT:
                algorithmName.setText("SelectionSort");
                label[0].setText("Best Case: O(n\u00B2)");
                label[1].setText("Avg Case: O(n\u00B2)");
                label[2].setText("Worst Case: O(n\u00B2)");
                break;
            case AlgorithmComboBox.INSERTION_SORT:
                algorithmName.setText("Insertion Sort");
                label[0].setText("Best Case: O(n)");
                label[1].setText("Avg Case: O(n\u00B2)");
                label[2].setText("Worst Case: O(n\u00B2)");
                break;
            case AlgorithmComboBox.MERGE_SORT:
                algorithmName.setText("Merge Sort");
                label[0].setText("Best Case: O(nlogn)");
                label[1].setText("Avg Case: O(nlogn)");
                label[2].setText("Worst Case: O(nlogn)");
                break;
            case AlgorithmComboBox.HEAP_SORT:
                algorithmName.setText("Heap Sort");
                label[0].setText("Best Case: O(nlogn)");
                label[1].setText("Avg Case: O(nlogn)");
                label[2].setText("Worst Case: O(nlogn)");
                break;
            case AlgorithmComboBox.QUICK_SORT:
                algorithmName.setText("Quick Sort");
                label[0].setText("Best Case: O(nlogn)");
                label[1].setText("Avg Case: O(nlogn)");
                label[2].setText("Worst Case: O(n\u00B2)");
                break;
            case AlgorithmComboBox.QUICK_SORT_3:
                algorithmName.setText("Quick Sort 3");
                label[0].setText("Best Case: O(n)");
                label[1].setText("Avg Case: O(nlogn)");
                label[2].setText("Worst Case: O(n\u00B2)");
                break;
        }
    }


    public SidePanel()
    {
        this.setPreferredSize(new Dimension(200, 200));
        
        label = new JLabel[3];
        algorithmName = new JLabel();
        algorithmName.setBounds(10, 10, 160, 40);
        algorithmName.setFont(new Font(null, Font.BOLD, 25));

        label[0] = new JLabel();
        label[1] = new JLabel();
        label[2] = new JLabel();
        stateChange(AlgorithmComboBox.BUBBLE_SORT);

        label[0].setBounds(10, 220, 160, 40);
        label[0].setFont(new Font(null, Font.PLAIN, 16));

        label[1].setBounds(10, 300, 160, 40);
        label[1].setFont(new Font(null, Font.PLAIN, 16));

        label[2].setBounds(10, 380, 160, 40);
        label[2].setFont(new Font(null, Font.PLAIN, 16));


        this.add(algorithmName);
        this.add(label[0]);
        this.add(label[1]);
        this.add(label[2]);

        this.setLayout(null);
        this.setBackground(Color.white);
    }
    
}
