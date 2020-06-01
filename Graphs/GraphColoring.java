import java.util.*;

public class GraphColoring {

    public GraphColoring() {

    }

    public static String graphColoring(List<String> colors, ColorNode node) {
	//bfs
	Queue<ColorNode> que = new LinkedList<ColorNode>();
	que.add(node);
	String path = "";
	while (que.size() > 0) {
	    ColorNode curr = que.poll();
	    if (curr.visited) continue;
	    System.out.println(curr.name+" "+curr.visited);
	    curr.visited = true;
	    Set<String> takenColors = new HashSet<String>();
	    for (ColorNode n: curr.neighbors) {
		takenColors.add(n.color);
		if (!n.visited) {
		    System.out.println("not visited "+n.name);
		    que.add(n);
		} else {
		    System.out.println("visited "+n.name);
		}
	    }

	    for (String color: colors) {
		if (!takenColors.contains(color)) {
		    curr.setColor(color);
		    break;
		}
	    }

	    if (curr.color == "") curr.setColor("bad");

	    path += curr.color+","+curr.name+" ";
	}
	return path;
    }

    public static String validBallColors(int red, int blue, int yellow) {
	String coloring = "";
	return coloring;
    }


    public static void main(String[] args) {
	ColorNode n1 = new ColorNode("n1");
        ColorNode n2 = new ColorNode("n2");
        ColorNode n3 = new ColorNode("n3");
        ColorNode n4 = new ColorNode("n4");
        ColorNode n5 = new ColorNode("n5");
        ColorNode n6 = new ColorNode("n6");

	/*
           n3       n6
          |   \     |
          n1 - n2 - n4 - n5
	*/

	//Blue,n1 Yellow,n2 Red,n3 Blue,n4 Red,n3 Yellow,n5 Yellow,n6 

	n1.addNeighbor(n2);
        n1.addNeighbor(n3);
        n2.addNeighbor(n4);
        n2.addNeighbor(n3);
        n4.addNeighbor(n5);
        n4.addNeighbor(n6);
	n5.addNeighbor(n6);

	List<String> colors = new ArrayList<String>();
	colors.add("Red");
	colors.add("Yellow");
	colors.add("Blue");

	System.out.println(graphColoring(colors, n1));
    }
   
}

class ColorNode {

    List<String> neighborColors;
    List<ColorNode> neighbors;
    String color;
    String name;
    boolean visited;

    public ColorNode(String name) {
	this.name = name;
	neighbors = new ArrayList<ColorNode>();
	this.color = "";
	this.visited = false;
    }

    public void addNeighbor(ColorNode node) {
	neighbors.add(node);
	node.neighbors.add(this);
    }

    public void setColor(String color) {
	this.color = color;
    }
}