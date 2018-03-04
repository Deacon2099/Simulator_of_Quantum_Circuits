package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-01.
 */
public class ComplexTest {
    @Test
    public void voidConstructor() throws Exception {
        Complex testcomplex = new Complex();
        assertEquals(0.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(0.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void realConstructor() throws Exception {
        Complex testcomplex = new Complex(5.0f);
        assertEquals(5.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(0.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void fullConstructor() throws Exception {
        Complex testcomplex = new Complex(5.0f, -3.0f);
        assertEquals(5.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(-3.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void negationOfComplex() throws Exception {
        Complex testcomplex = new Complex(2.0f, 8.0f);
        testcomplex = testcomplex.Negation();
        assertEquals(-2.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(-8.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void additionOfTwoComplex() throws Exception {
        Complex testcomplex = new Complex(1.0f, 7.0f);
        Complex testcomplexTwo = new Complex(2.0f, 8.0f);
        testcomplex = testcomplex.Add(testcomplexTwo);
        assertEquals(3.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(15.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void substractionOfTwoComplex() throws Exception {
        Complex testcomplex = new Complex(5.0f, 8.0f);
        Complex testcomplexTwo = new Complex(4.0f, 6.0f);
        testcomplex = testcomplex.Substract(testcomplexTwo);
        assertEquals(1.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(2.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void multiplicationOfTwoComplex() throws Exception {
        Complex testcomplex = new Complex(3.0f, 2.0f);
        Complex testcomplexTwo = new Complex(1.0f, 4.0f);
        testcomplex = testcomplex.MultiplyBy(testcomplexTwo);
        assertEquals(-5.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(14.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void multiplicationBySingleFloat() throws Exception {
        Complex testcomplex = new Complex(3.0f, 2.0f);
        testcomplex = testcomplex.MultiplyBy(4.0f);
        assertEquals(12.0f, testcomplex.GetRe(), 0.0f);
        assertEquals(2.0f, testcomplex.GetIm(), 0.0f);
    }

    @Test
    public void absoluteValueOfComplex() throws Exception {
        Complex testcomplex = new Complex(3.0f, -2.0f);
        testcomplex = testcomplex.Negation();
        assertEquals((float)Math.sqrt(13.0f), testcomplex.Mod(), 0.0f);
    }

    @Test
    public void squareRootOfabsoluteValueOfComplex() throws Exception {
        Complex testcomplex = new Complex(3.0f, -2.0f);
        testcomplex = testcomplex.Negation();
        assertEquals(13.0f, testcomplex.Mod2(), 0.0f);
    }

    @Test
    public void phiAngleInRadians() throws Exception {
        Complex testcomplex = new Complex(3.0f, -2.0f);
        Complex testcomplexTwo = new Complex(0.0f, 2.0f);
        Complex testcomplexThree = new Complex(0.0f, -2.0f);
        assertEquals(-0.5880026f, testcomplex.Phi(), 0.0f);
        assertEquals((((float)Math.PI)/2.0f), testcomplexTwo.Phi(), 0.0f);
        assertEquals((-((float)Math.PI)/2.0f), testcomplexThree.Phi(), 0.0f);
    }

    @Test
    public void toStringForComplex() throws Exception {
        Complex testcomplex = new Complex(3.0f, -2.0f);
        assertEquals(3.0f+""+(-2.0f)+"i", testcomplex.ToNormalString());
    }

    @Test
    public void toPolarStringForComplex() throws Exception {
        Complex testcomplex = new Complex(3.0f, -2.0f);
        assertEquals(3.6055512f+"exp^("+(-0.5880026f)+")i", testcomplex.ToPolarString());
    }
}