package main;

import frontend.MainWindow;
import datastructure.Sync;

public class MainWindowThread implements Runnable{

    MainWindow mainWindow;
    Sync sync;
    Integer[] h;

    MainWindowThread(Sync sync, Integer[] h)
    {
        this.sync = sync;
        this.h = h;
    }

    @Override
    public void run() {

        mainWindow = new MainWindow("Sorting Algorithm Visualizer", sync, h);

    }

    /*public static void main(String[] args) {
        Sync s = new Sync();
        s.isCompleted = true;
        MainWindowThread t = new MainWindowThread(s);
    }*/
    
}
