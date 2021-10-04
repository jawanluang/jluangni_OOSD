/**
 * SE 350 Fall 2021
 * Jawan Luangnikone Davis
 * Project Assignment 1: Sprint 1
 * 10/5/2021
 */
package model.picture;

public class Point {
  private int xCoordinate;
  private int yCoordinate;

  public Point(int x, int y) {
    xCoordinate = x;
    yCoordinate = y;
  }

  public int getX() {
    return xCoordinate;
  }

  public int getY() {
    return yCoordinate;
  }

  public String toString() {
    return "X coordinate: " + xCoordinate + " Y coordinate: " + yCoordinate;
  }
}
