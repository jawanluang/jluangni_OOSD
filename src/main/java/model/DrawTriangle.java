/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;

/**
 * DrawTriangle implements DrwStrategy and uses all the abstract methods (@see model.interfaces.DrawStrategy)
 * The DrawTriangle class handles the rendering of the triangle shape. It takes an input
 * of a graphics object and an IShape in all three functions.
 */
public class DrawTriangle implements DrawStrategy {
  int NUM_SIDES = 3;
  Color primary;
  Color secondary;
  Polygon triangle;
  int[] xPoints;
  int[] yPoints;

  @Override
  public void draw(Graphics2D graphics, IShape tri) {
    primary = tri.getPrimary();
    xPoints = tri.getRegion().getXArray();
    yPoints = tri.getRegion().getYArray();
    graphics.setColor(primary);
    triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics.fillPolygon(triangle);
  }

  @Override
  public void drawOutline(Graphics2D graphics, IShape tri) {
    secondary = tri.getSecondary();
    xPoints = tri.getRegion().getXArray();
    yPoints = tri.getRegion().getYArray();
    graphics.setColor(secondary);
    graphics.setStroke(new BasicStroke(5));
    triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics.drawPolygon(triangle);
  }

  @Override
  public void drawSelect(Graphics2D graphics2D, IShape shape){
    xPoints = shape.getRegion().getXArray();
    yPoints = shape.getRegion().getYArray();
    xPoints = new int[]{xPoints[0] - 8, xPoints[1], xPoints[2] + 8};
    yPoints = new int[]{yPoints[0] + 5, yPoints[1] - 8, yPoints[2] + 5};
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.DARK_GRAY);
    triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics2D.drawPolygon(triangle);
  }
}
