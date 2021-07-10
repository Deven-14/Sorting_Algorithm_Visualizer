package backend;

import algorithm.BubbleSort;
import algorithm.HeapSort;
import algorithm.InsertionSort;
import algorithm.MergeSort;
import algorithm.QuickSort;
import algorithm.QuickSort3;
import algorithm.SelectionSort;
import datastructure.Sync;

import frontend.AlgorithmComboBox;

public class GetSortThread<T extends Comparable<T>> {

    SortThread<T> st;
    Sync sync;
    T[] list;

    GetSortThread(T[] list, Sync sync)
    {
        this.sync = sync;
        this.list = list;
    }

    public SortThread<T> get()
    {
        switch(AlgorithmComboBox.SELECTED_SORT)
        {
            case AlgorithmComboBox.BUBBLE_SORT:
                st = new SortThread<T>(new BubbleSort<T>(sync), list);
                break;
            case AlgorithmComboBox.SELECTION_SORT:
                st = new SortThread<T>(new SelectionSort<T>(sync), list);
                break;
            case AlgorithmComboBox.INSERTION_SORT:
                st = new SortThread<T>(new InsertionSort<T>(sync), list);
                break;
            case AlgorithmComboBox.MERGE_SORT:
                st = new SortThread<T>(new MergeSort<T>(sync), list);
                break;
            case AlgorithmComboBox.HEAP_SORT:
                st = new SortThread<T>(new HeapSort<T>(sync), list);
                break;
            case AlgorithmComboBox.QUICK_SORT:
                st = new SortThread<T>(new QuickSort<T>(sync), list);
                break;
            case AlgorithmComboBox.QUICK_SORT_3:
                st = new SortThread<T>(new QuickSort3<T>(sync), list);
                break;
            default:
                st = new SortThread<T>(new BubbleSort<T>(sync), list);
        }
        return st;
    }
    
}
