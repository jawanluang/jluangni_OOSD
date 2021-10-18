package model.picture;

import java.awt.Color;
import java.awt.Graphics2D;
import model.DrawTriangle;
import model.interfaces.IShape;
import model.interfaces.UserChoices;

public class Triangle implements IShape {
  Color primaryColor;
  Color secondaryColor;
  int[] xPoints;
  int[] yPoints;

  public Triangle(Point start, Point end, UserChoices userChoices) {
    int halfX = (Math.max(start.getX(), end.getX()) - Math.min(start.getX(), end.getX()))/2;
    xPoints = new int[]{Math.min(start.getX(), end.getX()), Math.min(start.getX(), end.getX()) + halfX, Math.max(start.getX(), end.getX())};
    yPoints = new int[]{Math.max(start.getY(), end.getY()), Math.min(start.getY(), end.getY()), Math.max(start.getY(), end.getY())};

    primaryColor = userChoices.getActivePrimaryColor().value;
    secondaryColor = userChoices.getActiveSecondaryColor().value;
  }

  @Override
  public void draw(Graphics2D graphics) {
    new DrawTriangle(graphics, xPoints, yPoints, primaryColor, secondaryColor);
  }

  @Override
  public void select(Graphics2D graphics) {

  }

  @Override
  public void move(int x, int y) {
    for (int i = 0; i < xPoints.length; i++) {
      xPoints[i] = xPoints[i] + x;
      yPoints[i] = yPoints[i] + y;
    }
  }
}
