package com.atlunametultra.simulatorofquantumcircuits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deacon2099 on 2018-03-02.
 */
public class MatrixTest {
    @Test
    public void voidConstructor() throws Exception {
        Matrix testmatrix = new Matrix(5);
        for (int i=0; i<=4; i++){
            for (int j=0; j<=4; j++){
                assertEquals(0.0f, testmatrix.Get(i,j).GetRe(), 0.0f);
                assertEquals(0.0f, testmatrix.Get(i,j).GetIm(), 0.0f);
            }
        }
    }

    @Test
    public void identityMatrixConstructor() throws Exception {
        Matrix testmatrix = new Matrix(5);
        testmatrix.IdentityMatrix();
        for (int i=0; i<=4; i++){
            for (int j=0; j<=4; j++){
                if(i==j){
                    assertEquals(1.0f, testmatrix.Get(i,j).GetRe(), 0.0f);
                    assertEquals(0.0f, testmatrix.Get(i,j).GetIm(), 0.0f);
                }
                else {
                    assertEquals(0.0f, testmatrix.Get(i, j).GetRe(), 0.0f);
                    assertEquals(0.0f, testmatrix.Get(i, j).GetIm(), 0.0f);
                }
            }
        }
    }

    @Test
    public void voidConstructorWithDifferentRowsAndColumns() throws Exception {
        Matrix testmatrix = new Matrix(5,7);
        for (int i=0; i<=4; i++){
            for (int j=0; j<=6; j++){
                assertEquals(0.0f, testmatrix.Get(i,j).GetRe(), 0.0f);
                assertEquals(0.0f, testmatrix.Get(i,j).GetIm(), 0.0f);
            }
        }
    }

    @Test
    public void switchingRowsOfMatrix() throws Exception {
        Matrix testmatrix = new Matrix(6,7);
        testmatrix.Set(3,1, new Complex(4.0f, 34.0f));
        testmatrix.Set(5,1, new Complex(17.0f,8.0f));
        testmatrix.SwitchRow(3,5);
        assertEquals(17.0f, testmatrix.Get(3,1).GetRe(), 0.0f);
        assertEquals(8.0f, testmatrix.Get(3,1).GetIm(), 0.0f);
        assertEquals(4.0f, testmatrix.Get(5,1).GetRe(), 0.0f);
        assertEquals(34.0f, testmatrix.Get(5,1).GetIm(), 0.0f);
    }

    @Test
    public void additionOfTwoMatrices() throws Exception {
        Matrix testmatrix = new Matrix(2,2);
        Matrix testmatrixTwo = new Matrix(2,2);
        testmatrix.Set(0,0, new Complex(1.0f,2.0f));
        testmatrix.Set(0,1, new Complex(3.0f,4.0f));
        testmatrix.Set(1,0, new Complex(5.0f,6.0f));
        testmatrix.Set(1,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(0,0, new Complex(5.0f,6.0f));
        testmatrixTwo.Set(0,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(1,0, new Complex(9.0f,10.0f));
        testmatrixTwo.Set(1,1, new Complex(11.0f,12.0f));
        testmatrix = testmatrix.Add(testmatrixTwo);
        assertEquals(6.0f, testmatrix.Get(0,0).GetRe(), 0.0f);
        assertEquals(8.0f, testmatrix.Get(0,0).GetIm(), 0.0f);
        assertEquals(10.0f, testmatrix.Get(0,1).GetRe(), 0.0f);
        assertEquals(12.0f, testmatrix.Get(0,1).GetIm(), 0.0f);
        assertEquals(14.0f, testmatrix.Get(1,0).GetRe(), 0.0f);
        assertEquals(16.0f, testmatrix.Get(1,0).GetIm(), 0.0f);
        assertEquals(18.0f, testmatrix.Get(1,1).GetRe(), 0.0f);
        assertEquals(20.0f, testmatrix.Get(1,1).GetIm(), 0.0f);
    }


    @Test
    public void substractionOfTwoMatrices() throws Exception {
        Matrix testmatrix = new Matrix(2,2);
        Matrix testmatrixTwo = new Matrix(2,2);
        testmatrix.Set(0,0, new Complex(1.0f,2.0f));
        testmatrix.Set(0,1, new Complex(3.0f,4.0f));
        testmatrix.Set(1,0, new Complex(5.0f,6.0f));
        testmatrix.Set(1,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(0,0, new Complex(5.0f,6.0f));
        testmatrixTwo.Set(0,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(1,0, new Complex(9.0f,10.0f));
        testmatrixTwo.Set(1,1, new Complex(11.0f,12.0f));
        testmatrix = testmatrix.Substract(testmatrixTwo);
        assertEquals(-4.0f, testmatrix.Get(0,0).GetRe(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(0,0).GetIm(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(0,1).GetRe(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(0,1).GetIm(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(1,0).GetRe(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(1,0).GetIm(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(1,1).GetRe(), 0.0f);
        assertEquals(-4.0f, testmatrix.Get(1,1).GetIm(), 0.0f);
    }



    @Test
    public void multiplicationOfTwoMatrices() throws Exception {
        Matrix testmatrix = new Matrix(2,2);
        Matrix testmatrixTwo = new Matrix(2,2);
        testmatrix.Set(0,0, new Complex(1.0f,2.0f));
        testmatrix.Set(0,1, new Complex(3.0f,4.0f));
        testmatrix.Set(1,0, new Complex(5.0f,6.0f));
        testmatrix.Set(1,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(0,0, new Complex(5.0f,6.0f));
        testmatrixTwo.Set(0,1, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(1,0, new Complex(9.0f,10.0f));
        testmatrixTwo.Set(1,1, new Complex(11.0f,12.0f));
        testmatrix = testmatrix.MultiplyBy(testmatrixTwo);
        assertEquals(-20.0f, testmatrix.Get(0,0).GetRe(), 0.0f);
        assertEquals(82.0f, testmatrix.Get(0,0).GetIm(), 0.0f);
        assertEquals(-24.0f, testmatrix.Get(0,1).GetRe(), 0.0f);
        assertEquals(102.0f, testmatrix.Get(0,1).GetIm(), 0.0f);
        assertEquals(-28.0f, testmatrix.Get(1,0).GetRe(), 0.0f);
        assertEquals(202.0f, testmatrix.Get(1,0).GetIm(), 0.0f);
        assertEquals(-32.0f, testmatrix.Get(1,1).GetRe(), 0.0f);
        assertEquals(254.0f, testmatrix.Get(1,1).GetIm(), 0.0f);
    }

    @Test
    public void multiplicationOfTwoMatricesWithDifferentRowsAndColumns() throws Exception {
        Matrix testmatrix = new Matrix(2,3);
        Matrix testmatrixTwo = new Matrix(3,1);
        testmatrix.Set(0,0, new Complex(1.0f,2.0f));
        testmatrix.Set(0,1, new Complex(3.0f,4.0f));
        testmatrix.Set(0,2, new Complex(5.0f,6.0f));
        testmatrix.Set(1,0, new Complex(5.0f,6.0f));
        testmatrix.Set(1,1, new Complex(7.0f,8.0f));
        testmatrix.Set(1,2, new Complex(9.0f,10.0f));
        testmatrixTwo.Set(0,0, new Complex(5.0f,6.0f));
        testmatrixTwo.Set(1,0, new Complex(7.0f,8.0f));
        testmatrixTwo.Set(2,0, new Complex(9.0f,10.0f));
        Matrix testresultmatrix = testmatrix.MultiplyBy(testmatrixTwo);
        assertEquals(-33.0f, testresultmatrix.Get(0,0).GetRe(), 0.0f);
        assertEquals(172.0f, testresultmatrix.Get(0,0).GetIm(), 0.0f);
        assertEquals(-45.0f, testresultmatrix.Get(1,0).GetRe(), 0.0f);
        assertEquals(352.0f, testresultmatrix.Get(1,0).GetIm(), 0.0f);
    }


}