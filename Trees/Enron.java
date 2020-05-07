import java.io.*;
import java.util.*;

public class Enron {

    Trie root;

    public Enron() {
	root = new Trie();
    }

    // returns a Trie mapping words to list of email file paths containing that word
    public Trie indexEmails(String pathToDirectory) {
	File folder = new File(pathToDirectory);
	File[] listOfFiles = folder.listFiles();

	for (File file : listOfFiles) {
	    if (file.isFile()) {
		try {
		    Scanner scanner = new Scanner(file);
		    int lineNumber = 0;
		    while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int positionNumber = 0;
			for (String word : line.split("\\s")) {
			    if (!word.isEmpty()) {
				System.out.println(word+" ");
				root.insert(word, pathToDirectory+file.getName());
			    }
			    positionNumber += word.length() + 1;
			}
			System.out.println();
			lineNumber++;
		    }
	        } catch (FileNotFoundException e) {
		    System.out.println("File not found.");
		}
	    }
	}
	return root;
    }

    // return list of file paths containing the given word
    public List<String> test(String word, Trie trie) {
	TrieNode result = trie.search(word);
	if (result != null) return result.getFilePaths();
	return null;
    }

    public static void main(String[] args) {
	Enron en = new Enron();
	Trie map = en.indexEmails("/Users/karanwarrier/Downloads/skilling-j/_sent_mail/");
	List<String> result = en.test("attend", map);
	for (String s: result){
	    System.out.println(s);
	}
    }

}