package algorithm;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    public InsertionSort(T[] list)
    {
        super(list);
    }

    public void sort()
    {
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

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        InsertionSort<Integer> b = new InsertionSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}
