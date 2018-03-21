
public class FastExp {

	
	public static int count;
	public static void main(String[] args){
		
		count = 0;
		System.out.println(fastExp(2,27));
		System.out.println(count);
	}
	
	public static int fastExp(int p, int N) {
  // PRE: N >= 0
  // POST: returns p^N
		int x= p;
		int y= 1;
		int n= N;

		while ( n > 0 ) {
		// invariant: y*x^n == p^N
			count++;
			if (n%2 == 0) { 
				x= x*x; 
				n= n/2;
			}
			else { 
				  y = y * x;
				  x = x * x;
				  n = (n-1)/2;
			}    
		}
		return y;
	 }

}
