package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import model.picture.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display. It takes a Picture as an input and utilizes
 * the object to render shapes in the graphics system. This is a boundary class
 * so very little code should be added here.
 */
public class PaintCanvas extends JComponent {
    private Picture picture;
    private static final Logger log = LoggerFactory.getLogger(PaintCanvas.class);

    public PaintCanvas(Picture picture) {
        this.picture = picture;
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, it's time to
     * draw the entire picture.
     * If you want to force a paint event, call a PaintCanvas.repaint()
     */
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        picture.draw(graphics2d);

    }
}
