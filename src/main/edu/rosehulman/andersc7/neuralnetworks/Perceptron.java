package edu.rosehulman.andersc7.neuralnetworks;

public class Perceptron {
	private static final int[][] trainingData = {
		{0, 0, 0},
		{0, 1, 0},
		{1, 0, 0},
		{1, 1, 1}
	};

	private static int trainingSetSize = 0;
	private static int networkSize = 0;
	private static double threshold = 0.5; // experiment
	private static double[] weights;
	private static double learningRate = 0.1; // experiment

	private static final int episodes = 10;
	
	private static void initNetwork() {
		trainingSetSize = trainingData.length;
		if (trainingSetSize == 0) {
			System.out.println("No training data.");
			return;
		}
		networkSize = trainingData[0].length - 1;
		if (networkSize == 0) {
			System.out.println("Training data does not contain desired output.");
			return;
		}
		if (networkSize == -1) {
			System.out.println("The network is empty.");
			return;
		}
		weights = new double[networkSize]; 
		for (int i = 0; i < networkSize; i++){
			weights[i] = 0; // experiment with small (and large) weights
		}
	}
	
	private static double stepActivationFunction(double input) {
		if (input >= threshold) return 1;
		return 0;
	}

	/**
	 * TODO: Implement this method. You want to use the following fields:
	 *  trainingSetSize
	 *  networkSize
	 *  weights array
	 *  stepActivationFunction
	 *  learningRate
	 *  trainingData
	 *
	 *  calculate input to output unit: weighted sums of the inputs, followed by calling activation function
	 *  calculate error: desired output - actual output (i.e. activation)
	 *  adjust weights
	 */
	private static void trainNetwork() {
		// Iterate once for each episode
		for (int e = 0; e < episodes; e++) {
			for (int i = 0; i < trainingSetSize; i++) {
				// Gather output information for specific training example
				int[] data = trainingData[i];
				double desired = data[networkSize], input = 0, error;
				for (int n = 0; n < networkSize; n++) input += weights[n] * data[n];
				error = desired - stepActivationFunction(input);

				// Adjust weights accordingly
				if (error == 0) continue;
				for (int w = 0; w < networkSize; w++) weights[w] += learningRate * error * data[w];
			}
		}
	}
	
	private static void printWeights() {
		for (int i = 0; i < networkSize; i++){
			System.out.printf("Weight %d is %f.\n", i, weights[i]);
		}
	}
	
	private static void testNetwork() {
		for (int i = 0; i < trainingSetSize; i++){
			double inputToNeuron = 0;
			for (int j = 0; j < networkSize; j++){
				inputToNeuron += weights[j] * trainingData[i][j];
			}
			double activationOfNeuron = stepActivationFunction(inputToNeuron);
			if (activationOfNeuron != trainingData[i][networkSize])
				System.out.println("Network did not learn training set " + i);	
		}
		System.out.println("Done testing.");
	}
	
	
	public static void main(String[] args) {
		initNetwork();
		trainNetwork();
		printWeights();
		testNetwork();
	}
}