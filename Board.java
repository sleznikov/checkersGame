/* 
Board.java
Creates Checkers Board
Stephan Leznikov
9 March 2021
*/

import java.io.*;
import java.util.*;

public abstract class Board {
  static public int[][] board = {  //creates board
    {0,1,0,1,0,1,0,1},
    {1,0,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {2,0,2,0,2,0,2,0},
    {0,2,0,2,0,2,0,2},
    {2,0,2,0,2,0,2,0}
  };

  /* 
  Print board method prints board
  Stephan Leznikov
  9 March 2021
  */

  public void printBoard() {
    System.out.println (new str ("\n \n         C H E C K E R S\n").blue_bright().bold());
    System.out.println ("   0   1   2   3   4   5   6   7");
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (j == 0) {
          System.out.print (i + " ");
        }
        if (board [i][j] == 1) {
          System.out.print (new str (" 0 ").red().bold()); //prints the checker
        }
        else if (board [i][j] == 2) {
          System.out.print (new str (" 0 ").yellow().bold());
        }
        else if (board [i][j] == 3) {
          System.out.print (new str (" X ").red_bright().bold()); //prints the kings
        }
        else if (board [i][j] == 4) {
          System.out.print (new str (" X ").yellow_bright().bold());
        }
        else {
          System.out.print ("   ");
        }
        if (j != 7) {
          System.out.print (new str ("|").cyan().bold());
        }
        if (j == 7) {
          System.out.print (" " + i);
        }
      }
      System.out.println ("");
      if (i != 7) {
        System.out.println (new str ("  -------------------------------").cyan().bold());
      }
    }
    System.out.println ("   0   1   2   3   4   5   6   7");
  } 
   
  /* 
  New board method makes a new board when game resets
  Stephan Leznikov
  9 March 2021
  */

  public void newBoard() {
    board = new int[][] { 
    {0,1,0,1,0,1,0,1},
    {1,0,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {2,0,2,0,2,0,2,0},
    {0,2,0,2,0,2,0,2},
    {2,0,2,0,2,0,2,0}
    };
  }
}