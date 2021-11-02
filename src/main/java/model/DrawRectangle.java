/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model;

import java.awt.Stroke;
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;
import model.interfaces.UserChoices;
import model.picture.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.picture.Rectangle;

/**
 * The DrawRectangle class handles the rendering of the rectangle shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, Color object of
 * the primary, and a Color object of the secondary.
 */
public class DrawRectangle implements DrawStrategy {
  Color primary;
  Color secondary;
  Point origin;
  int height, width;

  @Override
  public void draw(Graphics2D graphics, IShape rect) {
    primary = rect.getPrimary();
    origin = rect.getStart();
    width = rect.getRegion().getWidth();
    height = rect.getRegion().getHeight();
    graphics.setColor(primary);
    graphics.fillRect(origin.getX(), origin.getY(), width, height);
  }

  @Override
  public void drawOutline(Graphics2D graphics, IShape rect) {
    secondary = rect.getSecondary();
    origin = rect.getStart();
    width = rect.getRegion().getWidth();
    height = rect.getRegion().getHeight();
    graphics.setStroke(new BasicStroke(5));
    graphics.setColor(secondary);
    graphics.drawRect(origin.getX(), origin.getY(), width, height);
  }

  @Override
  public void drawSelect(Graphics2D graphics2D, IShape shape) {
    origin = shape.getRegion().getStartRegion();
    width = shape.getRegion().getWidth();
    height = shape.getRegion().getHeight();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.DARK_GRAY);
    graphics2D.drawRect(origin.getX() - 5, origin.getY() - 5, width + 10, height + 10);
  }
}
