package algorithm;

import datastructure.Sync;

public abstract class Sort<T> {
    
    protected T[] list;
    protected int size;

    protected Sync sync;

    protected Sort() 
    {
        list = null;
        size = 0;
        sync = null;
    }

    protected Sort(Sync s)
    {
        this();
        sync = s;
    }

    protected void swap(int index1, int index2)
    {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public abstract void sort(T[] Array);
}
