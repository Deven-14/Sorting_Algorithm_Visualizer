package main;

import frontend.MainWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) 
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
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

        new MainWindow("Sorting Algorithm Visualizer");

    }
    
}

