package algorithm;

public class HeapSort<T extends Comparable<T>> extends Sort<T>{

    public HeapSort() { }

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

    public void sort(T[] Array)
    {
        this.list = Array;
        this.size = list.length;

        createMaxHeap();
        maxDeletions();
    }

}
