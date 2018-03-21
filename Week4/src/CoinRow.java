public class CoinRow {

	
	public static void main(String[] args){
		int[] arr = {10,5,20,9,1,8};
		
		System.out.println(coinRow(arr,arr.length));
	}
	
	public static int coinRow(int[] arr, int n)
	{
		// Code from http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
		
	    // Create a table to store solutions of subproblems
	    int[][] table = new int[n][n];
	    
	    int gap, i, j, x, y, z;
	 
	    // Fill table using above recursive formula. Note that the table
	    // is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
	    // from diagonal elements to table[0][n-1] which is the result.
	    for (gap = 0; gap < n; ++gap)
	    {
	        for (i = 0, j = gap; j < n; ++i, ++j)
	        {
	            // Here x is value of F(i+2, j), y is F(i+1, j-1) and
	            // z is F(i, j-2) in above recursive formula
	            x = ((i+2) <= j) ? table[i+2][j] : 0;
	            y = ((i+1) <= (j-1)) ? table[i+1][j-1] : 0;
	            z = (i <= (j-2))? table[i][j-2]: 0;
	            
	            table[i][j] = Integer.max(arr[i] + Integer.min(x, y), arr[j] + Integer.min(y, z));
	        }
	            printDoubleArray(table);
	    }
	    return table[0][n-1];
	}
	
	public static void printDoubleArray(int[][] table){
		for(int i = 0; i < table.length; i++){
			for (int j = 0; j < table[i].length; j++){
				System.out.print(table[i][j] + "  ");
			}
			System.out.println();
		}
			System.out.println();
	}
	


}
