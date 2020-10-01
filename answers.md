1. `3`
2. `0.2`
3. `0.3`

4. > In both situations, the weights add up to more than the threshold.
5. > In order to learn XOR, the input to the last neuron must be high when only one input neuron is active. However, because the calculation adds the activations of the previous layer together, that cannot happen as it will be high when both inputs are active.

6.
    * `0.1`, `12000`
    * `0.2`, `5000`
    * `0.3`, `2500`
    > As the threshold increases, the number of episodes required decreases.

7.
    * `0.1`, `15`, `0.5`, `3`
    * `0.1`, `15`, `0.5`, `2`
    * `0.2`, `10`, `0.7`, `2`
    > Having a large learning rate and small episode count often trains quickly, but is unreliable. The best arrangement is small learning rate, higher episode count, higher threshold, and at least two hidden nodes.

8.
    