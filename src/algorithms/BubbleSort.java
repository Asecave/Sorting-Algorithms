package algorithms;

public class BubbleSort extends Algorithm {

	public BubbleSort(int[] arr) {
		super(arr);
	}

	@Override
	public void algorithm() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				cursor = j;
				delay();
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
					accesses += 4;
				}
				accesses += 2;
				comparisons++;
			}
		}
	}
}
