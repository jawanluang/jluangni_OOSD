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
  private Point end;
  private Region region;
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
  public void select(Graphics2D graphics2D){
    drawStrategy.drawSelect(graphics2D, this);
  }

  @Override
  public void move(int x, int y) {
    region.move(x, y);
    end = region.getEndRegion();
    begin = region.getStartRegion();
  }

  @Override
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

  @Override
  public Region getRegion() {
    return region;
  }

  @Override
  public Color getPrimary() {
    return primary;
  }

  @Override
  public Color getSecondary() {
    return secondary;
  }

  @Override
  public ShapeShadingType getSst() {
    return sst;
  }

  @Override
  public DrawStrategy getDrawStrategy() {
    return drawStrategy;
  }
}
