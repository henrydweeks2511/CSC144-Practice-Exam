package bathtub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class BathtubPanel extends JPanel implements ActionListener {

    public static final Color BG_COLOR = new Color(180, 224, 248);

    public BathtubPanel() {
        this.setBackground(BG_COLOR);
    } // BathtubPanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();      
        
        double bx = -.5;
        double by = -.5;
        double MAX_RADIUS = .3;
        double MIN_RADIUS = .05;
        double radius = MAX_RADIUS;
        int LIMIT = 10;

        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(w / 2, h / 2);

        AffineTransform transform = new AffineTransform();
        transform.concatenate(translate);
        transform.concatenate(scale);
        
        for (int j=0; j<= LIMIT; j++) {
            Ellipse2D bubble = new Ellipse2D.Double(bx, by, radius, radius);

            List<Shape> bubbles = new ArrayList<>();
                bubbles.add(bubble);

            g2D.setColor(new Color(64, 56, 48));
            for (Shape s : bubbles) {
                Shape fill = transform.createTransformedShape(s);
                g2D.setColor(Color.WHITE);
                g2D.fill(fill);
                g2D.setColor(Color.GRAY);
                Stroke stroke = new BasicStroke(2.5F);
                g2D.setStroke(stroke);
                g2D.draw(fill);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    } // actionPerformed( ActionEvent )
} // Bathtub