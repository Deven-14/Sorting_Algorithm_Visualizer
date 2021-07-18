package frontend;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainWindow extends JFrame{

    final int WIDTH = 1000;
    final int HEIGHT = WIDTH * 9 / 16;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu helpMenu;
    JMenu algorithmMenu;
    JMenuItem newWindow;
    JMenuItem about;
    JMenuItem selectionSortItem;
    JMenuItem bubbleSortItem;
    JMenuItem quickSortItem;
    JMenuItem mergeSortItem;
    JPanel toolBarPanel;
    VisualizerPanel mainPanel;
    SidePanel sidePanel;
    DataTypeComboBox dataTypeComboBox;
    AlgorithmComboBox algorithmComboBox;
    ArraySizeSlider arraySizeSlider;
    JLabel dataTypeLabel;
    JLabel algorithmLabel;
    JLabel sizeLabel;
    Container contentPane;

    JPanel aboutPanel;
    JTextArea aboutLabel;
    JButton returnToMainPanel;

    public MainWindow (String title)
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (InstantiationException e) {
            System.err.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(WIDTH, HEIGHT);
        
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newWindow = new JMenuItem("New Window");
        newWindow.addActionListener( e -> {
            new MainWindow("Sorting Algorithm Visualizer");
        });

        fileMenu.add(newWindow);

        helpMenu = new JMenu("Help");
        about = new JMenuItem("About");
        about.addActionListener(e -> {

            mainPanel.setVisible(false);

            aboutPanel = new JPanel();
            aboutPanel.setLayout(new FlowLayout());     
            
            returnToMainPanel = new JButton("Close");
            returnToMainPanel.addActionListener( e1 -> {
                aboutPanel.setVisible(false);
                mainPanel.setVisible(true);
            });

            String description = "A tool with a graphical user interface to visualize the working of various popular sorting algorithms like \nBubble sort, Selection sort, Insertion sort, Merge sort, Heap sort, Quick sort and 3 way Quick sort \nwith the user being able to choose the input size, input data type and sorting algorithm.";
            aboutLabel = new JTextArea(description);
            aboutLabel.setFont(new Font(null, Font.PLAIN, 17));
            aboutLabel.setEditable(false);

            getContentPane().add(aboutPanel, BorderLayout.CENTER);

            aboutPanel.add(aboutLabel);
            aboutPanel.add(returnToMainPanel);

            aboutPanel.setVisible(true);
        });

        helpMenu.add(about);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

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
        algorithmComboBox.addActionListener( (e) -> {
            sidePanel.stateChange(algorithmComboBox.getSelectedIndex());
        });

        sizeLabel = new JLabel();
        toolBarPanel.add(sizeLabel);
        arraySizeSlider = new ArraySizeSlider();
        arraySizeSlider.addChangeListener((e) -> {
            sizeLabel.setText("size = " + arraySizeSlider.getValue());
        });
        sizeLabel.setText("size = " + arraySizeSlider.getValue());
        toolBarPanel.add(arraySizeSlider);
        
        sidePanel = new SidePanel();
        mainPanel = new VisualizerPanel(dataTypeComboBox, algorithmComboBox, arraySizeSlider);
        
        getContentPane().add(toolBarPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(sidePanel, BorderLayout.WEST);

        this.setVisible(true);
    }

}
