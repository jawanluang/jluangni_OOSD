/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import model.picture.Point;

/**
 * The DrawEllipse class handles the rendering of the ellipse shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawEllipse {

  public DrawEllipse (Graphics2D graphics, Point origin, int height, int width, Color primary) {
    graphics.setColor(primary);
    Ellipse2D el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
    graphics.fill(el);
  }
}
