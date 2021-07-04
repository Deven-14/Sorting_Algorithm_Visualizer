package algorithm;

public abstract class Sort<T> {
    
    protected T[] list;
    protected int size;

    protected Sort(T[] list)
    {
        this.list = list;
        this.size = list.length;
    }

    protected void swap(int index1, int index2)
    {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public abstract void sort();
}
