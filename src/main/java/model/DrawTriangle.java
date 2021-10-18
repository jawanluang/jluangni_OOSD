package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;


public class DrawTriangle {
  int NUM_SIDES = 3;

  public DrawTriangle (Graphics2D graphics, int[] xPoints, int[] yPoints, Color primary, Color secondary) {
    graphics.setColor(primary);
    Polygon triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics.fillPolygon(triangle);
  }
}
