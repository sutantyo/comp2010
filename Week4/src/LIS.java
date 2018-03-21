import java.util.ArrayList;

public class LIS {

	public static void main (String[] args){
		int[] G1 = {4,5,1,7,2,3,5,6,9};
		System.out.println(longestInc(G1));
		
		int[] G2 = {2,4,3,5,3,7};
		System.out.println(longestInc(G2));

		int[] G3 = {8,10,19,12,17,15,10,6,7,9,14,6,1,6,1,4,4,6,20,10,9,4,17,9,2,11,18,12,20,11};
		System.out.println(longestInc(G3));

	}
	
	public static ArrayList<Integer> longestInc(int[] arr){
		// initialise our lookup array
		// L[i] = longest 
		int[] L = new int[arr.length];
		for(int i = 0; i < L.length; i++){
			L[i] = 1;
		}
		for(int i = 1; i < L.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] && L[i] < L[j]+1){
					L[i] = L[j]+1;
				}
			}
		}
		/*
		for (int i = 0; i < L.length; i++)
			System.out.print(L[i] + " ");
		System.out.println();
		*/
		
		// find the length of the largest sequence
		int max = 0;
		int index = 0;
		for(int i = 0; i < L.length; i++){
			if (L[i] > max){
				max = L[i];
				index = i;
			}
		}
		
		// get the actual sequence
		ArrayList<Integer> answer = new ArrayList();
		answer.add(arr[index]);
		max--;
		index--;
		while(max > 0){
			if(L[index] == max){
				answer.add(0,arr[index]);
				max--;
			}
			index--;
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
