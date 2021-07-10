package main;

import frontend.MainWindow;

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
        MainWindow mainWindow = new MainWindow("Sorting Algorithm Visualizer");

    }
    
}
