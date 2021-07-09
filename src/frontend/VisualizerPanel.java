package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import algorithm.BubbleSort;
import algorithm.Sort;
import datastructure.Sync;
import main.SortThread;
import datastructure.Pair;

class VisualizerPanel extends JPanel{

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 475;

    Integer[][] bars;
    int maxBarHeight;
    Integer rect_width;

    Pair comparedIndices;

    JButton button;
    Timer timer;

    Sync sync;   
    Thread t1;

    VisualizerPanel (Integer[] barHeights)//, Sync sync) {
    {
        this.maxBarHeight = 100; // default range 1 - 1000
        rect_width = PANEL_WIDTH / barHeights.length;

        bars = new Integer[barHeights.length][4];
        for (int i = 0; i < barHeights.length; i++ ) {
            
            bars[i][0] = i * rect_width;
            bars[i][1] = PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
            bars[i][2] = rect_width;
            bars[i][3] = (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                
        }

        comparedIndices = new Pair(0, 0);

        button = new JButton("Start");
        button.addActionListener(new StartSort());
        timer = new Timer(1000, new SortAnElement());
        
        this.add(button);

        sync = new Sync();
        Sort<Integer> s = new BubbleSort<Integer>(sync);
        SortThread<Integer> st = new SortThread<Integer>(s, barHeights);

        t1 = new Thread(st);
    }

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int index1 = comparedIndices.first;
        int index2 = comparedIndices.second;

        //swap(index1, index2);

        for (int i = 0; i < bars.length; i++ ) {
            g2d.setPaint(Color.darkGray);
            g2d.fillRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            if((i == index1 || i == index2) && index1 != index2)
            {
                g2d.setPaint(Color.RED);
                g2d.setStroke(new BasicStroke(5));//line size
                g2d.drawRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            } 
        }

        swap(index1, index2);
    }

    public void swap(int i, int j)
    {
        Integer[] temp = bars[i];
        bars[i] = bars[j];
        bars[j] = temp;
        bars[i][0] = i * rect_width;
        bars[j][0] = j * rect_width;
    }

    private class StartSort implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            t1.start();
            timer.start();

        }
        
    }

    private class SortAnElement implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            comparedIndices = sync.receive((indexPair) -> { 
                //swap(indexPair.first, indexPair.second);
                System.out.println(indexPair.first + ", " + indexPair.second);
                repaint();
            } );
            
            if(sync.isCompleted)
            {
                timer.stop();// thread.join also do.
                Timer timer2 = new Timer(1000, e1 -> repaint());//last swap, coz we are showing which to swap and then swapping
                timer2.setRepeats(false);
                timer2.start();
            }
            //swap(comparedIndices.first, comparedIndices.second);
            
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