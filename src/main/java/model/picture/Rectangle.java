/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model.picture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import model.DrawRectangle;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.DrawStrategy;
import model.interfaces.IShape;
import model.interfaces.Region;
import model.interfaces.UserChoices;

/**
 * This class implements the IShape interface and follows the abstract methods presented.
 * (@see model.interfaces.IShape)
 * The Rectangle class takes two Point objects and a UserChoices object as an input. Using the
 * Point objects to create an origin and dimensions for the shape. With the UserChoices object,
 * the class extracts the primary and secondary color of the shape.
 */
public class Rectangle implements IShape{
  private final Color primary;
  private final Color secondary;
  private Point begin;
  private final Point end;
  private final Region region;
  private final UserChoices userChoices;
  private final ShapeShadingType sst;
  private DrawStrategy drawStrategy;

  public Rectangle(Region region, UserChoices userChoices, DrawStrategy drawStrategy) {
    this.region = region;
    end = region.getEndRegion();
    begin = region.getStartRegion();
    this.drawStrategy = drawStrategy;

    this.userChoices = userChoices;
    primary = userChoices.getActivePrimaryColor().value;
    secondary = userChoices.getActiveSecondaryColor().value;
    sst = userChoices.getActiveShapeShadingType();
  }

  @Override
  public void draw(Graphics2D graphics) {
    drawStrategy.draw(graphics, this);
  }

  @Override
  public void move(int x, int y) {
    int newX = begin.getX() + x;
    int newY = begin.getY() + y;
    begin = new Point(newX, newY);
  }

  public IShape copy() {
    return new Rectangle(region, userChoices, drawStrategy);
  }

  @Override
  public Point getStart() {
    return begin;
  }

  @Override
  public Point getEnd() {
    return end;
  }

  public Region getRegion() {
    return region;
  }

  public Color getPrimary() {
    return primary;
  }

  public Color getSecondary() {
    return secondary;
  }

  public ShapeShadingType getSst() {
    return sst;
  }

  public DrawStrategy getDrawStrategy() {
    return drawStrategy;
  }
}
