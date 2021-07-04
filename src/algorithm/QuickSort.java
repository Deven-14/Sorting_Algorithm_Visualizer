package algorithm;

public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    
    public QuickSort() { }

    private int parition(int left, int right)
    {
        int pivot = left++;

        while(list[right].compareTo(list[pivot]) > 0)
            --right;

        while(left < right && list[left].compareTo(list[pivot]) <= 0)
            ++left;

        while(left < right)
        {
            swap(left++, right--);
            
            while(list[right].compareTo(list[pivot]) > 0)
                --right;

            while(list[left].compareTo(list[pivot]) <= 0)
                ++left;
        }
        
        swap(pivot, right);

        return right;
    }

    protected int random(int left, int right)
    {
        return left + (int)Math.random() % (right - left + 1);
    }

    private void sort(int left, int right)
    {
        while(left < right)
        {
            
            int randomIndex = random(left, right);
            swap(randomIndex, left);

            int pivot = parition(left, right);

            if(pivot - left < right - pivot)
            {
                sort(left, pivot - 1);
                left = pivot + 1;
            }
            else
            {
                sort(pivot + 1, right);
                right = pivot - 1;
            }
        }
    }

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;

        sort(0, size - 1);
    }

}
