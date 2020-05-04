import java.util.*;

public class Trie {

    public Trie() {

    }


}

class TrieNode {

    List<TrieNode> children;
    char val;

    public TrieNode(char val) {
	this.val = val;
	this.children = new ArrayList<TrieNode>();
    }

}