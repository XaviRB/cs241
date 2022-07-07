public class InsertionSort extends TestInsertion{
	//This is my sort method
	public static int[] sort(int[] A){
		//my insertsort algorithm
		for (int i = 1; i < A.length; i++) {
			int j = i - 1;
			int key = A[i];
			while (j >= 0 && A[j] > key) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = key;
		}
		//returns the sorted list
		return A;
	}
}
