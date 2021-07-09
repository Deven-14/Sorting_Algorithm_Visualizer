package frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import algorithm.BubbleSort;
import algorithm.Sort;
import datastructure.Sync;
import main.SortThread;
import datastructure.Pair;

class VisualizerPanel extends JPanel implements ActionListener{

    Integer[] barHeights;
    int maxBarHeight;
    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 475;

    JButton button;
    
    Sync sync;

    Pair comparedIndices;

    int c;

    int[][] bh;
    int[] h;
    Integer x1, x2;

    Timer timer;
    Timer timer2;

    VisualizerPanel (Integer[] barHeights)//, Sync sync) {
    {
        this.barHeights = barHeights;
        this.maxBarHeight = 100; // default range 1 - 1000
        //this.sync = sync;

        comparedIndices = new Pair();
        comparedIndices.set(0, 0);

        StartSort startSort = new StartSort();
        SortAnElement sortEle = new SortAnElement();

        button = new JButton("Start");
        button.addActionListener(startSort);

        timer = new Timer(1000, sortEle);
        
        this.add(button);

        c = 0;

        bh = new int[barHeights.length][4];
        h = new int[barHeights.length];
        int rect_width = PANEL_WIDTH / barHeights.length;

        for (int i = 0; i < barHeights.length; i++ ) {
            
            bh[i][0] = i * rect_width;
            h[i] = bh[i][0];
            bh[i][1] = PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
            bh[i][2] = rect_width;
            bh[i][3] = (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                
        }
    }

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //int rect_width = PANEL_WIDTH / barHeights.length;
        
        c++;

        // int temp = bh[comparedIndices.first][0];
        // bh[comparedIndices.first][0] = bh[comparedIndices.second][0];
        // bh[comparedIndices.second][0] = temp;

        for (int i = 0; i < bh.length; i++ ) {
            g2d.fillRect(h[i], bh[i][1], bh[i][2], bh[i][3]);
        }

        // for (int i = 0; i < barHeights.length; i++ ) {
        //     if(i == comparedIndices.first)
        //     {
        //         g2d.fillRect(
        //             i * rect_width + x, 
        //             PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight,
        //             rect_width,
        //             (barHeights[i] * PANEL_HEIGHT) / maxBarHeight
        //         );
        //     }
        //     else
        //     {
        //         g2d.fillRect(
        //             i * rect_width, 
        //             PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight,
        //             rect_width,
        //             (barHeights[i] * PANEL_HEIGHT) / maxBarHeight
        //         );
        //     }
        // }

        // try{
        //     Thread.sleep(1000);
        // }catch(InterruptedException e)
        // {
        //     System.out.println(e);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() != button)
            return;


        // int count = 0;
        
        // while(!sync.isCompleted)
        // {
        //     count++;
        //     sync.receive((indexPiar) -> { this.repaint(); comparedIndices = indexPiar; } );
        // }
        
        // System.out.println(count);
        // System.out.println(c);

    }

    private class StartSort implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            sync = new Sync();
            Sort<Integer> s = new BubbleSort<Integer>(sync);
            SortThread<Integer> st = new SortThread<Integer>(s, barHeights);

            Thread t1 = new Thread(st);

            t1.start();

            timer.start();
            
        }
        
    }

    private class SortAnElement implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(!sync.isCompleted)
            {
                sync.receive((indexPiar) -> { 
                    comparedIndices.set(indexPiar); 
                    int temp = h[comparedIndices.first];
                    h[comparedIndices.first] = h[comparedIndices.second];
                    h[comparedIndices.second] = temp;
                    System.out.println(comparedIndices.first + ", " + comparedIndices.second);
                    repaint();
                } );
            }
            else if(sync.isCompleted)
            {
                timer.stop();// thread.join also do.
                for(Integer a : barHeights)
                    System.out.print(a + " ");
                System.out.println();
            }
            System.out.println(c);
            
            //MoveAnElement moveAnElement = new MoveAnElement();
            //x1 = bh[comparedIndices.first][0];
            //x2 = bh[comparedIndices.second][0];
            //timer2 = new Timer(100, moveAnElement);
        }
        
    }


    private class MoveAnElement implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(bh[comparedIndices.first][0] == x2 && bh[comparedIndices.second][0] == x1)
                timer2.stop();

            if(bh[comparedIndices.first][0] < x2)
                bh[comparedIndices.first][0] += 1;
            else if(bh[comparedIndices.first][0] > x2)
                bh[comparedIndices.first][0] -= 1;
            
            if(bh[comparedIndices.second][0] < x1)
                bh[comparedIndices.second][0] += 1;
            else if(bh[comparedIndices.second][0] > x1)
                bh[comparedIndices.second][0] -= 1;
            
            repaint();
        }
        
    }
}