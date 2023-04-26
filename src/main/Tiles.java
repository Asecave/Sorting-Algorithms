package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import algorithms.Algorithm;

public class Tiles {

	private Algorithm algorithm;

	public Tiles(Algorithm algorithm) {
		this.algorithm = algorithm;

		this.algorithm.start();
	}

	public void draw(Graphics2D g2d, int offsetX, int offsetY, int width, int height) {
		g2d.drawImage(makeImageFromAlgorithm(algorithm), offsetX, offsetY, width, height, null);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
		g2d.drawString("  Algorithm:", 5 + offsetX, 15 + offsetY);
		g2d.drawString("   Accesses:", 5 + offsetX, 30 + offsetY);
		g2d.drawString("Comparisons:", 5 + offsetX, 45 + offsetY);
		g2d.drawString(algorithm.getClass().getSimpleName(), 110 + offsetX, 15 + offsetY);
		g2d.drawString(algorithm.accesses + "", 110 + offsetX, 30 + offsetY);
		g2d.drawString(algorithm.comparisons + "", 110 + offsetX, 45 + offsetY);
	}

	private BufferedImage makeImageFromAlgorithm(Algorithm algo) {
		int[] arr = algo.getArray();
		BufferedImage img = new BufferedImage(arr.length, arr.length, 
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x]; y++) {
				int c;
				if (x == algo.getCursor()) {
					c = Color.RED.getRGB();
				}else {
					c = Color.WHITE.getRGB();
				}
				if (algo.done) {
					c = Color.GREEN.getRGB();
				}
				img.setRGB(x, arr.length - y - 1, c);
			}
		}
		return img;
	}
}
