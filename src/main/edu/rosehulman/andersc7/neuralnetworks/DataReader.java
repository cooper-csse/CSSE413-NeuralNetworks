package edu.rosehulman.andersc7.neuralnetworks;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
	public static final String trainImages = "data/train-images-idx3-ubyte";
	public static final String trainLabels = "data/train-labels-idx1-ubyte";
	public static final String testImages = "data/t10k-images-idx3-ubyte";
	public static final String testLabels = "data/t10k-labels-idx1-ubyte";

	public static final int trainCount = 60000;
	public static final int testCount = 10000;

	private static BufferedInputStream getBuffer(String path, int start) throws IOException {
		BufferedInputStream buf = new BufferedInputStream(new FileInputStream(path));
		for (int i = 0; i < start; i++) buf.read();
		return buf;
	}

	private static double[][] getLabels(String path, int count) {
		double[][] labels = new double[count][];
		try {
			BufferedInputStream buf = getBuffer(path, 8);
			for (int i = 0; i < count; i++) {
				double[] output = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				int label = buf.read();
				output[label] = 1;
				labels[i] = output;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return labels;
	}

	private static double[][] getImages(String path, int count) {
		double[][] images = new double[count][];
		try {
			BufferedInputStream buf = getBuffer(path, 16);
			for (int i = 0; i < count; i++) {
				double[] image = new double[784];
				for (int j = 0; j < 784; j++) image[j] = buf.read() / 255.0;
				images[i] = image;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return images;
	}

	public static double[][] getTrainingLabels() {
		return getLabels(trainLabels, trainCount);
	}

	public static double[][] getTrainingImages() {
		return getImages(trainImages, trainCount);
	}

	public static double[][] getTestingLabels() {
		return getLabels(testLabels, testCount);
	}

	public static double[][] getTestingImages() {
		return getImages(testImages, testCount);
	}
}
