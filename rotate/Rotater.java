public class Rotater {

    public Rotater() {
	
    }

    public void rotate(int[][] matrix) {
	int offset = 1;
	for (int i = 0; i < matrix.length/2; i++) {
	    int last = matrix.length - i - 1;
	    for (int j = i; j < last; j++) {
		System.out.println(i+" "+j+" "+last);
		int temp = matrix[i][j];
		matrix[i][j] = matrix[matrix.length - j - offset][i]; // 2,0 1,0
		matrix[matrix.length - j - offset][i] = matrix[matrix.length - i- offset][matrix.length - j - offset]; // 
		matrix[matrix.length - i - offset][matrix.length - j - offset] = matrix[j][matrix.length - i - offset];
		matrix[j][matrix.length - i - offset] = temp;
	    }
	}
    }

    public void printMatrix(int[][] matrix) {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[0].length; j++) {
		System.out.print(matrix[i][j] +" ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args) {
	Rotater bt = new Rotater();
	int[][] matrix = new int[][]{{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
	//çbt.printMatrix(matrix);
	bt.rotate(matrix);
	bt.printMatrix(matrix);
    } 

}
