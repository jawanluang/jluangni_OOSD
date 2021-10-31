/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 2: Sprint 2
  10/19/2021
 */
package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.DrawEllipse;
import model.ShapeShadingType;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.UserChoices;

/**
 * This class implements the IShape interface and follows the abstract methods presented.
 * (@see model.interfaces.IShape)
 * The Ellipse class takes two Point objects and a UserChoices object as an input. Using the
 * Point objects to create an origin and dimensions for the shape. With the UserChoices object,
 * the class extracts the primary and secondary color of the shape.
 */
public class Ellipse implements IShape {
  int height, width;
  Color primary;
  Color secondary;
  Point end;
  Point begin;
  Region region;
  UserChoices userChoices;
  ShapeShadingType sst;


  public Ellipse(Region region, UserChoices userChoices) {
    this.region = region;
    end = region.getEndRegion();
    begin = region.getStartRegion();
    height = Math.abs(begin.getY() - end.getY());
    width = Math.abs(begin.getX() - end.getX());

    this.userChoices = userChoices;
    primary = userChoices.getActivePrimaryColor().value;
    secondary = userChoices.getActiveSecondaryColor().value;
    sst = userChoices.getActiveShapeShadingType();
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawEllipse(graphics, begin, height, width, primary, secondary, sst);
  }

  @Override
  public void move(int x, int y) {
    int newX = begin.getX() + x;
    int newY = begin.getY() + y;
    begin = new Point(newX, newY);
  }

  @Override
  public Point getStart() {
    return begin;
  }

  @Override
  public Point getEnd() {
    return end;
  }
}
