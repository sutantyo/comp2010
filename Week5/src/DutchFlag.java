
public class DutchFlag {

	public static void main(String[] args){
		
		int[] a = {0,2,1,0,0,2,1,1,2,2,2,0,1};
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
	
		printArray(a);
		dutchSort(a);
		printArray(a);

		System.out.println();
		int[] b = {2,2,2,1,1,1,0,0,0};
		printArray(b);
		dutchSort(b);
		printArray(b);
	}
	
	
	public static void dutchSort(int[] a){
		int last0 = -1;
		int firstUnknown = 0;
		int first2 = a.length;
		int temp;
		
		while(firstUnknown < first2){
			if (a[firstUnknown] == 0){
				last0++;
				
				// swap, ... kinda useless when you know it's gonna be 0 and 1
				temp = a[firstUnknown];
				a[firstUnknown] = a[last0];
				a[last0] = temp;
				
				firstUnknown++;
			}
			else if (a[firstUnknown] == 1){
				firstUnknown++;
			}
			else{ // if a[firstUnknown] == 2 
				first2--;
				
				temp = a[firstUnknown];
				a[firstUnknown] = a[first2];
				a[first2] = temp;
			}
		}
	}
	
	public static void printArray(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
