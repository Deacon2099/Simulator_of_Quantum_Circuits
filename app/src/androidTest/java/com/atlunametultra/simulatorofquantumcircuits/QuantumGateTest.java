package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-04.
 */
public class QuantumGateTest {

    private static final float oneDividedBySqrtOfTwo;

    static {
        oneDividedBySqrtOfTwo = (float) (1 / Math.sqrt(2));
    }

    @Test
    public void gatePauliXTest() throws Exception {
        QuantumGate testQGate = new QuantumGate(1);
        testQGate.PauliX(0,0);
        testQGate.PauliX(0,1);
        assertEquals(0.0f, testQGate.Get(0,0).GetRe(), 0.0f);
        assertEquals(1.0f, testQGate.Get(0,1).GetRe(), 0.0f);
        assertEquals(1.0f, testQGate.Get(1,0).GetRe(), 0.0f);
        assertEquals(0.0f, testQGate.Get(1,1).GetRe(), 0.0f);
    }

    @Test
    public void gatePauliYTest() throws Exception {
        QuantumGate testQGate = new QuantumGate(1);
        testQGate.PauliY(0,0);
        testQGate.PauliY(0,1);
        assertEquals(0.0f, testQGate.Get(0,0).GetRe(), 0.0f);
        assertEquals(-1.0f, testQGate.Get(0,1).GetIm(), 0.0f);
        assertEquals(1.0f, testQGate.Get(1,0).GetIm(), 0.0f);
        assertEquals(0.0f, testQGate.Get(1,1).GetRe(), 0.0f);
    }

    @Test
    public void gatePauliZTest() throws Exception {
        QuantumGate testQGate = new QuantumGate(1);
        testQGate.PauliZ(0,0);
        testQGate.PauliZ(0,1);
        assertEquals(1.0f, testQGate.Get(0,0).GetRe(), 0.0f);
        assertEquals(0.0f, testQGate.Get(0,1).GetRe(), 0.0f);
        assertEquals(0.0f, testQGate.Get(1,0).GetRe(), 0.0f);
        assertEquals(-1.0f, testQGate.Get(1,1).GetRe(), 0.0f);
    }

    @Test
    public void gateHadamardTest() throws Exception {
        QuantumGate testQGate = new QuantumGate(1);
        testQGate.Hadamard(0,0);
        testQGate.Hadamard(0,1);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(0,0).GetRe(), 0.0f);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(0,1).GetRe(), 0.0f);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(1,0).GetRe(), 0.0f);
        assertEquals(-oneDividedBySqrtOfTwo, testQGate.Get(1,1).GetRe(), 0.0f);
    }

    @Test
    public void gateSqrtNOTTest() throws Exception {
        QuantumGate testQGate = new QuantumGate(1);
        testQGate.SqrtNOT(0,0);
        testQGate.SqrtNOT(0,1);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(0,0).GetRe(), 0.0f);
        assertEquals(-oneDividedBySqrtOfTwo, testQGate.Get(0,1).GetRe(), 0.0f);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(1,0).GetRe(), 0.0f);
        assertEquals(oneDividedBySqrtOfTwo, testQGate.Get(1,1).GetRe(), 0.0f);
    }


}