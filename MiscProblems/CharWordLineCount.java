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
  
    public static boolean noCharactersBetween(String str, int start, int end) {
	if (start < 0) return false;
	for (int i = start+1; i < end; i++) {
	    if (Character.isLetter(str.charAt(i))) return false;
	}
	return true;
    }

    public static String getCounts(String str){ 
	int charCount = 0;
	int wordCount = 0;
	int lineCount = 0;

	int tempWords = 0;
	int tempLines = 0;

	char prev = ' ';
	int prevCh = -1;

	boolean lineSeen = false;
	boolean spaceSeen = false;
	for (int i = 0; i < str.length(); i++) {
	    char ch = str.charAt(i);
	    if (Character.isLetter(ch)) {
		if (spaceSeen && tempLines == 0) {
		    wordCount++;
		    spaceSeen = false;
		}
                if (tempLines > 0) {
		    lineCount += tempLines;
		    if (noCharactersBetween(str, prevCh, i)) wordCount++;
		    tempLines = 0;
		}
		charCount++;
		prevCh = i;
	    } else if (ch == ' ') {
		spaceSeen = true;
	    } else if (ch == '\n') {
		tempLines++;
	    }
	    prev = ch;
	}
	if (charCount > 0) {
	    lineCount++;
	}
	if (Character.isLetter(prev)) wordCount++;
	return "("+charCount+", "+wordCount+", "+lineCount+")";
    }
  
    public static void main(String[] args) {
       	System.out.println(getCounts("a") +" should be (1, 1, 1)");
	System.out.println(getCounts("a b\nc") +" should be (3, 3, 2)");
	System.out.println(getCounts("\na") +" should be (1, 1, 2)");
	System.out.println(getCounts("abc def")+" should be (6, 2, 1)");
	System.out.println(getCounts("\n a")+" should be (1, 1, 2)");
	System.out.println(getCounts(" ab ")+" should be (2, 1, 1)");
	System.out.println(getCounts(" ab  ")+" should be (2, 1, 1)");
	System.out.println(getCounts("\n")+" should be (0, 0 ,0)");
	System.out.println(getCounts("\n\na")+" should be (1, 1, 3)");
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
