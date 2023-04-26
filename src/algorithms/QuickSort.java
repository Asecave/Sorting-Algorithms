package algorithms;

public class QuickSort extends Algorithm {

	public QuickSort(int[] arr) {
		super(arr);
	}

	@Override
	void algorithm() {
		sort(arr, 0, arr.length - 1);
	}

	private int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		accesses++;
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			cursor = j;
			delay();
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				accesses += 4;
			}
			comparisons++;
			accesses++;
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		accesses += 4;

		return i + 1;
	}

	private void sort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

}
