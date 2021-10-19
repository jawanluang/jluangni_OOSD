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
  Point end;
  Point begin;
  UserChoices userChoices;
  Color primaryColor;
  Color secondaryColor;

  public Rectangle(Point start, Point end, UserChoices userChoices) {
    this.end = new Point(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
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
