package algorithm;

import java.lang.Math;

class Pair
{
    int first;//default type
    int second;

    Pair() { first = second = -1; }

    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

public class QuickSort3<T extends Comparable<T>> {
    
    private T[] list;
    private int size;

    public QuickSort3(T[] list)
    {
        this.list = list;
        size = list.length;
    }

    private void swap(int index1, int index2)
    {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private int random(int left, int right)
    {
        return left + (int)Math.random() % (right - left + 1);
    }

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
            swap(left, right--);

            if(list[left].compareTo(list[pivot]) == 0)
                swap(++equalPivotIndex, left++);
            else
                ++left;
            
            while(list[right].compareTo(list[pivot]) > 0)
                --right;

            while(list[left].compareTo(list[pivot]) <= 0)
                ++left;
        }
        
        for(int i = pivot, j = 0; i <= equalPivotIndex; ++i, ++j)
            swap(i, right - j);

        return (new Pair(right - (equalPivotIndex - pivot), right));
    }

    private void sort(int left, int right)
    {
        while(left < right)
        {

            int randomIndex = random(left, right);
            swap(randomIndex, left);

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

    public void sort()
    {
        sort(0, size - 1);
    }

    public static void main(String[] args)
    {
        Integer[] a = {6, 6, 3, 1, 2, 5, 3, 2, 6, 9, 8, 0};
        QuickSort3<Integer> b = new QuickSort3<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}
