package backend;

import frontend.DataTypeComboBox;
import input.*;
import datastructure.Sync;

public class GetRequiredData {

    public Integer[] barHeights;
    public Sync sync;
    public BarLabels barLabels;
    private final int selectedDataTypeIndex;
    private final int arraySize;
    private final int selectedAlgorithmIndex;

    public GetRequiredData(int selectedDataTypeIndex, int selectedAlgorithmIndex, int arraySize)
    {
        this.selectedDataTypeIndex = selectedDataTypeIndex;
        this.selectedAlgorithmIndex = selectedAlgorithmIndex;
        this.arraySize = arraySize;

        barHeights = null;
        barLabels = null;
        sync = new Sync();
    }

    public int getSelectedDataTypeIndex()
    {
        return selectedDataTypeIndex;
    }

    public int getSelectedAlgorithmIndex()
    {
        return selectedAlgorithmIndex;
    }

    public int getArraySize()
    {
        return arraySize;
    }

    public Integer[] getBarHeigths()
    {
        return barHeights;
    }

    public Sync getSync()
    {
        return sync;
    }

    public BarLabels getBarLabels()
    {
        return barLabels;
    }

    public Thread getSortThread()
    {
        Thread t;

        switch(selectedDataTypeIndex)
        {
            case DataTypeComboBox.INTEGER_TYPE:
            {
                Integer[] list = new Integer[arraySize];
                RandomArray<Integer> randomArray = new RandomArray<>(new RandomInteger());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Integer> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Integer> getSortThread = new GetSortThread<Integer>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.CHARACTER_TYPE:
            {
                Character[] list = new Character[arraySize];
                RandomArray<Character> randomArray = new RandomArray<>(new RandomCharacter());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Character> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Character> getSortThread = new GetSortThread<Character>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.FLOAT_TYPE:
            {
                Float[] list = new Float[arraySize];
                RandomArray<Float> randomArray = new RandomArray<>(new RandomFloat());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Float> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Float> getSortThread = new GetSortThread<Float>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.DOUBLE_TYPE:
            {
                Double[] list = new Double[arraySize];
                RandomArray<Double> randomArray = new RandomArray<>(new RandomDouble());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Double> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Double> getSortThread = new GetSortThread<Double>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.STRING_TYPE:
            {
                String[] list = new String[arraySize];
                RandomArray<String> randomArray = new RandomArray<>(new RandomString());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<String> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<String> getSortThread = new GetSortThread<String>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            case DataTypeComboBox.STUDENT_TYPE:
            {
                Student[] list = new Student[arraySize];
                RandomArray<Student> randomArray = new RandomArray<>(new Student());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Student> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Student> getSortThread = new GetSortThread<Student>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

            default:
            {
                Integer[] list = new Integer[arraySize];
                RandomArray<Integer> randomArray = new RandomArray<>(new RandomInteger());
                randomArray.generateRandomArray(list);
                barLabels = new BarLabels(list, selectedDataTypeIndex);
                GetBarHeights<Integer> BarHeights = new GetBarHeights<>();
                barHeights = BarHeights.get(list);
                GetSortThread<Integer> getSortThread = new GetSortThread<Integer>(selectedAlgorithmIndex, list, sync);
                t = new Thread(getSortThread.get());
                break;
            }

        }

        return t;
    }

}
