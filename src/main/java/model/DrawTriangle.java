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
import model.interfaces.UserChoices;

/**
 * The DrawTriangle class handles the rendering of the triangle shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawTriangle {
  int NUM_SIDES = 3;
  Color primary;
  Color secondary;
  Polygon triangle;
  ShapeShadingType sst;

  public DrawTriangle (Graphics2D graphics, int[] xPoints, int[] yPoints, Color primary, Color secondary, ShapeShadingType shapeShadingType) {
    this.primary = primary;
    this.secondary = secondary;
    this.sst = shapeShadingType;

    switch (sst) {
      case FILLED_IN:
        graphics.setColor(primary);
        triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
        graphics.fillPolygon(triangle);
        break;
      case OUTLINE:
        graphics.setColor(secondary);
        graphics.setStroke(new BasicStroke(5));
        triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
        graphics.drawPolygon(triangle);
        break;
      case OUTLINE_AND_FILLED_IN:
        graphics.setColor(primary);
        triangle = new Polygon(xPoints, yPoints, NUM_SIDES);
        graphics.fillPolygon(triangle);
        graphics.setColor(secondary);
        graphics.setStroke(new BasicStroke(5));
        graphics.drawPolygon(triangle);
      default:
        System.out.println("No shape shading type found.");
    }
  }
}
