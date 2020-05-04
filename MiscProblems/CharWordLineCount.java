import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class CharWordLineCount {
  
    // char -> iterates when a char is not a space or newline
    // word -> iterates when there is a space or newline seen
    // line -> when newline character is seen
  
    // split charSeen into wordSeen and lineSeen
  
    public static String getCounts(String str){ 
	int charCount = 0;
	int wordCount = 0;
	int lineCount = 0;
	char prev = ' ';
	boolean charSeen = false;
	boolean wordSeen = true;
	boolean lineSeen = true;
	for (int i = 0; i < str.length(); i++) {
	    char ch = str.charAt(i);
      
	    if (ch != ' ' && ch != '\n') {
		charCount++;
		//charSeen = true;
		if (wordSeen) {
		    wordCount++;
		    wordSeen = false;
		}
		if (lineSeen) {
		    System.out.println(wordSeen);
		    lineCount++;
		    lineSeen = false;
		    if (wordSeen) {
			wordCount++;
			wordSeen = false;
		    }
		}
	    } else if (ch == ' ') {
		//charSeen = false;
		//wordCount++;
		wordSeen = true;
	    } else if (ch == '\n') {
		//lineCount ++;
		lineSeen = true;
	    }
	    prev = ch;
	}
	return "("+charCount+" "+wordCount+" "+lineCount+")";
    }
  
    public static void main(String[] args) {
	System.out.println(getCounts("a"));
	System.out.println(getCounts("a b\nc"));
	System.out.println(getCounts("\na"));
	System.out.println(getCounts("abc def"));
	/*System.out.println(getCounts("\n a"));
    System.out.println(getCounts(" ab "));
    System.out.println(getCounts(" ab  "));
    System.out.println(getCounts("\n"));
    System.out.println(getCounts("\n\na"));*/
    }
}

// Given a string, print out the (char, word, line) count
// "a" -> (1, 1, 1)
// "a b\nc" -> (3, 3, 2)
// "\na" -> (1, 1, 2)
// "abc def" -> (6, 2, 1)
// "\n a" -> (1, 1, 2)
// " ab " -> (2, 1, 1)
// "\n" -> (0, 0, 0)
// "\n\na" -> (1, 1, 3) 
