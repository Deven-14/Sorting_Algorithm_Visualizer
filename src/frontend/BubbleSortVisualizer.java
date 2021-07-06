package frontend;

import javax.swing.SwingWorker;

public class BubbleSortVisualizer extends VisualizerPanel{
    public SwingWorker<Void, Void> sort;
    public BubbleSortVisualizer(int [] barHeights) { // generics
        super(barHeights);
        startSort();
        
    }
    public void swap (int index1, int index2) {
        int temp = barHeights[index1];
        barHeights[index1] = barHeights[index2];
        barHeights[index2] = temp;
    }
    
    
    public void startSort () {
        sort = new SwingWorker<> () {
            @Override 
            public Void doInBackground () throws InterruptedException {
                for (int i = 0; i < barHeights.length - 1; i++) {
                    for (int j = 0; j < barHeights.length - 1 - i; j++) {
                        if (barHeights[j]> barHeights[j+ 1]) {
                            swap(j,j +1);
                            Thread.sleep(500);
                            repaint();
                        }
                    }        
                }
                return null;
            }           
        }; 
        sort.execute();
    }
}