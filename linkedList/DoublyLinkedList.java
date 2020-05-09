public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public DoublyLinkedList() {

    }

    //null <- 1 -> <- 2 -> <- 3 -> <- 4 -> <- 5 -> null
    
    public void setHead(Node node) {
	if (head == null) {
	    head = node;
	    tail = node;
	} else {
	    head.prev = node;
	    node.next = head;
	    head = node;
	}
    }
    
    public void setTail(Node node) {
	if (tail == null) {
	    tail = node;
	    head = node;
	} else {
	    tail.next = node;
	    node.prev = tail;
	    tail = node;
	}
    }
    
    public void insertBefore(Node node, Node nodeToInsert) {
	if (node == head) {
	    setHead(nodeToInsert);
	} else {
	    Node prev = node.prev;
	    prev.next = nodeToInsert;
	    node.prev = nodeToInsert;
	    nodeToInsert.prev = prev;
	    nodeToInsert.next = node;
	}
    }
    
    public void insertAfter(Node node, Node nodeToInsert) {
	if (node == tail) {
	    setTail(nodeToInsert);
	} else {
	    Node next = node.next;
	    next.prev = nodeToInsert;
	    node.next = nodeToInsert;
	    nodeToInsert.prev = node;
	    nodeToInsert.next = next;
	}
    }
    
    public void insertAtPosition(int position, Node nodeToInsert) {
	Node ptr = head;
	while (ptr != null && position > 0) {
	    position--;
	    ptr = ptr.next;
	}
	insertAfter(ptr, nodeToInsert);
    }
    
    public void removeNodesWithValue(int value) {
	Node ptr = head;
	while (ptr != null) {
	    if (ptr.value == value) {
		remove(ptr);
	    }
	}
    }
    
    public void remove(Node node) {
	if (node == head) {
	    head = head.next;
	    head.prev = null;
	} else if (node == tail) {
	    tail = tail.prev;
	    tail.next = null;
	} else {
	    Node prev = node.prev;
	    Node next=  node.next;
	    prev.next = next;
	    next.prev = prev;
	}
    }
    
    public boolean containsNodeWithValue(int value) {
	Node copy = head;
	while (copy != null) {
	    if (copy.value == value) return true;
	    copy = copy.next;
	}
	return false;
    }

    public void printLst() {
	Node ptr = head;
	while (ptr != null) {
	    System.out.println(ptr.value);
	    ptr = ptr.next;
	}
    }

    public static void main(String[] args) {
	DoublyLinkedList lst = new DoublyLinkedList();
	Node first = new Node(1);
	Node second = new Node(2);
	Node third = new Node(3);
	Node fourth = new Node(4);
	Node fifth = new Node(5);
	lst.setHead(first);
	lst.insertAfter(first, second);
	lst.insertAfter(second, third);
	lst.insertAfter(third, fourth);
	lst.insertAfter(fourth, fifth);
	lst.remove(third);
	lst.printLst();
    }
}

class Node {
    public int value;
    public Node prev;
    public Node next;
    
    public Node(int value) {
	this.value = value;
    }
}