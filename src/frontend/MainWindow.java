package frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Container;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class MainWindow extends JFrame{

    final int WIDTH = 1000;
    final int HEIGHT = WIDTH * 9 / 16;
    JMenuBar menuBar;
    JMenu aboutMenu;
    JMenu helpMenu;
    JMenu algorithmMenu;
    JMenuItem selectionSortItem;
    JMenuItem bubbleSortItem;
    JMenuItem quickSortItem;
    JMenuItem mergeSortItem;
    JPanel toolBarPanel;
    VisualizerPanel mainPanel;
    JPanel sidePanel;
    DataTypeComboBox dataTypeComboBox;
    AlgorithmComboBox algorithmComboBox;
    ArraySizeSlider arraySizeSlider;
    JLabel dataTypeLabel;
    JLabel algorithmLabel;
    JLabel sizeLabel;
    Container contentPane;

    public MainWindow (String title)//, Sync sync, Integer[] h) {
    {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(WIDTH, HEIGHT);
        //heights = h;
        
        menuBar = new JMenuBar();
        aboutMenu = new JMenu("About");
        helpMenu = new JMenu("Help");
        
        menuBar.add(aboutMenu);
        menuBar.add(helpMenu);
        // menuBar.add(Box.createHorizontalGlue());

        this.setJMenuBar(menuBar);
        
        toolBarPanel = new JPanel();
        toolBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        
        dataTypeLabel = new JLabel();
        dataTypeLabel.setText("Choose data type: ");
        toolBarPanel.add(dataTypeLabel);
        dataTypeComboBox = new DataTypeComboBox();
        toolBarPanel.add(dataTypeComboBox);
        
        algorithmLabel = new JLabel();
        algorithmLabel.setText("Choose Algorithm: ");
        toolBarPanel.add(algorithmLabel);
        algorithmComboBox = new AlgorithmComboBox();
        toolBarPanel.add(algorithmComboBox);

        sizeLabel = new JLabel();
        toolBarPanel.add(sizeLabel);
        arraySizeSlider = new ArraySizeSlider();
        arraySizeSlider.addChangeListener((e) -> {
            sizeLabel.setText("size = " + arraySizeSlider.getValue());
        });
        sizeLabel.setText("size = " + arraySizeSlider.getValue());
        toolBarPanel.add(arraySizeSlider);
        
        sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200, 200));
        sidePanel.setBackground(Color.white);
        
        mainPanel = new VisualizerPanel(dataTypeComboBox, algorithmComboBox, arraySizeSlider);
        // mainPanel.setPreferredSize(new Dimension(500, 500)); // 800, 800 * 9 / 16
        
        getContentPane().add(toolBarPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(sidePanel, BorderLayout.WEST);

        this.setVisible(true);
    }

}
