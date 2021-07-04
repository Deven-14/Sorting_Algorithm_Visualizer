package algorithm;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    public SelectionSort(T[] list)
    {
        super(list);
    }

    public void sort()
    {
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

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        SelectionSort<Integer> b = new SelectionSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}