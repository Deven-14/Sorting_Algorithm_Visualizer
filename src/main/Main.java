package main;

import frontend.MainWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    // public static void main(String[] args)
    // {
    //     Sync sync = new Sync();
    //     Integer[] heights = {40, 70, 90, 20, 10, 60, 5};

    //     Sort<Integer> algo = new BubbleSort<Integer>(sync);
    //     SortThread<Integer> st = new SortThread<>(algo, heights);

    //     MainWindowThread mt = new MainWindowThread(sync, heights);

    //     Thread t1 = new Thread(st);
    //     Thread t2 = new Thread(mt);
        
    //     t2.start();
    //     t1.start();

    //     try{
    //         t1.join();
    //         t2.join();
    //     }catch(InterruptedException e)
    //     {
    //         System.out.println(e);
    //     }

    //     for(Integer a : heights)
    //         System.out.print(a + " ");
    //     System.out.println();

    // }

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

