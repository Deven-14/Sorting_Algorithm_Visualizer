package algorithm;

import datastructure.Sync;
import datastructure.Pair;

public class MergeSort<T extends Comparable<T>> extends Sort<T>{
    
    public MergeSort(Sync s) { super(s); }

    @SuppressWarnings("unchecked")
    private void merge(int left, int mid, int right)
    {
        Object[] tempList = new Object[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right)
        {

            while(i <= mid && list[i].compareTo(list[j]) <= 0)
                tempList[k++] = list[i++];
            
            while(j <= right && list[j].compareTo(list[i]) <= 0)
            {
                int tempk = k;
                int tempj = j;
                sync.send(new Pair(left + k, j), (indexPair) -> { tempList[tempk] = list[tempj]; });
                k++;
                j++;
            }

                //tempList[k++] = list[j++];

        }

        if(i > mid)
        {
            while(j <= right)
                tempList[k++] = list[j++];
        }
        else
        {
            while(i <= mid)
                tempList[k++] = list[i++];
        }

        for(int l = left, m = 0; l <= right; ++l, ++m)
            list[l] = (T)tempList[m];

    }

    private void sort(int left, int right)
    {
        if(left >= right)
            return;

        int mid = (right - left) / 2 + left;

        sort(left, mid);
        sort(mid+1, right);

        merge(left, mid, right);
    }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;

        sort(0, size - 1);

        sync.isCompleted = true;
    }

}
