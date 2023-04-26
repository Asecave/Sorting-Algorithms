package algorithms;

public class SelectionSort extends Algorithm {

	int start;

	public SelectionSort(int[] arr) {
		super(arr);
	}

	@Override
	void algorithm() {
		while (start < arr.length) {
			int min = start;
			for (int i = start; i < arr.length; i++) {
				cursor = i;
				delay();
				if (arr[i] < arr[min]) {
					min = i;
				}
				accesses += 2;
				comparisons++;
			}
			swap(start, min);
			accesses += 4;
			
			start++;
		}
	}

}
