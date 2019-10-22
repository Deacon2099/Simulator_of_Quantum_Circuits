package com.atlunametultra.simulatorofquantumcircuits;

class QuantumCircuit {
	private int circuitSchematic[][];
	public QuantumRegister initialRegister; //TODO: encapsulate with read only get
	private QuantumGate circuitGates;
	public QuantumRegister finalRegister; //TODO: encapsulate with read only get
	private BinaryFormOfState binaryForm;
	private int totalQubits;
	private int totalStates;
	private int stepLimit = 100;


	public QuantumCircuit(int givenTotalQubits) {
		ConstructQuantumCircuitWithInitialStateZero(givenTotalQubits);
	}

	public QuantumCircuit(int givenTotalQubits, int initialState) {
		ConstructQuantumCircuitWithInitialStateZero(givenTotalQubits);
		initialRegister.Set(0, new Complex(0.0f));
		initialRegister.Set(initialState, new Complex(1.0f));
	}

	private void ConstructQuantumCircuitWithInitialStateZero(int givenTotalQubits) {
		totalQubits = givenTotalQubits;
		totalStates = (int) Math.pow(2, givenTotalQubits);
		circuitSchematic = new int[totalQubits + 1][stepLimit];
		for (int i = 0; i <= (totalQubits); i++) {
			for (int j = 0; j <= stepLimit - 1; j++) {
				circuitSchematic[i][j] = 0;
			}
		}
		initialRegister = new QuantumRegister(totalQubits);
		circuitGates = new QuantumGate(totalQubits);
		finalRegister = new QuantumRegister(totalQubits);
		binaryForm = new BinaryFormOfState(totalQubits);
	}

	public void AddGate(int targetQubit, int stepNumber, int gateID) {
		circuitSchematic[targetQubit][stepNumber] = gateID;
		int controlSum = 0;
		for (int i = 0; i <= totalQubits - 1; i++) {
			controlSum += circuitSchematic[i][stepNumber];
		}
		circuitSchematic[totalQubits][stepNumber] = controlSum;
	}

	//TODO: fragment with IsStateAllowedByControlQubits can be refactored

	public void Calculate() {
		for (int step = 0; step < stepLimit; step++) {
			if (circuitSchematic[totalQubits][step] > 0) {
				for (int qubit = 0; qubit < totalQubits; qubit++) {
					if (circuitSchematic[qubit][step] == 1) {
						for (int state = 0; state < totalStates; state++) {
						    if(IsStateAllowedByControlQubits(state, step))
							circuitGates.PauliX(qubit, state);
						}
					}
					if (circuitSchematic[qubit][step] == 2) {
						for (int state = 0; state < totalStates; state++) {
							if(IsStateAllowedByControlQubits(state, step))
							circuitGates.PauliY(qubit, state);
						}
					}
					if (circuitSchematic[qubit][step] == 3) {
						for (int state = 0; state < totalStates; state++) {
							if(IsStateAllowedByControlQubits(state, step))
							circuitGates.PauliZ(qubit, state);
						}
					}
					if (circuitSchematic[qubit][step] == 4) {
						for (int state = 0; state < totalStates; state++) {
							if(IsStateAllowedByControlQubits(state, step))
							circuitGates.Hadamard(qubit, state);
						}
					}
					if (circuitSchematic[qubit][step] == 5) {
						for (int state = 0; state < totalStates; state++) {
							if(IsStateAllowedByControlQubits(state, step))
							circuitGates.SqrtNOT(qubit, state);
						}
					}
				/*	if(circuitSchematic[qubit][step]==6){ //TODO: need to add checking of second swap target qubit to be able to use Swap gate in circuit
						for(int state=0;state<totalStates;state++){
						if(IsStateAllowedByControlQubits(state, step))
							circuitGates.Swap(qubit,state);
						}
					}*/
				}
			}
		}
		finalRegister = circuitGates.MultiplyBy(initialRegister);
	}

	private boolean IsStateAllowedByControlQubits(int state, int step) {
        for (int qubit = 0; qubit < totalQubits; qubit++) {
            if (circuitSchematic[qubit][step] == 10) {
                if (!binaryForm.QubitIsOneInState(qubit, state)) {
                    return false;
                }
            }
        }
        return true;
    }

	public Complex GetResult(int stateInFinalRegister) {
		return finalRegister.Get(stateInFinalRegister, 0);
	}

	public QuantumGate GetCircuitGates() {
		return circuitGates;
	}
}