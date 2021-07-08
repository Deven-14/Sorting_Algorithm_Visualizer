package frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import datastructure.Sync;
import datastructure.Pair;

class VisualizerPanel extends JPanel implements ActionListener{

    Integer[] barHeights;
    int maxBarHeight;
    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 475;

    JButton button;
    
    Sync sync;

    Pair comparedIndices;

    int x, y;
    int c;

    VisualizerPanel (Integer[] barHeights, Sync sync) {
        this.barHeights = barHeights;
        this.maxBarHeight = 100; // default range 1 - 1000
        this.sync = sync;

        button = new JButton("Start");
        button.addActionListener(this);
        
        this.add(button);

        x = 0;
        c = 0;
    }

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int rect_width = PANEL_WIDTH / barHeights.length;

        
        c++;
        for (int i = 0; i < barHeights.length; i++ ) {
            g2d.fillRect(
                i * rect_width, 
                PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight,
                rect_width,
                (barHeights[i] * PANEL_HEIGHT) / maxBarHeight
            );
        }

        // try{
        //     Thread.sleep(1000);
        // }catch(InterruptedException e)
        // {
        //     System.out.println(e);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(sync == null)
            return;

        int count = 0;
        //synchronized(""){
        while(!sync.isCompleted)
        {
            count++;
            sync.receive((indexPiar) -> { repaint(); comparedIndices = indexPiar; } );
        }
        //}
        System.out.println(count);
        System.out.println(c);

    }

    private class MoveRect implements ActionListener
    {
        int velocity = 1;

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
        }
        
    }
}