/**
 * SE 350 Fall 2021
 * Jawan Luangnikone Davis
 * Project Assignment 1: Sprint 1
 * 10/5/2021
 */
package model;

import model.interfaces.UserChoices;
import model.picture.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import view.gui.PaintCanvas;


public class DrawRectangle {
  // boolean select = false;
  // Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
  private Point origin;
  private int height;
  private int width;
  private Color primaryColor;
  private Color secondaryColor;
  private Graphics2D graphics;


  public DrawRectangle (Graphics2D graphics, Point origin, int height, int width, Color primary, Color secondary) {
    primaryColor = primary;
    secondaryColor = secondary;
    this.origin = origin;
    this.height = height;
    this.width = width;
    this.graphics = graphics;

    graphics.setColor(primaryColor);
    graphics.fillRect(origin.getX(), origin.getY(), width, height);

    graphics.setStroke(new BasicStroke(5));
    graphics.setColor(secondaryColor);
    graphics.drawRect(origin.getX(), origin.getY(), width, height);
  }

    /*
    if (select) {
      graphics.setStroke(stroke);
      graphics.setColor(Color.BLACK);
      graphics.drawRect(origin.getX(), origin.getY(), width, height);
    }
    */
}
