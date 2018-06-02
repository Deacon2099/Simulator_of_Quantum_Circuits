package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-02.
 */
public class BinaryFormOfStateTest {

    //BinaryFormOfState contains table with binary form of all states.

    @Test
    public void checkStateSixForFiveQubits() throws Exception {
        BinaryFormOfState testBinaryForm = new BinaryFormOfState(5);
        //Checking state  6 for 5 qubits. Expecting result: [00110] (qubit number zero is last).
        assertFalse(testBinaryForm.QubitIsOneInState(0,6));
        assertTrue(testBinaryForm.QubitIsOneInState(1,6));
        assertTrue(testBinaryForm.QubitIsOneInState(2,6));
        assertFalse(testBinaryForm.QubitIsOneInState(3,6));
        assertFalse(testBinaryForm.QubitIsOneInState(4,6));
    }

    @Test
    public void checkStateNineteenForFiveQubits() throws Exception {
        BinaryFormOfState testBinaryForm = new BinaryFormOfState(5);
        //Checking state 19 for 5 qubits. Expecting result: [10011] (qubit number zero is last).
        assertTrue(testBinaryForm.QubitIsOneInState(0,19));
        assertTrue(testBinaryForm.QubitIsOneInState(1,19));
        assertFalse(testBinaryForm.QubitIsOneInState(2,19));
        assertFalse(testBinaryForm.QubitIsOneInState(3,19));
        assertTrue(testBinaryForm.QubitIsOneInState(4,19));
    }

}