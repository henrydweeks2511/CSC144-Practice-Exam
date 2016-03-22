package bathtub;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Bathtub extends JFrame {

    public static final int FRAME_WIDTH = 768;
    public static final int FRAME_HEIGHT = 768;
    public static final String TITLE = "Bathtub";
    
    public Bathtub() {
        this.setSize( FRAME_WIDTH, FRAME_HEIGHT );
        this.setTitle( TITLE );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        
        Container pane = this.getContentPane();
        BathtubPanel panel = new BathtubPanel();
        Timer timer = new Timer( 40, panel );
        timer.start();
        pane.add( panel );
        
        this.setVisible( true  );
        
    } // Bathtub()
    
    public static void main(String[] args) {
        Bathtub bathtub = new Bathtub();
    } // main( String [] )
    
} // Bathtub
