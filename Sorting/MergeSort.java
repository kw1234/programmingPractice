import java.util.*;

public class MergeSort {

    public MergeSort() {

    }

    public static int[]  mergeSort(int[] arr) {
	if (arr.length < 2) {
	    return arr;
	}

	int[] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
	int[] right = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));


	int leftIndex = 0;
	int rightIndex = 0;
	int mergedIndex = 0;
	int[] merged = new int[left.length+right.length];

	while (leftIndex < left.length && rightIndex < right.length) {
	    int leftElem = left[leftIndex];
	    int rightElem = right[rightIndex];
	    if (leftElem < rightElem) {
		merged[mergedIndex] = leftElem;
		leftIndex++;
	    } else {
		merged[mergedIndex] = rightElem;
		rightIndex++;
	    }
	    mergedIndex++;
	}
	int[] remaining = leftIndex < left.length ? left:right;
	int remainIndex = leftIndex < left.length ? leftIndex:rightIndex;
	while(remainIndex < remaining.length) {
	    merged[mergedIndex] = remaining[remainIndex];
	    remainIndex++;
	    mergedIndex++;
	}
	return merged;
    }

    public static void main(String[] args) {
	int[] arr = new int[]{1,5,7,4,3,2,6};
	int[] merged = mergeSort(arr);
	for (int n: merged) {
	    System.out.print(n+" ");
	}
	System.out.println();
    }

}