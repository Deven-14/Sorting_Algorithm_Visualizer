package algorithm;

import datastructure.Sync;
import datastructure.Pair;

public class QuickSort3<T extends Comparable<T>> extends QuickSort<T>{
   
    public QuickSort3(Sync s) { super(s); }

    private Pair parition(int left, int right)
    {
        int pivot = left++;
        int equalPivotIndex = pivot;

        while(list[right].compareTo(list[pivot]) > 0)
            --right;

        while(left < right && list[left].compareTo(list[pivot]) <= 0)
            ++left;

        while(left < right)
        {
            sync.send(new Pair(left, right--), (indexPair) -> { swap(indexPair.first, indexPair.second); });

            //swap(left, right--);

            if(list[left].compareTo(list[pivot]) == 0)
            {
                sync.send(new Pair(++equalPivotIndex, left++), (indexPair) -> { swap(indexPair.first, indexPair.second); });
                //swap(++equalPivotIndex, left++);
            }
            else
                ++left;
            
            while(list[right].compareTo(list[pivot]) > 0)
                --right;

            while(list[left].compareTo(list[pivot]) <= 0)
                ++left;
        }
        
        for(int i = pivot, j = 0; i <= equalPivotIndex; ++i, ++j)
        {
            sync.send(new Pair(i, right - j), (indexPair) -> { swap(indexPair.first, indexPair.second); });
            //swap(i, right - j);
        }

        return (new Pair(right - (equalPivotIndex - pivot), right));
    }

    private void sort(int left, int right)
    {
        while(left < right)
        {

            //int randomIndex = random(left, right);
            //swap(randomIndex, left);

            Pair pivot = parition(left, right);

            if(pivot.first - left < right - pivot.second)
            {
                sort(left, pivot.first - 1);
                left = pivot.second + 1;
            }
            else
            {
                sort(pivot.second + 1, right);
                right = pivot.first - 1;
            }
        }
    }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;

        sort(0, size - 1);

        sync.isCompleted = true;
    }

}
