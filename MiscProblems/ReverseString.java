public class ReverseString {

    public ReverseString() {

    }

    public static void reverse(char[] arr, int start, int end) {
	for (int i = start; i < (end-start)/2 + start; i++) {
	    char temp = arr[i];
	    arr[i] = arr[end-i-1];
	    arr[end-i-1] = temp;
	}
    }

    public static void reverseWithSpace(char[] arr) {
	reverse(arr, 0, arr.length);
	for (char ch: arr) {
            System.out.print(ch+" ");
        }
	System.out.println();
	int start = 0;
	int end = 0;
	for (int i = 0; i < arr.length; i++) {
	    char ch = arr[start];
	    if (ch == ' ') {
		reverse(arr, start, end);
		end++;
		start = end;
	    } else {
		end++;
	    }
	}
	reverse(arr, start, end);
    }

    public static void main(String[] args) {
	char[] arr = new char[]{'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l'};
	reverseWithSpace(arr);
	for (char ch: arr) {
	    System.out.print(ch+" ");
	}
	System.out.println();
    }

}