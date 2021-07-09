package frontend;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import datastructure.Sync;

public class MainWindow extends JFrame implements ActionListener {
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
   JComboBox dataTypeSelection;
   JComboBox algoSelection;
   JComboBox rangeSelection;
   JLabel dataLabel;
   JLabel algoLabel;
   JLabel rangeLabel;
   Container contentPane;

   Integer[] heights;
   

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
      
      dataLabel = new JLabel();
      dataLabel.setText("Choose data type: ");
      toolBarPanel.add(dataLabel);
            
      String [] dataType = {"Char", "Integer", "Double", "Float"};
      dataTypeSelection = new JComboBox(dataType);
      dataTypeSelection.setBackground(new Color(0xffffff));
      toolBarPanel.add(dataTypeSelection);
      
      algoLabel = new JLabel();
      algoLabel.setText("Choose Algorithm: ");
      toolBarPanel.add(algoLabel);
      
      String [] sortingAlgos = {"Selection sort","Bubble sort", "Merge sort", "Quick sort"};
      algoSelection = new JComboBox(sortingAlgos);
      algoSelection.setBackground(new Color(0xffffff));
      toolBarPanel.add(algoSelection);
      
      rangeLabel = new JLabel();
      rangeLabel.setText("Choose range: ");
      toolBarPanel.add(rangeLabel);
      
      ComboBoxItem [] ranges = {new ComboBoxItem("1-10", 10),
          new ComboBoxItem("1-100", 100),
          new ComboBoxItem("1-1000", 1000), 
          new ComboBoxItem("1-10000", 10000)};
      rangeSelection = new JComboBox(ranges);
      rangeSelection.setBackground(new Color(0xffffff));
      toolBarPanel.add(rangeSelection);
      
      rangeSelection.addActionListener(this);
      
      sidePanel = new JPanel();
      sidePanel.setPreferredSize(new Dimension(200, 200));
      sidePanel.setBackground(Color.white);
      
      Integer[] heights = {40, 70, 90, 20, 10, 60, 5};
      //mainPanel = new BubbleSortVisualizer(heights);
      mainPanel = new VisualizerPanel(heights);//, sync);
      // mainPanel.setPreferredSize(new Dimension(500, 500)); // 800, 800 * 9 / 16
      
      getContentPane().add(toolBarPanel, BorderLayout.NORTH);
      getContentPane().add(mainPanel, BorderLayout.CENTER);
      getContentPane().add(sidePanel, BorderLayout.WEST);

      this.setVisible(true);
   }
   
   @Override
   public void actionPerformed (ActionEvent e) {
       // System.out.println(((ComboItem)rangeSelection.getSelectedItem()).getValue());
       //mainPanel.maxBarHeight = ((ComboBoxItem)rangeSelection.getSelectedItem()).getValue();
       //repaint();
   }
}
