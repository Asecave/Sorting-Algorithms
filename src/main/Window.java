package main;

import java.awt.Graphics2D;
import java.util.ArrayList;

import algorithms.BetterBubbleSort;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.RadixSort;
import algorithms.SelectionSort;
import graphics.Frame;

public class Window {

	private Frame frame;
	private ArrayList<Tiles> tiles;
	
	public Window() {
		
		frame = new Frame() {
			@Override
			public void frameLoop(Graphics2D g2d) {
				loop(g2d);
			}
		};
		frame.setTitle("Sorting Algorithms");
		
		int[] arr = new int[100];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			int rand = (int) (Math.random() * arr.length);
			int temp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = temp;
		}
		
		tiles = new ArrayList<Tiles>();
		tiles.add(new Tiles(new BubbleSort(arr)));
		tiles.add(new Tiles(new BetterBubbleSort(arr)));
		tiles.add(new Tiles(new SelectionSort(arr)));
		tiles.add(new Tiles(new InsertionSort(arr)));
		tiles.add(new Tiles(new MergeSort(arr)));
		tiles.add(new Tiles(new QuickSort(arr)));
		tiles.add(new Tiles(new RadixSort(arr)));
		
		frame.startLoop();
	}
	
	private void loop(Graphics2D g2d) {
		
		int countX = 1;
		int countY = 1;
		
		switch (tiles.size()) {
		case 1:
		case 2:
		case 3:
			countX = tiles.size();
			break;
		case 4:
			countX = 2;
			countY = 2;
			break;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			countX = 3;
			countY = 3;
		}

		int width = frame.getWidth() / countX;
		int height = frame.getHeight() / countY;
		
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).draw(g2d, width * (i % countX), height * ((i - (i % countX)) / countY), width, height);
		}
	}
}
