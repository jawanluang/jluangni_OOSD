package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.DrawEllipse;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

public class Ellipse implements IShape {
  int height, width;
  Point begin;
  Color primaryColor;
  Color secondaryColor;

  public Ellipse(Point start, Point end, UserChoices userChoices) {
    begin = new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
    height = Math.abs(start.getY() - end.getY());
    width = Math.abs(start.getX() - end.getX());

    primaryColor = userChoices.getActivePrimaryColor().value;
    secondaryColor = userChoices.getActiveSecondaryColor().value;
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawEllipse(graphics, begin, height, width, primaryColor, secondaryColor);
  }

  @Override
  public void select(Graphics2D graphics) {

  }

  @Override
  public void move(int x, int y) {
    int newX = begin.getX() + x;
    int newY = begin.getY() + y;
    begin = new Point(newX, newY);
  }
}
