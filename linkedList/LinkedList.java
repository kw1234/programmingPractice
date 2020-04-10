import java.util.*;

public class LinkedList {

    public LinkedList() {

    }

    public void removeDupsBuffer(Node lst) {
	Set<Integer> set =  new HashSet<Integer>();
	Node n = lst;
	Node prev = null;

	while (n != null) {
	    if (set.contains(n.val)) {
		prev.next = n.next;
	    } else {
		set.add(n.val);
		prev = n;
	    } 
	    n = n.next;
	}
    }

    public void removeDups(Node lst) {
	Node p1 = lst;
	Node p2 = p1.next;;
	while (p1 != null) {
	    while (p2 != null) {
		if (p1.val == p2.val) {
		    p1.next = p2.next;
		}
		p2 = p2.next;
	    }
	    p1 = p1.next;
	}
    }

    public void printList(Node lst) {
	while (lst != null) {
	    System.out.print(lst.val + " ");
	    lst = lst.next;
	}
	System.out.println();
    }

    public static void main(String[] args) {
	LinkedList funcs = new LinkedList();
	
	Node n = new Node(1);
	Node n2 = new Node(3);
	Node n3 = new Node(2);
	Node n4 = new Node(1);
	Node n5 = new Node(3);

	n4.next = n5;
	n3.next = n4;
	n2.next = n3;
	n.next = n2;

	funcs.printList(n);
	funcs.removeDups(n);
	funcs.printList(n);
    }
}


class Node {
    int val;
    Node next;

    public Node() {
	val = 0;
	next = null;
    }

    public Node(int val) {
	this.val = val;
	next = null;
    }

}