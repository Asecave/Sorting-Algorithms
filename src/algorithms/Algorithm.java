package algorithms;

public abstract class Algorithm implements Runnable {

	private int delay = 10;
	volatile int[] arr;
	public volatile int accesses, comparisons;
	public boolean done = false;
	int cursor = 0;
	
	public Algorithm(int[] arr) {
		this.arr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			this.arr[i] = arr[i];
		}
	}
	
	@Override
	public void run() {
		algorithm();
		done = true;
	}
	
	public void delay() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public int[] getArray() {
//		int[] newArr = new int[arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			newArr[i] = arr[i];
//		}
//		return newArr;
		return arr;
	}
	
	public int getCursor() {
		return cursor;
	}
	
	public void swap(int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
	abstract void algorithm();

}
