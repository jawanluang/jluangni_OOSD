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
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.picture.Point;

/**
 * The DrawEllipse class handles the rendering of the ellipse shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, and a Color object of
 * the primary color.
 */
public class DrawEllipse implements DrawStrategy {
  Color primary;
  Color secondary;
  Point origin;
  Ellipse2D el;
  ShapeShadingType sst;
  int height, width;

  public void draw (Graphics2D graphics, IShape shape) {
    primary = shape.getPrimary();
    origin = shape.getStart();
    width = shape.getRegion().getWidth();
    height = shape.getRegion().getHeight();
    graphics.setColor(primary);
    el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
    graphics.fill(el);


  }

  @Override
  public void drawOutline(Graphics2D graphics, IShape ellipse) {
    secondary = ellipse.getSecondary();
    origin = ellipse.getStart();
    width = ellipse.getRegion().getWidth();
    height = ellipse.getRegion().getHeight();
    graphics.setColor(secondary);
    graphics.setStroke(new BasicStroke(5));
    el = new Ellipse2D.Double(origin.getX(), origin.getY(), width, height);
    graphics.draw(el);
  }

  @Override
  public void drawSelect(Graphics2D graphics2D, IShape shape) {

  }
}
