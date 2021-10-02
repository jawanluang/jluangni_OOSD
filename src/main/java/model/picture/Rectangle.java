/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/2/2021
*/
package model.picture;

import model.DrawRectangle;
import java.awt.Graphics2D;
import model.interfaces.IShape;

public class Rectangle implements IShape{
  int height, width;
  Point begin;

  public Rectangle(Point start, Point end) {
    begin = new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));

    height = Math.abs(start.getY() - end.getY());
    width = Math.abs(start.getX() - end.getX());
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawRectangle(graphics, begin, height, width);
  }
}
