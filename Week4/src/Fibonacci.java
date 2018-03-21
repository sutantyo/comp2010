import java.util.HashMap;

public class Fibonacci {

	public static int count;

	public static HashMap<Integer,Integer> fib;
	
	public static void main(String[] args){
	
		count = 0;
		System.out.println(fibonacci(30));
		System.out.println("Number of operations: " + count);

		/*
		count = 0;
		System.out.println(fibonacci2(30));
		System.out.println("Number of operations: " + count);
		*/
		
		/*
		count = 0;
		fib = new HashMap<Integer,Integer>();
		System.out.println(fibonacci3(30));
		System.out.println("Number of operations: " + count);
		*/

	}
	
	public static int fibonacci(int n){
		count++;
		if (n <= 0)		// probably unnecessary
			return 0;
		if (n == 1 || n == 2)
			return 1;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int fibonacci2(int n){
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int a = 1;
		int b = 1;
		for (int i = 0; i < n-2; i++){
			count++;
			b = a + b;
			a = b - a;
		}
		return b;
	}
	
	public static int fibonacci3(int n){
		count++;
		if (!fib.containsKey(n)){
			if (n <= 0)	// probably unnecessary
				fib.put(n, 0);
			else if (n == 1 || n == 2)
				fib.put(n, 1);
			else
				fib.put(n, fibonacci3(n-1) + fibonacci3(n-2));
		}
		return fib.get(n);
	}
	
}
