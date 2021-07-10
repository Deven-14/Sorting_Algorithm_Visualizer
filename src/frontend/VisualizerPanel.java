package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import datastructure.Sync;
import input.Student;
import datastructure.Pair;

import backend.GetRequiredData;

class VisualizerPanel extends JPanel{

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 475;

    Integer[] barHeights;
    Integer[][] bars = null;
    int maxBarHeight;
    int rect_width;

    Pair comparedIndices;

    JButton button;
    Timer timer;

    Sync sync;   
    Thread t1;
    Object[] list;
    GetRequiredData requiredData;

    VisualizerPanel()//, Sync sync) {
    {
        //Integer[] barHeights = {40, 70, 90, 20, 10, 60, 5};
        this.maxBarHeight = 100; // default range 1 - 1000
        //rect_width = PANEL_WIDTH / barHeights.length;

        sync = null;

        comparedIndices = new Pair(0, 0);

        button = new JButton("Start");
        button.addActionListener(new StartSort());
        timer = new Timer(1000, new SortAnElement());
        
        this.add(button);

        // sync = new Sync();
        // Sort<Integer> s = new BubbleSort<Integer>(sync);
        // SortThread<Integer> st = new SortThread<Integer>(s, barHeights);

        // t1 = new Thread(st);
    }

    String getStringValue(Object o)
    {
        switch(DataTypeComboBox.SELECTED_TYPE)
        {
            case DataTypeComboBox.INTEGER_TYPE:
                return ((Integer)o).toString();
            case DataTypeComboBox.FLOAT_TYPE:
                return ((Float)o).toString();
            case DataTypeComboBox.DOUBLE_TYPE:
                return ((Double)o).toString();
            case DataTypeComboBox.CHARACTER_TYPE:
                return ((Character)o).toString();
            case DataTypeComboBox.STRING_TYPE:
                return ((String)o);
            case DataTypeComboBox.STUDENT_TYPE:
                return ((Student)o).toString();
            default:
                return ((Integer)o).toString();
        }
    }

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(bars == null)
            return;

        int index1 = comparedIndices.first;
        int index2 = comparedIndices.second;

        //swap(index1, index2);

        for (int i = 0; i < bars.length; i++ ) {
            g2d.setPaint(Color.darkGray);
            g2d.fillRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            g2d.setPaint(Color.black);
            g2d.setFont(new Font(null, Font.BOLD, 25));
            g2d.drawString(getStringValue(list[i]), bars[i][0], bars[i][1]);
            if((i == index1 || i == index2) && index1 != index2)
            {
                g2d.setPaint(Color.RED);
                g2d.setStroke(new BasicStroke(5));//line size
                g2d.drawRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            } 
        }

        if(AlgorithmComboBox.SELECTED_SORT != AlgorithmComboBox.MERGE_SORT && AlgorithmComboBox.SELECTED_SORT != AlgorithmComboBox.INSERTION_SORT)
            swap(index1, index2);
        else
            Move(index1, index2);
    }

    public void swap(int i, int j)
    {
        Integer[] temp = bars[i];
        bars[i] = bars[j];
        bars[j] = temp;
        bars[i][0] = i * rect_width;
        bars[j][0] = j * rect_width;
    }

    public void Move(int i, int j)
    {
        Integer[] temp = bars[j];
        for(int k = j - 1; k >= i; --k)
        {
            //bars[k][0] = bars[k+1][0];
            bars[k][0] = (k+1) * rect_width;
            bars[k + 1] = bars[k];
        }
        temp[0] = i * rect_width;
        bars[i] = temp;
    }

    private class StartSort implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            requiredData = new GetRequiredData();
            t1 = requiredData.getSortThread();

            sync = requiredData.getSync();
            list = requiredData.getList();

            barHeights = requiredData.getBarHeigths();
            bars = new Integer[barHeights.length][4];

            rect_width = PANEL_WIDTH / barHeights.length;

            for (int i = 0; i < barHeights.length; i++ ) {
            
                bars[i][0] = i * rect_width;
                bars[i][1] = PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                bars[i][2] = rect_width;
                bars[i][3] = (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                    
            }

            button.setEnabled(false);
            t1.start();
            timer.start();

        }
        
    }

    private class SortAnElement implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            comparedIndices = sync.receive((indexPair) -> { 
                //System.out.println(indexPair.first + ", " + indexPair.second);
                repaint();
            });
            
            if(sync.isCompleted)
            {
                timer.stop();
                Timer timer2 = new Timer(1000, e1 -> repaint());//last swap, coz we are showing which to swap and then swapping
                timer2.setRepeats(false);
                timer2.start();
                button.setEnabled(true);
                //System.out.println(t1.isAlive());
            }
            
        }
        
    }


    // private class MoveAnElement implements ActionListener
    // {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
            
    //         if(bars[comparedIndices.first][0] == x2 && bars[comparedIndices.second][0] == x1)
    //             timer2.stop();

    //         if(bars[comparedIndices.first][0] < x2)
    //             bars[comparedIndices.first][0] += 1;
    //         else if(bars[comparedIndices.first][0] > x2)
    //             bars[comparedIndices.first][0] -= 1;
            
    //         if(bars[comparedIndices.second][0] < x1)
    //             bars[comparedIndices.second][0] += 1;
    //         else if(bars[comparedIndices.second][0] > x1)
    //             bars[comparedIndices.second][0] -= 1;
            
    //         repaint();
    //     }
        
    // }
}