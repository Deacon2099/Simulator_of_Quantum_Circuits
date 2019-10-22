package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-04.
 */
public class QuantumCircuitTest {
    @Test
    public void circuitConstructorForThreeQubitsAndWithStateFive() throws Exception {
        QuantumCircuit testQcircuit = new QuantumCircuit(3,5);
        assertEquals(0.0f, testQcircuit.initialRegister.Get(0,0).GetRe(), 0.0f);
        assertEquals(0.0f, testQcircuit.initialRegister.Get(0,0).GetIm(), 0.0f);
        assertEquals(1.0f, testQcircuit.initialRegister.Get(5,0).GetRe(), 0.0f);
        assertEquals(0.0, testQcircuit.initialRegister.Get(5,0).GetIm(), 0.0f);
    }

    @Test
    public void circuitForControlledQubitWithPuliXTest() throws Exception {
        QuantumCircuit testQcircuit = new QuantumCircuit(2,1);
        testQcircuit.AddGate(0,1,1); //(targetqubit,step,gateId) PauliX
        testQcircuit.AddGate(1,1,10); //(targetqubit,step,gateId) ControlQubit
        testQcircuit.Calculate();
        //assert result
        assertEquals(0.0f, testQcircuit.GetResult(0).GetRe(), 0.0f);
        assertEquals(1.0f, testQcircuit.GetResult(1).GetRe(), 0.0f);
        assertEquals(0.0f, testQcircuit.GetResult(2).GetRe(), 0.0f);
        assertEquals(0.0f, testQcircuit.GetResult(3).GetRe(), 0.0f);
        //assert circuitgate
        assertEquals(1.0f,  testQcircuit.GetCircuitGates().Get(0,0).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(0,1).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(0,2).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(0,3).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(1,0).GetRe(), 0.0f);
        assertEquals(1.0f,  testQcircuit.GetCircuitGates().Get(1,1).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(1,2).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(1,3).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(2,0).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(2,1).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(2,2).GetRe(), 0.0f);
        assertEquals(1.0f,  testQcircuit.GetCircuitGates().Get(2,3).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(3,0).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(3,1).GetRe(), 0.0f);
        assertEquals(1.0f,  testQcircuit.GetCircuitGates().Get(3,2).GetRe(), 0.0f);
        assertEquals(0.0f,  testQcircuit.GetCircuitGates().Get(3,3).GetRe(), 0.0f);

    }
}