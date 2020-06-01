import java.util.*;

public class ConnectedComponents {

    public ConnectedComponents() {

    }

    public static int getNumConnected(int[][] arr) {
	boolean[][] visited = new boolean[arr.length][arr[0].length];
	int comps = 0;
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		if (!visited[i][j] && arr[i][j] == 1) {
		    System.out.println("visiting "+i+" "+j);
		    visit(arr, i, j, visited);
		    comps++;
		}
	    }
	    System.out.println();
	}
	return comps;
    }

    public static void visit(int[][] arr, int i, int j, boolean[][] visited) {
	Queue<int[]> que = new LinkedList<int[]>();
	que.add(new int[]{i, j});
	while (que.size() > 0) {
	    int[] pair = que.poll();
	    int x = pair[0];
	    int y = pair[1];
	    System.out.println("boola "+x+" "+y);

	    if (arr[x][y] == 0) {
		visited[x][y] = true;
		System.out.println("zero cont");
		continue;
	    }

	    if (visited[x][y]) {
                System.out.println("visit cont");
                continue;
            }

	    visited[x][y] = true;

	    System.out.println("b");
	    if (isValid(arr, x-1, y)) {
		que.add(new int[]{x-1, y});
	    }

	    if (isValid(arr, x+1, y)) {
		que.add(new int[]{x+1, y});
            }

	    if (isValid(arr, x, y-1)) {
		que.add(new int[]{x, y-1});
            }

	    if (isValid(arr, x, y+1)) {
		que.add(new int[]{x, y+1});
            }
	}
    }

    public static int getMaxArea(int[][] arr) {
	boolean[][]visited= new boolean[arr.length][arr[0].length];
	int maxArea = 0;
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		if (!visited[i][j] && arr[i][j] == 1) {
                    System.out.println("visiting "+i+" "+j);
                    int currArea = visitInt(arr, i, j, visited);
		    System.out.println(currArea+" "+maxArea);
                    maxArea = Math.max(currArea, maxArea);
                }
	    }
	    System.out.println();
	}
	return maxArea;
    }

    public static int visitInt(int[][] arr, int i, int j, boolean[][] visited) {
	Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[]{i, j});
	int area = 0;
        while (que.size() > 0) {
            int[] pair = que.poll();
            int x = pair[0];
            int y = pair[1];
            System.out.println("boola "+x+" "+y);

            if (arr[x][y] == 0) {
                visited[x][y] = true;
                System.out.println("zero cont");
                continue;
            }

            if (visited[x][y]) {
                System.out.println("visit cont");
                continue;
            }

            visited[x][y] = true;
	    area++;

            System.out.println("b");
            if (isValid(arr, x-1, y)) {
                que.add(new int[]{x-1, y});
            }

            if (isValid(arr, x+1, y)) {
                que.add(new int[]{x+1, y});
            }

            if (isValid(arr, x, y-1)) {
                que.add(new int[]{x, y-1});
            }

            if (isValid(arr, x, y+1)) {
                que.add(new int[]{x, y+1});
            }
        }
	return area;
    }
    
    public static List<int[]> getValidCoords(int[][] arr, int i, int j) {
	List<int[]> pairs = new ArrayList<int[]>();
	if (i-1 >= 0) pairs.add(new int[]{i-1, j});
	if (i+1 < arr.length) pairs.add(new int[]{i+1, j});
	if (j-1>= 0) pairs.add(new int[]{i, j-1});
	if (j+1 < arr[0].length) pairs.add(new int[]{i, j+1});
	return pairs;
    }

    public static boolean isValid(int[][] arr, int i, int j) {
	return i >= 0 && i < arr.length && j >= 0 && j < arr[0].length;
    }


    public static void main (String[] args) {
	/*
	  3 1 4
	  1 2 5
	  1 0 3
	  
	  4 3 2
	  
	  12
	 */

	int[][] island = { {0, 1, 0, 0},
			   {1, 1, 1, 0},
			   {0, 1, 1, 0},
			   {0, 1, 0, 1},
			   {0, 0, 0, 1}};
	System.out.println(getMaxArea(island));
    }
}