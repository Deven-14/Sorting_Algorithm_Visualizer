package backend;

import frontend.DataTypeComboBox;
import frontend.ArraySizeSlider;
import input.*;
import datastructure.Sync;

public class GetRequiredData {

    public Integer[] barHeights;
    public Sync sync;

    public GetRequiredData()
    {
        barHeights = null;
        sync = new Sync();
    }

    public Integer[] getBarHeigths()
    {
        return barHeights;
    }

    public Sync getSync()
    {
        return sync;
    }

    public Thread getSortThread()
    {
        Thread t;

        switch(DataTypeComboBox.SELECTED_TYPE)
        {
            case DataTypeComboBox.INTEGER_TYPE:
            {
                Integer[] list = new Integer[ArraySizeSlider.SIZE];
                RandomArray<Integer> randomArray = new RandomArray<>(new RandomInteger());
                randomArray.generateRandomArray(list);
                // for(Integer a : list)
                //     System.out.print(a + ", ");
                // System.out.println();
                GetBarHeights<Integer> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Integer> getSortThread = new GetSortThread<Integer>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.CHARACTER_TYPE:
            {
                Character[] list = new Character[ArraySizeSlider.SIZE];
                RandomArray<Character> randomArray = new RandomArray<>(new RandomCharacter());
                randomArray.generateRandomArray(list);
                GetBarHeights<Character> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Character> getSortThread = new GetSortThread<Character>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.FLOAT_TYPE:
            {
                Float[] list = new Float[ArraySizeSlider.SIZE];
                RandomArray<Float> randomArray = new RandomArray<>(new RandomFloat());
                randomArray.generateRandomArray(list);
                GetBarHeights<Float> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Float> getSortThread = new GetSortThread<Float>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.DOUBLE_TYPE:
            {
                Double[] list = new Double[ArraySizeSlider.SIZE];
                RandomArray<Double> randomArray = new RandomArray<>(new RandomDouble());
                randomArray.generateRandomArray(list);
                GetBarHeights<Double> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Double> getSortThread = new GetSortThread<Double>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.STRING_TYPE:
            {
                String[] list = new String[ArraySizeSlider.SIZE];
                RandomArray<String> randomArray = new RandomArray<>(new RandomString());
                randomArray.generateRandomArray(list);
                GetBarHeights<String> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<String> getSortThread = new GetSortThread<String>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            default:
            {
                Integer[] list = new Integer[ArraySizeSlider.SIZE];
                RandomArray<Integer> randomArray = new RandomArray<>(new RandomInteger());
                randomArray.generateRandomArray(list);
                GetBarHeights<Integer> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Integer> getSortThread = new GetSortThread<Integer>(list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

        }

        return t;
    }

    // public static void main(String[] args)
    // {
    //     GetRequiredData getRequiredData = new GetRequiredData();
    //     System.out.println("thread" + getRequiredData.getSortThread());
    //     Integer[] arr = getRequiredData.getBarHeigths();
    //     for(Integer a : arr)
    //         System.out.print(a + ", ");
    //     System.out.println();
    //     Sync sy = getRequiredData.getSync();
    //     System.out.println(sy);

    // }

}
