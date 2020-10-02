package edu.rosehulman.andersc7.neuralnetworks;

public class Training {

	private static final int episodes = 20000;
	private static final double learningRate = 0.1;
	private static final double weightOffset = 0.0;
	private static final int hiddenLayerCount = 1;
	private static final int hiddenLayerSize = 3;

	public static void main(String[] args){
		FeedForwardNetwork n = new FeedForwardNetwork(2, hiddenLayerSize, hiddenLayerCount, 1);
		double[][] inputs = {		
				{0,0},
				{0,1},
				{1,0},
				{1,1}
		}; 
		double[][] desiredOutput = {{0},{1},{1},{0}};		
		n.initNetwork(inputs, desiredOutput, learningRate, weightOffset);
		n.trainNetwork(episodes, true);
		n.printWeights();
//		n.testNetwork();
		n.testNetworkBatch(4, inputs, desiredOutput, false);
	}
	
}