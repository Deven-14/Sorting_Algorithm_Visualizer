package algorithm;

public class BubbleSort<T extends Comparable<T>> extends Sort<T>
{
    public BubbleSort(T[] list)
    {
        super(list);
    }

    public void sort()
    {
        for(int i = 0; i < size - 1; ++i)
        {
            for(int j = 0; j < size - 1 - i; ++j)
            {
                if(list[j].compareTo(list[j+1]) > 0)
                {
                    //swap(list[j], list[j+1]); not possible as Integer, String etc are immutable objects, but if T was of user defined type like student then this would work
                    swap(j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        BubbleSort<Integer> b = new BubbleSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}