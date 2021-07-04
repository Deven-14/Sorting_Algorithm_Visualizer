package algorithm;

public class BubbleSort<T extends Comparable<T>> extends Sort<T>
{
    public BubbleSort() { }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;

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
    
}