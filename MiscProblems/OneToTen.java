public class OneToTen {

    public OneToTen() {

    }

    public static int getThreeFiveSum(int n) {
	int sum = 0;
	for (int i = 3; i < n; i++) {
	    if (i%3 == 0 || i%5 == 0) {
		sum += i;
	    }
	}
	return sum;
    }

    public static int evenFibSum(int n) {
	int first = 0;
	int second = 1;
	int sum = 0;
	int evenSum = 0;
	int count = 1;
	while (sum < n) {
	    sum = first+second;
	    first = second;
	    second = sum;
	    if (sum%2 == 0) {
		//System.out.println(sum);
		evenSum += sum;
	    }
	    count++;
	}
	return evenSum;
    }

    public static long largestPrimeFactor(long n) {
	long maxPrime = -1; 
  
        // Print the number of 2s 
        // that divide n 
        while (n % 2 == 0) { 
            maxPrime = 2; 
  
            // equivalent to n /= 2 
            n /= 2; 
        } 
  
        // n must be odd at this point, 
        // thus skip the even numbers 
        // and iterate only for odd 
        // integers 
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            while (n % i == 0) { 
                maxPrime = i; 
                n = n / i; 
            } 
        } 
  
        // This condition is to handle 
        // the case when n is a prime 
        // number greater than 2 
        if (n > 2) 
            maxPrime = n; 
  
        return maxPrime; 
    }

    public static void main(String[] args) {
	System.out.println(largestPrimeFactor(600851475143));
    }
    
}