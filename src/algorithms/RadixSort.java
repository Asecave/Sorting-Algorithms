package algorithms;

import java.util.Arrays;

public class RadixSort extends Algorithm {
	
	int exponent = 2;

	public RadixSort(int[] arr) {
		super(arr);
	}

	@Override
	void algorithm() {
		radixsort(arr, arr.length);
	}

	private int getMax(int arr[], int n) {
		int mx = arr[0];
		accesses++;
		for (int i = 1; i < n; i++) {
			if (arr[i] > mx) {
				mx = arr[i];
				accesses++;
			}
			accesses++;
			comparisons++;
		}
		return mx;
	}

	private void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[exponent];
		Arrays.fill(count, 0);

		for (i = 0; i < n; i++) {
			cursor = i;
			delay();
			count[(arr[i] / exp) % exponent]++;
			accesses++;
		}

		for (i = 1; i < exponent; i++) {
			count[i] += count[i - 1];
		}

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % exponent] - 1] = arr[i];
			count[(arr[i] / exp) % exponent]--;
			accesses += 3;
		}

		for (i = 0; i < n; i++) {
			cursor = i;
			delay();
			arr[i] = output[i];
			accesses++;
		}
	}

	private void radixsort(int arr[], int n) {
		int m = getMax(arr, n);

		for (int exp = 1; m / exp > 0; exp *= exponent)
			countSort(arr, n, exp);
	}

}
