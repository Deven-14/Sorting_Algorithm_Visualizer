package frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class VisualizerPanel extends JPanel {
   int [] barHeights;
   int maxBarHeight;
   final int PANEL_WIDTH = 800;
   final int PANEL_HEIGHT = 475;
   VisualizerPanel (int[] barHeights) {
       this.barHeights = barHeights;
       this.maxBarHeight = 100; // default range 1 - 1000
   }
   
   @Override
   public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int rect_width = PANEL_WIDTH / barHeights.length;
        for (int i = 0; i < barHeights.length; i++ ) {
        g2d.fillRect(i * rect_width, 
                PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight,
                rect_width,
                (barHeights[i] * PANEL_HEIGHT) / maxBarHeight);
        }
    }
}