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
import model.interfaces.UserChoices;
import model.picture.Triangle;

/**
 * The DrawTriangle class handles the rendering of the triangle shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawTriangle implements DrawStrategy {
  int NUM_SIDES = 3;
  Color primary;
  Color secondary;
  Polygon triangle;
  ShapeShadingType sst;
  int[] xPoints;
  int[] yPoints;

  @Override
  public void draw(Graphics2D graphics, IShape tri) {
    primary = tri.getPrimary();
    sst = tri.getSst();
    xPoints = tri.getRegion().getXArray();
    yPoints = tri.getRegion().getYArray();
    graphics.setColor(primary);
    triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics.fillPolygon(triangle);
  }

  @Override
  public void drawOutline(Graphics2D graphics, IShape tri ) {
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

  }
}
