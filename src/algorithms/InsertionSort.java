package algorithms;

public class InsertionSort extends Algorithm {

	int index;

	public InsertionSort(int[] arr) {
		super(arr);
	}

	@Override
	void algorithm() {
		while (index < arr.length) {
			for (int i = index; i > 0; i--) {
				cursor = i;
				delay();
				if (arr[i] < arr[i - 1]) {
					swap(i, i - 1);
					accesses += 4;
				}else {
					break;
				}
				accesses += 2;
				comparisons++;
			}
			index++;
		}
	}

}
