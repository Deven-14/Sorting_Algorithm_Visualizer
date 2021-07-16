package backend;

import algorithm.Sort;

public class SortThread<T extends Comparable<T>> implements Runnable{

    Sort<T> sortAlgorithm;
    T[] list;

    public SortThread(Sort<T> s, T[] list)
    {
        sortAlgorithm = s;
        this.list = list;
    }

    @Override
    public void run() {
        
        sortAlgorithm.sort(list);

    }
    
}
