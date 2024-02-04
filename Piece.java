/* 
Piece.java
Creates piece object which creates specific piece per player
Stephan Leznikov
16 March 2021
*/

public class Piece extends Board {
  int piece;
  int kpiece;
  Piece (int opiece, int okpiece) {
    piece = opiece; //sets piece 
    kpiece = okpiece; //sets kpiece
  }
  
  /* 
  CheckMove Method checks if a specific move is allowed by the game rules
  Stephan Leznikov
  16 March 2021
  */
  
  public boolean checkMove  (int x, int y, int x2, int y2)
  {
    if (x < 8 && x > -1 && y < 8 && y > -1 && x2 < 8 && x2 > -1 && y2 < 8 && y2 > -1) { //checks if input is on the board
      if (board [x][y] == piece) { //checks if it is equal to piece
        switch (piece) {
          case 1: //checks if move is allowed if allowed then move is done same in every if statement in case
            if (x2 - x == 1 && y2 - y == 1 && board [x2][y2] == 0) {
              board [x][y] = 0;
              board [x2][y2] = piece;
              return true;
            }           
            if (x - x2 == -1 && y2 - y == -1 && board [x2][y2] == 0) {
              board [x][y] = 0;
              board [x2][y2] = piece;
              return true;
            }
            if (x2 - x == 2 && y2 - y == 2 && board [x+1][y+1] != 0 && board [x+1][y+1] != piece && board [x+1][y+1] != kpiece && board [x2][y2] == 0){
              board [x +1 ] [y +1] = 0;
              board [x2][y2] = piece;
              board [x][y] = 0;
              return true;
            }
            if (x2 - x == 2 && y2 - y == -2 && board [x+1][y-1] != 0 && board [x+1][y-1] != piece && board [x+1][y-1] != kpiece && board [x2][y2] == 0){
              board [x +1][y-1] = 0;
              board [x2][y2] = piece;
              board [x][y] = 0;
              return true;    
            }
            else {
              return false;
            }   
          case 2: //checks if move is allowed if allowed then move is done same with every if statement in case
            if (x2 - x == -1 && y2 - y == -1 && board [x2][y2] == 0) {
              board [x][y] = 0;
              board [x2][y2] = piece;
              return true;
            }
            if (x2 - x == -1 && y2 - y == 1 && board [x2][y2] == 0) {
              board [x][y] = 0;
              board [x2][y2] = piece;
              return true;
            }
            if (x2 - x == -2 && y2 - y == -2 && board [x-1][y-1] != 0 && board [x-1][y-1] != piece && board [x-1][y-1] != kpiece && board [x2][y2] == 0) {
              board [x - 1 ] [y -1] = 0;
              board [x2][y2] = piece;
              board [x][y] = 0;
              return true;
            }
            if (x2 - x == -2 && y2 - y == 2 && board [x-1][y+1] != 0 && board [x-1][y+1] != piece && board [x-1][y+1] != kpiece && board [x2][y2] == 0) {
              board [x - 1][y+1] = 0;
              board [x2][y2] = piece;
              board [x][y] = 0;
              return true;    
            }
            else {
              return false;      
            }   
        }
      }
      else if (board[x][y] == kpiece) { //checks if it is k piece
        if (x2 - x == 1 && y2 - y == 1 && board [x2][y2] == 0) { //checks if move is allowed if allowed then move is done same with every if statement under
          board [x][y] = 0;
          board [x2][y2] = kpiece;
          return true;
        }
        if (x - x2 == -1 && y2 - y == -1 && board [x2][y2] == 0) {
          board [x][y] = 0;
          board [x2][y2] = kpiece;
          return true;
        }
        if (x2 - x == -1 && y2 - y == -1 && board [x2][y2] == 0) {
          board [x][y] = 0;
          board [x2][y2] = kpiece;
          return true;
        }
        if (x2 - x == -1 && y2 - y == 1 && board [x2][y2] == 0) {
          board [x][y] = 0;
          board [x2][y2] = kpiece;
          return true;
        }
        if (x2 - x == 2 && y2 - y == 2 && board [x+1][y+1] != 0 && board [x+1][y+1] != piece && board [x+1][y+1] != kpiece && board [x2][y2] == 0) {
          board [x +1 ] [y +1] = 0;
          board [x2][y2] = kpiece;
          board [x][y] = 0;
          return true;
        }
        if (x2 - x == 2 && y2 - y == -2 && board [x+1][y-1] != 0 && board [x+1][y-1] != piece && board [x+1][y-1] != kpiece && board [x2][y2] == 0) {
          board [x +1][y-1] = 0;
          board [x2][y2] = kpiece;
          board [x][y] = 0;
          return true;    
        }
        if (x2 - x == -2 && y2 - y == -2 && board [x-1][y-1] != 0 && board [x-1][y-1] != piece && board [x-1][y-1] != kpiece && board [x2][y2] == 0) {
          board [x - 1 ] [y -1] = 0;
          board [x2][y2] = kpiece;
          board [x][y] = 0;
          return true;
        }
        if (x2 - x == -2 && y2 - y == 2 && board [x-1][y+1] != 0 && board [x-1][y+1] != piece && board [x-1][y+1] != kpiece && board [x2][y2] == 0){
          board [x - 1][y+1] = 0;
          board [x2][y2] = kpiece;
          board [x][y] = 0;
          return true;    
        }
        else {
          return false; //if all parameters are not true then it reutrns false
        }
      }
    }
    else {
      return false;
    }
    return false;
  }

  /* 
  Checking Method checks if the piece can become a king on a given turn
  Stephan Leznikov
  ICS4U1a
  23 March 2021
  */
  
  public void checkKing() { //checks top and bottom row to see if piece becomes king
    switch (piece) {
      case 1: 
        for (int i = 0; i < 8; i++) {
          if (board [7][i] == 1) {
            board [7] [i] = kpiece;
          }
        }
        break;
      case 2:
        for (int i = 0; i < 8; i++){
          if (board [0][i] == 2){
            board [0] [i] = kpiece;
          }
        }      
        break;
    }
  }

}
