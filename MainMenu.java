/* 
MainMenu.java
Creates main menu 
Stephan Leznikov
13 March 2021
*/

import java.io.*;
import java.util.*;

class MainMenu extends Board {
  int input;
  Scanner c = new Scanner(System.in);
  Game g = new Game();

  /* 
  Displays overall main menu and asks for input from user
  Stephan Leznikov
  13 March 2021
  */
  
  void menu() {
    g.clear();
    do {
      System.out.println (new str ("\n \n         C H E C K E R S").blue_bright().bold()); //prints menu
      System.out.println (new str ("\n            (1) PLAY").red_bright().bold());
      System.out.println (new str ("\n            (2) HOW TO PLAY").yellow_bright().bold());
      System.out.println (new str ("\n            (3) EXIT").red_bright().bold());
      System.out.print ("\n \n \n User INPUT: ");
      try {
        input = c.nextInt();
      }
      catch (Exception ex) {
        c.nextLine(); //catches an error where if a string is inputed, the program goes crazy
        input = 4;
      }
      switch (input) {
        case 1:
          g.newBoard(); //creates a new board
          g.clear(); //clears the screen
          g.checkers(); //starts the game
          break;
        case 2:
          g.clear();
          htPlay(); //sends to how to play method
          input = 4;
          break;
        case 3:
          break;
      }
      g.clear();
    } while (input != 1 && input != 2 && input != 3);
  }

  /* 
  Reads rules.txt and displays rules
  Stephan Leznikov
  13 March 2021
  */
  
  void htPlay() {
    String sinput;
    System.out.println (new str ("\n \n         HOW TO PLAY").blue_bright().bold()); //Prints how to play
    try {
      BufferedReader br = new BufferedReader(new FileReader ("rules.txt")); //Reads off of the rules.txt txt file
      String s;
      while ((s = br.readLine()) != null) {
        System.out.println (s);
      }
      br.close();
    } catch (Exception ex) {
      return;
    }
    sinput = c.next();
  }
}