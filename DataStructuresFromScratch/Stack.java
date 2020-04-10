public class Stack {

    Node lst;

    public Stack() {
	
    }

    public boolean isEmpty() {
	return lst == null;
    }

    public void push(int x) {
	Node curr = lst;
	lst = new Node(x);
	lst.next = curr;
    }

    public Node pop() {
	Node result = lst;
	lst = lst.next;
	return result;
    }

    public int peek() {
	return lst.val;
    }
}


class Node {

    Node next;
    int val;

    public Node(int x) {
	this.val = x;
    }

}