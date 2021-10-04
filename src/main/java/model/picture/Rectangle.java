/**
 * SE 350 Fall 2021
 * Jawan Luangnikone Davis
 * Project Assignment 1: Sprint 1
 * 10/5/2021
 */
package model.picture;

import java.awt.Color;
import model.DrawRectangle;
import java.awt.Graphics2D;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

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
}
