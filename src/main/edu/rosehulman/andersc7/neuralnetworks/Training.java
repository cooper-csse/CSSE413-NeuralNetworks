package edu.rosehulman.andersc7.neuralnetworks;

public class Training {

	private static final int episodes = 10;
	private static final double learningRate = 0.1;
	private static final double weightOffset = 0.0;
	private static final int hiddenLayerCount = 1;
	private static final int hiddenLayerSize = 8;

	public static void main(String[] args){
		FeedForwardNetwork n = new FeedForwardNetwork(784, hiddenLayerSize, hiddenLayerCount, 10);
		System.out.print("Reading data");
		double[][] trainingInputs = DataReader.getTrainingImages();
		System.out.print(".");
		double[][] trainingOutputs = DataReader.getTrainingLabels();
		System.out.print(".");
		double[][] testingInputs = DataReader.getTestingImages();
		System.out.print(". ");
		double[][] testingOutputs = DataReader.getTestingLabels();
		System.out.println("Finished!");
		n.initNetwork(trainingInputs, trainingOutputs, learningRate, weightOffset);

		System.out.print("Training neural network");
		n.trainNetwork(episodes, false);
		System.out.println(" Finished!");

		System.out.print("Testing neural network... ");
		n.testNetworkBatch(DataReader.testCount, testingInputs, testingOutputs, false);
	}
	
}