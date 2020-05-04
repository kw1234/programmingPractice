public class DoublyLinkedList {

    public DoublyLinkedList() {

    }


    static class DoublyLinkedList {
	public Node head;
	public Node tail;

	public void setHead(Node node) {
	    // Write your code here.
	    node.next = this.head.next;
	    this.head = node;
	}

	public void setTail(Node node) {
	    // Write your code here.
	    node.prev = this.tail.prev;
	    this.tail = node;
	}

	public void insertBefore(Node node, Node nodeToInsert) {
	    if (node == this.head) {
		setHead(nodeToInsert);
	    } else {
		Node prev = node.prev;
		node.prev = nodeToInsert;
		prev.next = nodeToInsert;
		nodeToInsert.prev = prev;
		nodeToInsert.next = node;
	    }
	}

	public void insertAfter(Node node, Node nodeToInsert) {
	    if (node == this.tail) {
		setTail(nodeToInsert);
	    } else {
		Node next = node.next;
		node.next = nodeToInsert;
		next.prev = nodeToInsert;
		nodeToInsert.prev = node;
		nodeToInsert.next = next;
	    }  
	}

	public void insertAtPosition(int position, Node nodeToInsert) {
	    // Write your code here.
	    Node curr = this.head;
	    while (position > 0) {
		curr = curr.next;
	    }
	    insertAfter(curr, nodeToInsert);
	}

	public void removeNodesWithValue(int value) {
	    Node curr = this.head;
	    while (curr != null) {
		Node removal = curr;
		if (curr.value == value) {
		    remove(removal);
		}
		curr = curr.next;
	    }
	}

	public void remove(Node node) {
	    if (node == this.head) {
		this.head = this.head.next;
	    } if (node == this.tail) {
		this.tail = this.tail.prev;
	    }
	    if (node.prev != null) {
		node.prev.next = node.next;
	    }
	    if (node.next != null) {
		node.next.prev = node.prev;
	    }
	    node.prev = null;
	    node.next = null;
	}

	public boolean containsNodeWithValue(int value) {
	    Node curr = this.head;
	    while (curr != null && curr.value != value) {
		curr = curr.next;
	    }
	    return curr != null;
	}
    }

    // Do not edit the class below.
    static class Node {
	public int value;
	public Node prev;
	public Node next;

	public Node(int value) {
	    this.value = value;
	}
    }
}