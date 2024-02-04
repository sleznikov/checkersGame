/* 
Game.java
Overall game class has everything that runs checkers game.
Stephan Leznikov
15 March 2021
*/

import java.io.*;
import java.util.*;

public class Game extends Board {
  Piece p1 = new Piece(1, 3); //creates p1 piece object
  Piece p2 = new Piece(2, 4); //creates p2 piece object
  Scanner c = new Scanner(System.in);
  static boolean gameover = false;
  static int x;
  static int y;
  static int x2;
  static int y2;
  static boolean b = true;
  static int invalid = 0;
  static boolean restart;
  static MainMenu m = new MainMenu();
  
  /* 
  Checkers method creates the logic for the game and how it runs
  Stephan Leznikov
  21 March 2021
  */

  public void checkers() {
    int winner = 0;
    do {
      invalid = 0;
      player1();
      gameover = checkGameOver(); //Checks if the game is over
      if (gameover) {
        winner = 1;
      }
      if (gameover == false) {
        invalid = 0;
        player2();
        gameover = checkGameOver(); //Checks if the game is over
        if (gameover) {
          winner = 2;
        }
      }
    }
    while (gameover == false);
    switch (winner) {
      case 1:
        p1.board = board; //Sets the board
        clear();
        printBoard();
        System.out.println ("");
        System.out.println (new str ("Player One Wins!!!!!").red().bold()); //Displays who won the game
      break;
      case 2:
        p2.board = board; //Sets the board
        clear();
        printBoard();
        System.out.println ("");
        System.out.println (new str ("Player Two Wins!!!!!").yellow().bold());  //Displays who won the game
      break;
    }
    System.out.print ("INPUT anything for MAIN MENU: ");
    String s = c.next();
    m.menu(); //Sends the user back to main menu
    
  }
  
  /* 
  Recursive Method for Player 1
  Stephan Leznikov
  26 March 2021
  */

  public void player1() {
    do {
      try {
        b = true;
        p1.board = board;
        clear();
        printBoard();
        System.out.println ("");
        if (invalid != 0){
          System.out.println ("Invalid Input Entered, Please Try Again");
          System.out.println ("");
          invalid = 0;
        }
        System.out.println (new str ("Player Ones Turn").red().bold());
        System.out.print ("Whats the X coordinate of the piece you want to select: ");
      
        x = c.nextInt();
        System.out.print ("Whats the Y coordinate of the piece you want to select: ");
        y = c.nextInt();
        System.out.print ("Whats the X coordinate of where you want to put the piece: ");
        x2 = c.nextInt();
        System.out.print ("Whats the Y coordinate of where you want to put the piece: ");
        y2 = c.nextInt();
      }
      catch (Exception ex) {
        c.nextLine(); // catches an error where if a string is inputed, the program goes crazy
        invalid = 1;
        b = false;
      }
    } while (!b);
    
    System.out.print ("");
    restart = p1.checkMove(y,x,y2,x2);
    if (restart == false) {
      invalid = 1;
      c.nextLine();
      player1(); //loops back to the start of the method if false recursion occurs
    } 
    p1.checkKing();
    board = p1.board; // adds to the board variable

  }
  
  /* 
  Recursive Method For Player 2
  Stephan Leznikov
  26 March 2021
  */
  
  public void player2() {
    do {
      try {
        b = true;
        p2.board = board; //adds to the board variable
        clear();
        printBoard(); //prints the board
        System.out.println ("");
        if (invalid != 0) {
          System.out.println ("Invalid Input Entered Please Try Again");
          System.out.println ("");
        }
        System.out.println (new str ("Player Twos Turn").yellow().bold());
        System.out.print ("Whats the X coordinate of the piece you want to select: ");
      
        x = c.nextInt();
        System.out.print ("Whats the Y coordinate of the piece you want to select: ");
        y = c.nextInt();
        System.out.print ("Whats the X coordinate of where you want to put the piece: ");
        x2 = c.nextInt();
        System.out.print ("Whats the Y coordinate of where you want to put the piece: ");
        y2 = c.nextInt();
      }
      catch (Exception ex) {
        c.nextLine(); // catches an error where if a string is inputed, the program goes crazy
        invalid = 1;
        b = false;
      }
    } while (!b);
    restart = p2.checkMove(y,x,y2,x2);
    if (!restart) {
      invalid = 1;
      player2();
    } 
    p2.checkKing(); //loops back to the start of the method if false recursion occurs
    board = p2.board;
  }
  
  /* 
  Method That Finishes The Game
  Stephan Leznikov
  20 March 2021
  */

  public boolean checkGameOver() {
   int count1 = 0;
   int count2 = 0;
   int count3 = 0;
   int count4 = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) { //loops through the board to see if all the pieces are gone
        if (board[i][j] == 1) {
          count1++;
        }
        else if (board[i][j] == 2) {
          count2++;
        }
        else if (board[i][j] == 3) {
          count3++;
        }
        else if (board[i][j] == 4) {
          count2++;
        }
      }
    }
    if (count1 + count3 == 0 || count2 + count4 == 0) {
    return true;
    }
    else {
    return false;
    }
  }

  /* 
  Method That Clears The Board
  Stephan Leznikov
  15 March 2021
  */

  public void clear() {
  System.out.print("\033[H\033[2J");  //clears the screen
  System.out.flush();  
  }
}