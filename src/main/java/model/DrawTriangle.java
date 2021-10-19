/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * The DrawTriangle class handles the rendering of the triangle shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawTriangle {
  int NUM_SIDES = 3;

  public DrawTriangle (Graphics2D graphics, int[] xPoints, int[] yPoints, Color primary) {
    graphics.setColor(primary);
    Polygon triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
    graphics.fillPolygon(triangle);
  }
}
