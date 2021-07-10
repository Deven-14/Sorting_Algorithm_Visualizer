package frontend;

import java.awt.Color;

import javax.swing.JComboBox;

public class DataTypeComboBox extends JComboBox<String>{
    
    private static String[] dataTypes = {"Integer", "Float", "Double", "Character", "String", "Student"};
    public static final int INTEGER_TYPE = 0;
    public static final int FLOAT_TYPE = 1;
    public static final int DOUBLE_TYPE = 2;
    public static final int CHARACTER_TYPE = 3;
    public static final int STRING_TYPE = 4;
    public static final int STUDENT_TYPE = 5;
    public static int SELECTED_TYPE = 0;

    public DataTypeComboBox()
    {
        super(dataTypes);

        this.setBackground(new Color(0xffffff));
        this.addActionListener( e -> { SELECTED_TYPE = this.getSelectedIndex(); } );

    }

}
