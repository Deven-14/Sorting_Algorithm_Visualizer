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
import datastructure.Pair;
import backend.BarLabels;
import backend.GetRequiredData;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


class VisualizerPanel extends JPanel{

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 475;

    Integer[] barHeights;
    Integer[][] bars;
    int maxBarHeight;
    int rect_width;

    Pair comparedIndices;

    JButton startSortButton;
    Timer timer;

    Sync sync;   
    Thread sortThread;
    GetRequiredData requiredData;
    BarLabels barLabels;
    boolean isSorting;

    DataTypeComboBox dataTypeComboBox;
    AlgorithmComboBox algorithmComboBox;
    ArraySizeSlider arraySizeSlider;

    File audioFile;
    AudioInputStream audioStream;
    Clip clip;

    VisualizerPanel(DataTypeComboBox dataTypeComboBox, AlgorithmComboBox algorithmComboBox, ArraySizeSlider arraySizeSlider)
    {
        this.maxBarHeight = 100; // default range 1 - 1000

        this.dataTypeComboBox = dataTypeComboBox;
        this.algorithmComboBox = algorithmComboBox;
        this.arraySizeSlider = arraySizeSlider;

        sortThread = null;
        requiredData = null;
        sync = null;//imp****
        comparedIndices = null;//imp*****
        isSorting = false;
        bars = null;
        barLabels = null;
        barHeights = null;
        //all data has to be initialized at startSort and not here, coz, it can affect when we click start again, the data of the before sort gets affected here
        
        audioFile = new File("res/beepAudio.wav");

        startSortButton = new JButton("Start");
        startSortButton.addActionListener(new StartSort());
        timer = new Timer(1000, new SortAnElement());
        
        this.add(startSortButton);
    }
    

    @Override
    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(isSorting == false)
            return;

        int index1 = comparedIndices.first;
        int index2 = comparedIndices.second;

        try {
            clip.setMicrosecondPosition(0);
            clip.start(); 
        }
        catch(NullPointerException er) {
            System.err.println(er);
        }

        for (int i = 0; i < bars.length; i++ ) {
            g2d.setPaint(Color.darkGray);
            g2d.fillRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            g2d.setPaint(Color.black);
            g2d.setFont(new Font(null, Font.BOLD, 25));
            g2d.drawString(barLabels.at(i), bars[i][0], bars[i][1]);
            if((i == index1 || i == index2) && index1 != index2)
            {
                g2d.setPaint(Color.RED);
                g2d.setStroke(new BasicStroke(5));//line size
                g2d.drawRect(bars[i][0], bars[i][1], bars[i][2], bars[i][3]);
            } 
        } 

        if(requiredData.getSelectedAlgorithmIndex() != AlgorithmComboBox.MERGE_SORT && requiredData.getSelectedAlgorithmIndex() != AlgorithmComboBox.INSERTION_SORT)
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

        barLabels.swap(i, j);
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

        barLabels.Move(i, j);
    }

    private class StartSort implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            requiredData = new GetRequiredData(dataTypeComboBox.getSelectedIndex(), algorithmComboBox.getSelectedIndex(), arraySizeSlider.getValue());
            sortThread = requiredData.getSortThread();

            sync = requiredData.getSync();
            barLabels = requiredData.getBarLabels();
            comparedIndices = new Pair(0, 0);
            isSorting = true;

            barHeights = requiredData.getBarHeigths();
            bars = new Integer[barHeights.length][4];

            rect_width = PANEL_WIDTH / barHeights.length;

            for (int i = 0; i < barHeights.length; i++ ) {
            
                bars[i][0] = i * rect_width;
                bars[i][1] = PANEL_HEIGHT - (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                bars[i][2] = rect_width;
                bars[i][3] = (barHeights[i] * PANEL_HEIGHT) / maxBarHeight;
                    
            }


            try {

                audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);

            } catch (IOException er) {
                System.err.println(er.getMessage());
            } catch (LineUnavailableException er) {
                System.err.println(er.getMessage());
            } catch (NullPointerException er) {
                System.err.println(er.getMessage());
            } catch (UnsupportedAudioFileException er) {
                System.err.println(er.getMessage());
            }


            startSortButton.setEnabled(false);
            dataTypeComboBox.setEnabled(false);
            algorithmComboBox.setEnabled(false);
            arraySizeSlider.setEnabled(false);

            sortThread.start();
            timer.start();
        }      
    }

    private class SortAnElement implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            sync.receive((indexPair) -> { 
                //System.out.println(indexPair.first + ", " + indexPair.second);
                comparedIndices.set(indexPair);
                repaint();              
            });
            
            if(sync.isCompleted)
            {
                timer.stop();
                Timer timer2 = new Timer(1000, e1 -> {
                    repaint(); //last swap, coz we are showing which to swap and then swapping        
                });
                
                timer2.setRepeats(false);
                timer2.start();

                Timer timer3 = new Timer(3000, new SortingCompleted());

                timer3.setRepeats(false);
                timer3.start();
                
                //System.out.println(sortThread.isAlive());
            }
            
        }
        
    }

    private class SortingCompleted implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            startSortButton.setEnabled(true);
            dataTypeComboBox.setEnabled(true);//coz as we change this during a running sorting process, it'll call repaint most probably and the sorting is not going properly
            algorithmComboBox.setEnabled(true);
            arraySizeSlider.setEnabled(true);

            sortThread = null;
            requiredData = null;
            sync = null;//imp****
            comparedIndices = null;//imp*****
            isSorting = false;
            bars = null;
            barLabels = null;
            barHeights = null;

            try {
                clip.close();
            }
            catch(NullPointerException er) {
                System.err.println(er);
            }
            
        }
        
    }

}