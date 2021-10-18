package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.picture.Point;

public class DrawEllipse {

  public DrawEllipse (Graphics2D graphics, Point origin, int height, int width, Color primary, Color secondary) {
    graphics.setColor(primary);
    Ellipse2D el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
    graphics.fill(el);
  }
}
