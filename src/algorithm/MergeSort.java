package algorithm;

public class MergeSort<T extends Comparable<T>> {
        
    private T[] list;
    private int size;

    public MergeSort(T[] list)
    {
        this.list = list;
        size = list.length;
    }

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
                tempList[k++] = list[j++];

        }

        if(i > mid)
            while(j <= right)
                tempList[k++] = list[j++];
        else
            while(i <= mid)
            tempList[k++] = list[i++];
        
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

    public void sort()
    {
        sort(0, size - 1);
    }

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        MergeSort<Integer> b = new MergeSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}
