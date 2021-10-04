/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  Topic: Rectangle and Undo & Redo
*/

package model.picture;

/**
 * The Point class takes two integers as an input and stores the data for other classes
 * to call on the getter methods. This class interacts with the MouseHandler to store
 * mouse coordinates that is later provided to the Shapes
 */
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
