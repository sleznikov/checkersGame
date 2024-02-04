/* 
Str.java
The str class is a custom type of String that can change its colour using ANSI escape sequences
Stephan Leznikov
9 March 2021
*/

public class str {

	String S;   //The String
	int modifiers;  //Number of modifiers used

  
	str(String S) {    //Constructor
		if(S.startsWith("\033")) {
			this.S = S;
			modifiers = 0;
		} else {
			this.S = BLACK+S;
			modifiers = 0;
		}
	}
	str(String S, int mod) {   //Constructor
		if(S.startsWith("\033")) {
			this.S = S;
			modifiers = mod;
		} else {
			this.S = BLACK+S;
			modifiers = mod;
		}
	}

	private String RESET = "\033[0m";
	private String BLACK = "\033[37m";

  /* 
  The following methods turns the text into their respective colours based on their method names
  Stephan Leznikov
  ICS4U1a
  9 March 2021
  */
  
  str black() {
		return new str(S.substring(0,2+2*modifiers)+"30m"+S.substring(4+2*modifiers+1));
	}
	str red() {
		return new str(S.substring(0,2+2*modifiers)+"31m"+S.substring(4+2*modifiers+1));
	}
	str green() {
		return new str(S.substring(0,2+2*modifiers)+"32m"+S.substring(4+2*modifiers+1));
	}
	str yellow() {
		return new str(S.substring(0,2+2*modifiers)+"33m"+S.substring(4+2*modifiers+1));
	}
	str blue() {
		return new str(S.substring(0,2+2*modifiers)+"34m"+S.substring(4+2*modifiers+1));
	}
	str purple() {
		return new str(S.substring(0,2+2*modifiers)+"35m"+S.substring(4+2*modifiers+1));
	}
	str cyan() {
		return new str(S.substring(0,2+2*modifiers)+"36m"+S.substring(4+2*modifiers+1));
	}
	str white() {
		return new str(S.substring(0,2+2*modifiers)+"37m"+S.substring(4+2*modifiers+1));
	}
	str black_bright() {
		return new str(S.substring(0,2+2*modifiers)+"90m"+S.substring(4+2*modifiers+1));
	}
	str red_bright() {
		return new str(S.substring(0,2+2*modifiers)+"91m"+S.substring(4+2*modifiers+1));
	}
	str green_bright() {
		return new str(S.substring(0,2+2*modifiers)+"92m"+S.substring(4+2*modifiers+1));
	}
	str yellow_bright() {
		return new str(S.substring(0,2+2*modifiers)+"93m"+S.substring(4+2*modifiers+1));
	}
	str blue_bright() {
		return new str(S.substring(0,2+2*modifiers)+"94m"+S.substring(4+2*modifiers+1));
	}
	str purple_bright() {
		return new str(S.substring(0,2+2*modifiers)+"95m"+S.substring(4+2*modifiers+1));
	}
	str cyan_bright() {
		return new str(S.substring(0,2+2*modifiers)+"96m"+S.substring(4+2*modifiers+1));
	}
	str white_bright() {
		return new str(S.substring(0,2+2*modifiers)+"97m"+S.substring(4+2*modifiers+1));
	}
	str bold () {
		int index = S.indexOf('[');
		return new str(S.substring(0,index+1)+"1;"+S.substring(index+1), modifiers+1);
	}
	str italic () {
		int index = S.indexOf('[');
		return new str(S.substring(0,index+1)+"3;"+S.substring(index+1), modifiers+1);
	}
	str underline () {
		int index = S.indexOf('[');
		return new str(S.substring(0,index+1)+"4;"+S.substring(index+1), modifiers+1);
	}
	str strike () {
		int index = S.indexOf('[');
		return new str(S.substring(0,index+1)+"9;"+S.substring(index+1), modifiers+1);
	}
	
  /* 
  resets to original java color
  Stephan Leznikov
  ICS4U1a
  9 March 2021
  */
  
  public String toString() {
		return S+RESET;
	}
}