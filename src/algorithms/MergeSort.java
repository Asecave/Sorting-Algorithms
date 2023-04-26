package algorithms;

public class MergeSort extends Algorithm {

	public MergeSort(int[] arr) {
		super(arr);
	}

	@Override
	void algorithm() {
		sort(arr, 0, arr.length - 1);
	}

	private void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i) {
			cursor = l + i;
			delay();
			L[i] = arr[l + i];
			accesses++;
		}
		for (int j = 0; j < n2; ++j) {
			cursor = m + 1 + j;
			delay();
			R[j] = arr[m + 1 + j];
			accesses++;
		}

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			cursor = k;
			delay();
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			comparisons++;
			accesses++;
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			accesses++;
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			accesses++;
			j++;
			k++;
		}
	}

	private void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

}
