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
import java.awt.geom.Ellipse2D;
import model.interfaces.UserChoices;
import model.picture.Point;

/**
 * The DrawEllipse class handles the rendering of the ellipse shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawEllipse {
  Color primary;
  Color secondary;
  Ellipse2D el;
  ShapeShadingType sst;

  public DrawEllipse (Graphics2D graphics, Point origin, int height, int width, Color primary, Color secondary, ShapeShadingType shapeShadingType) {
    this.primary = primary;
    this.secondary = secondary;
    this.sst = shapeShadingType;

    switch (sst) {
      case FILLED_IN:
        graphics.setColor(primary);
        el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
        graphics.fill(el);
        break;
      case OUTLINE:
        graphics.setColor(secondary);
        graphics.setStroke(new BasicStroke(5));
        el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
        graphics.draw(el);
        break;
      case OUTLINE_AND_FILLED_IN:
        graphics.setColor(primary);
        el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
        graphics.fill(el);
        graphics.setColor(secondary);
        graphics.setStroke(new BasicStroke(5));
        graphics.draw(el);
        break;
      default:
        System.out.println("No shape shading type found.");
    }
  }
}
