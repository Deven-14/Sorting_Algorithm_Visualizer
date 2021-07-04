package algorithm;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    public SelectionSort() { }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;
        
        int minIndex;

        for(int i = 0; i < size - 1; ++i)
        {
            minIndex = i;

            for(int j = i + 1; j < size; ++j)
            {
                if(list[j].compareTo(list[minIndex]) < 0)
                    minIndex = j;
            }

            if(minIndex != i)
                swap(i, minIndex);
        }
    }

}