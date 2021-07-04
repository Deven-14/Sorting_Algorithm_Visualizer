package algorithm;

public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    
    public QuickSort(T[] list)
    {
        super(list);
    }

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

    public void sort()
    {
        sort(0, size - 1);
    }

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        QuickSort<Integer> b = new QuickSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}
