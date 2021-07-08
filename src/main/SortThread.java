package main;

import algorithm.Sort;
import algorithm.BubbleSort;
import datastructure.Sync;

public class SortThread<T> implements Runnable{

    Sort<T> sortAlgorithm;
    T[] list;

    SortThread(Sort<T> s, T[] list)
    {
        sortAlgorithm = s;
        this.list = list;
    }

    @Override
    public void run() {
        
        sortAlgorithm.sort(list);

    }

    /*public static void main(String[] args)
    {
        Integer[] arr = {5, 2, 6, 3, 6};
        Sync s = null;
        SortThread<Integer> st = new SortThread<Integer>(new BubbleSort<Integer>(s), arr);
        Thread t1 = new Thread(st, "1");
        t1.start();

        try{
            t1.join();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        
        for(int a : arr)
            System.out.print(a + ", ");
        System.out.println();
    }*/
    
}
