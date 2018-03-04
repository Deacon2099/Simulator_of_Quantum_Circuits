package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-02.
 */
public class QuantumRegisterTest {
    @Test
    public void testOfConstructor() throws Exception {
        QuantumRegister testQregist = new QuantumRegister(1);
        testQregist.Set(0,0,new Complex(4.0f, 34.0f)); //setter with row and column
        testQregist.Set(1,new Complex(17.0f, 8.0f)); //setter only with row
        assertEquals(4.0f, testQregist.Get(0,0).GetRe(), 0.0f);
        assertEquals(34.0f, testQregist.Get(0,0).GetIm(), 0.0f);
        assertEquals(17.0f, testQregist.Get(1,0).GetRe(), 0.0f);
        assertEquals(8.0f, testQregist.Get(1,0).GetIm(), 0.0f);
    }

}