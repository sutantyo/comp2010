import java.util.Random;

public class Quicksort {
	
	public static void main(String[] args) {
		
		Random rgen = new Random(3);
		int n = 10;
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = rgen.nextInt(100);
		}
		print(arr);
		quicksort(arr,0,arr.length-1);
		print(arr);
	}

	private static void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);

			quicksort(arr, start, pivot-1);
			quicksort(arr, pivot+1, end);
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
	
		int pivot = arr[start];
		int l = start;
		int f = start+1;
		
		while (f <= end) {
			if (arr[f] > pivot) {
				f++;
			}
			else {
				l++;
				swap(arr,f,l);
				f++;
			}
		}
		swap(arr,l,start);
		return l;
	}
	
	private static int partition2(int[] arr, int start, int end) {
		int pivot = arr[start];
		int f = start+1;
		int l = end+1;
		
		while (f < l) {
			if (arr[f] > pivot) {
				l--;
				swap(arr,f,l);
			}
			else {
				f++;
			}
		}
		
		swap(arr,f-1,start);
		print(arr);
		return f-1;
	}
	
	// helper functions
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void print(int[] arr) {
		System.out.print("[ ");
		int i;
		for(i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[i] + " ]");
	}
}
