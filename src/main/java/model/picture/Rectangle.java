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
import model.interfaces.IShape;
import model.interfaces.UserChoices;

/**
 * This class implements the IShape interface and follows the abstract methods presented.
 * (@see model.interfaces.IShape)
 * The Rectangle class takes two Point objects and a UserChoices object as an input. Using the
 * Point objects to create an origin and dimensions for the shape. With the UserChoices object,
 * the class extracts the primary and secondary color of the shape.
 */
public class Rectangle implements IShape{
  int height, width;
  Point begin;
  UserChoices userChoices;
  Color primaryColor;
  Color secondaryColor;

  public Rectangle(Point start, Point end, UserChoices userChoices) {
    begin = new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
    height = Math.abs(start.getY() - end.getY());
    width = Math.abs(start.getX() - end.getX());
    this.userChoices = userChoices;
    primaryColor = userChoices.getActivePrimaryColor().value;
    secondaryColor = userChoices.getActiveSecondaryColor().value;
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawRectangle(graphics, begin, height, width, primaryColor, secondaryColor);
  }

  @Override
  public void select(Graphics2D graphics) {
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics.setStroke(stroke);
    graphics.setColor(Color.BLACK);
    graphics.drawRect(begin.getX() - 5, begin.getY() - 5, width + 10, height + 10);
  }

  @Override
  public void move(int x, int y) {
    int newX = begin.getX() + x;
    int newY = begin.getY() + y;
    begin = new Point(newX, newY);
  }
}
