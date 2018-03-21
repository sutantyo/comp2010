
public class LCSS {

	public static void main(String[] args){
		String a = "abcab";
		String b = "abbca";
		System.out.println(lcss(a,b));
		
		a = "CATAGTTTGGGCATGTTTCCCTTGTAGGTGTGAAACCACTTAGCTTCGCGCCGTAGTCCTAAAGGAAAACCTAT";
		b = "CTACGTTGACACACCTACACTGCTCGAAGTAAATATACGAAGCGCGCGGCCTGGCCGGAGCCGTTCCGCATCGT";
		System.out.println(lcss(a,b));
}

	public static String lcss(String a, String b){
		int m = a.length();
		int n = b.length(); 
		int[][] table = new int[m+1][n+1];
		
		// set the last row and last column to 0 (not really necessary in Java)
		for (int i = 0; i < n+1; i++)
			table[m][i] = 0;
		for (int i = 0; i < m+1; i++)
			table[i][n] = 0;
		
		// the main algorithm
		for (int i = m-1; i > -1; i--){
			for (int j = n-1; j > -1; j--){
				// if character matches, then go diagonally 
				if(a.charAt(i) == b.charAt(j)){
					table[i][j] = 1 + table[i+1][j+1];
				}
				// else, compare the cell to your right and to your bottom, and pick the larger one
				else{
					table[i][j] = Integer.max(table[i][j+1], table[i+1][j]);
				}
			}
		}
		
		//printDoubleArray(table);
		
		// this part actually finds the longest string (there can be multiple answers)
		String answer = "";
		int i = 0;
		int j = 0;
		while (table[i][j] > 0){
				if (a.charAt(i) == b.charAt(j)){
					answer = answer + a.charAt(i);
					i++;
					j++;
				}
				else{
					while(table[i+1][j] >= table[i][j])
						i++;
					while(table[i][j+1] >= table[i][j])
						j++;
				}
			}
		return answer;
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
