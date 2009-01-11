package edu.unikiel.rtsys.kieler.dataflow.ui.wizards;

import dataflow.Box;
import dataflow.Connection;
import dataflow.DataflowFactory;
import dataflow.DataflowModel;
import dataflow.InputPort;
import dataflow.OutputPort;

public class RandomDataflowCreator {

	DataflowFactory df = DataflowFactory.eINSTANCE;
	/**
	 * Probability that a new hierarchy level will be created upon the creation
	 * of a new box.
	 */
	float hierarchyProb = 0.1f;

	DataflowModel createModel(int nodes, int connections) {
		int counter = 0;
		DataflowModel dm = df.createDataflowModel();

		createBoxes(dm, nodes, connections);

		return dm;
	}

	/**
	 * Creates a set of child subboxes in the parent, each box will have the
	 * given amount of outgoing connections. New hierarchy levels are introduced
	 * by random by the hierarchyProb variable.
	 * 
	 * @param parent
	 * @param nodes
	 * @param connections
	 */
	void createBoxes(Box parent, int nodes, int connections) {
		if (nodes <= 0)
			return;
		do {
			Box box = df.createBox();
			box.setName("B" + nodes);
			parent.getBoxes().add(box);
			nodes--;
		} while (Math.random() > hierarchyProb && nodes > 0);

		int thisLayerSize = parent.getBoxes().size();
		for (Object box : parent.getBoxes()) {
			// create new hierarchical layers by calling this recursively
			createBoxes((Box) box, nodes / thisLayerSize, connections);
			// connect inter level hierarchy levels (inputs with the box' children inputs)
			connectInterlevelPorts((Box) box);
			// connect this hierarchy layer
			for (int i = 0; i < connections; i++)
				connectBox((Box) box, parent);
		}
	}

	/**
	 * Creates an outgoing connection from a box to another random box from the
	 * parent box. (i.e. a box on the same hierarchy layer as the source box.)
	 * Will create a new output port for the box and an input port for the
	 * target box.
	 * 
	 * @param box
	 * @param parent
	 */
	void connectBox(Box box, Box parent) {
		// find a random box on same hierarchy layer
		int thisLayerSize = parent.getBoxes().size();
		int randomIndex = randomInt(0, thisLayerSize - 1);
		Box randomBox = parent.getBoxes().get(randomIndex);

		// create ports
		OutputPort op = df.createOutputPort();
		op.setName("output");
		InputPort ip = df.createInputPort();
		ip.setName("input");
		box.getOutputs().add(op);
		randomBox.getInputs().add(ip);

		// connect ports
		Connection c = df.createConnection();
		box.getConnections().add(c);
		c.setSourcePort(op);
		c.setTargetPort(ip);
	}

	/**
	 * Takes a Box and creates new connections between its inputs/outputs
	 * and lower level components. Each lower level component will
	 * get a new input/output.
	 * @param box
	 */
	void connectInterlevelPorts(Box box) {
		// connect input ports with some random child box
		for (Object inputPort : box.getInputs()) {
			InputPort input = (InputPort) inputPort;

			// find a random box on child hierarchy layer
			int childLayerSize = box.getBoxes().size();
			if (childLayerSize > 0) {
				int randomIndex = randomInt(0, childLayerSize - 1);
				Box randomBox = box.getBoxes().get(randomIndex);

				// create new input port
				InputPort ip = df.createInputPort();
				ip.setName("input");
				randomBox.getInputs().add(ip);

				// connect ports
				Connection c = df.createConnection();
				box.getConnections().add(c);
				c.setSourcePort(input);
				c.setTargetPort(ip);
			}
		}
		
		// connect output ports with some random child box
		for (Object outputPort : box.getOutputs()) {
			OutputPort output = (OutputPort) outputPort;

			// find a random box on child hierarchy layer
			int childLayerSize = box.getBoxes().size();
			if (childLayerSize > 0) {
				int randomIndex = randomInt(0, childLayerSize - 1);
				Box randomBox = box.getBoxes().get(randomIndex);

				// create new output port
				OutputPort op = df.createOutputPort();
				op.setName("output");
				randomBox.getOutputs().add(op);

				// connect ports
				Connection c = df.createConnection();
				box.getConnections().add(c);
				c.setSourcePort(op);
				c.setTargetPort(output);
			}
		}
		
	}

	/**
	 * Returns a random integer number in the given range (including the
	 * boundaries).
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	int randomInt(int from, int to) {
		double random = Math.random();
		int size = to - from;
		int offset = (int) Math.round(size * random);
		return from + offset;
	}

}
