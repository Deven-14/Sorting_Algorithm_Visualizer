package algorithm;

public class HeapSort<T extends Comparable<T>> {
        
    private T[] list;
    private int size;

    public HeapSort(T[] list)
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

    private void heapify(int nNodes, int parentIndex)
    {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = leftChildIndex + 1;
        
        while(leftChildIndex < nNodes)
        {
            int greatestChildIndex = leftChildIndex;

            if(rightChildIndex < nNodes && list[rightChildIndex].compareTo(list[greatestChildIndex]) > 0)
                greatestChildIndex = rightChildIndex;
            
            if(list[parentIndex].compareTo(list[greatestChildIndex]) > 0)
                return;
            
            swap(parentIndex, greatestChildIndex);
            
            parentIndex = greatestChildIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = leftChildIndex + 1;
        }
    }

    private void createMaxHeap()
    {
        for(int i = size / 2 - 1; i >= 0; --i)
            heapify(size, i);
    }

    private void maxDeletions()
    {
        for(int i = size - 1; i >= 0; --i)
        {
            swap(0, i);
            heapify(i, 0);
        }
    }

    public void sort()
    {
        createMaxHeap();
        maxDeletions();
    }

    public static void main(String[] args)
    {
        Integer[] a = {5, 6, 3, 1, 2, 6};
        HeapSort<Integer> b = new HeapSort<Integer>(a);
        b.sort();
        for(Integer x : a)
            System.out.print(x + ", ");
        System.out.println();
    }
}
