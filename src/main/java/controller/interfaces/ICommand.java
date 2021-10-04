/*
  SE 350 Fall 2021
  Jawan Luangnikone Davis
  Project Assignment 1: Sprint 1
  10/5/2021
 */
package controller.interfaces;

/**
 * The ICommand interface is an abstract template for Command classes to follow.
 * The abstract method, run(), is called when the command must be executed.
 */
public interface ICommand {
  void run();
}
