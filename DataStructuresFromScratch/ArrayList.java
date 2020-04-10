public class ArrayList {

    int[] arr;
    int size;
    int index;

    public ArrayList() {
	index = 0;
	size = 1;
	arr = new int[];
    }

    public void add(int elem) {
	if (index == size) {
	    int[] temp = new int[size*2];
	    for (int i = 0; i < size; i++) {
		temp[i] = arr[i];
	    }
	    size *= 2;
	    arr = temp;
	} else {
	    arr[index] = elem;
	    index++;
	}
    }

    public int get(int i) {
	if (i >= 0 && i < size) {
	    return arr[i];
	}
	return -1;
    }

}