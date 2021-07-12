package backend;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.function.Consumer;

import frontend.DataTypeComboBox;
import input.Student;

public class BarLabels {
    
    Object[] labels;
    HashMap<Integer, Consumer<Integer>> convert;
    String value;
    int selectedDataTypeIndex;

    public BarLabels(Object[] list, int selectedDataTypeIndex)
    {
        labels = new Object[list.length];
        for(int i = 0; i < list.length; ++i)
            labels[i] = list[i];//shallow copy

        
        this.selectedDataTypeIndex = selectedDataTypeIndex;

        
        DecimalFormat fFormat = new DecimalFormat("###.##");
        DecimalFormat dFormat = new DecimalFormat("###.###");

        convert = new HashMap<>();
        convert.put(DataTypeComboBox.INTEGER_TYPE, index -> { value = ((Integer)labels[index]).toString(); });
        convert.put(DataTypeComboBox.FLOAT_TYPE, index -> { value = fFormat.format((Float)labels[index]); });
        convert.put(DataTypeComboBox.DOUBLE_TYPE, index -> { value = dFormat.format((Double)labels[index]); });
        convert.put(DataTypeComboBox.CHARACTER_TYPE, index -> { value = ((Character)labels[index]).toString(); });
        convert.put(DataTypeComboBox.STRING_TYPE, index -> { value = ((String)labels[index]).toString(); });
        convert.put(DataTypeComboBox.STUDENT_TYPE, index -> { value = ((Student)labels[index]).toString(); });
        
    }

    public void swap(int index1, int index2)
    {
        Object temp = labels[index1];
        labels[index1] = labels[index2];
        labels[index2] = temp;
    }

    public void Move(int i, int j)
    {
        Object temp = labels[j];
        for(int k = j - 1; k >= i; --k)
            labels[k + 1] = labels[k];
        labels[i] = temp;
    }

    public String at(int index)
    {
        convert.get(selectedDataTypeIndex).accept(index);
        return value;
    }

}
