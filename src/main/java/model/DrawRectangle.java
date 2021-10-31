/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package model;

import model.interfaces.UserChoices;
import model.picture.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The DrawRectangle class handles the rendering of the rectangle shape. It takes an input
 * of a graphics object, Point object, integer for height, integer for width, Color object of
 * the primary, and a Color object of the secondary.
 */
public class DrawRectangle {
  Color primary;
  Color secondary;
  ShapeShadingType sst;

  public DrawRectangle (Graphics2D graphics, Point origin, int height, int width, Color primary, Color secondary, ShapeShadingType shapeShadingType) {
    this.primary = primary;
    this.secondary = secondary;
    this.sst = shapeShadingType;

    switch (sst) {
      case FILLED_IN:
        graphics.setColor(primary);
        graphics.fillRect(origin.getX(), origin.getY(), width, height);
        break;
      case OUTLINE:
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(secondary);
        graphics.drawRect(origin.getX(), origin.getY(), width, height);
        break;
      case OUTLINE_AND_FILLED_IN:
        graphics.setColor(primary);
        graphics.fillRect(origin.getX(), origin.getY(), width, height);
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(secondary);
        graphics.drawRect(origin.getX(), origin.getY(), width, height);
        break;
      default:
        System.out.println("No shape shading type found.");
        break;
    }
  }

}
