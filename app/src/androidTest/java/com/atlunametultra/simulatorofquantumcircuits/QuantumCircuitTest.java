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
}