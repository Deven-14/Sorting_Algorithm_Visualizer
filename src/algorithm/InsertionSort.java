package algorithm;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    public InsertionSort() { }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;
        
        T key;
        int j;
        for(int i = 1; i < size; ++i)
        {
            j = i - 1;
            key = list[i];

            while(j >= 0 && key.compareTo(list[j]) < 0)
            {
                list[j + 1] = list[j];
                --j;
            }

            list[j + 1] = key;
        }
    }

}
