package com.atlunametultra.simulatorofquantumcircuits;

import java.util.HashMap;
import java.util.Map;

class Matrix {
	private Map<Integer, Complex> innerMap;
	protected int totalRows;
	protected int totalColumns;

	
	public Matrix(int n){
		totalRows=n;
		totalColumns=n;
		innerMap = new HashMap<>();
	}

	public Matrix(int n, int m){
		totalRows=n;
		totalColumns=m;
		innerMap = new HashMap<>();
	}
	
	public void IdentityMatrix (){
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
			    int matrixIndex = MatrixIndex(i, j);
				if(i==j) {
                    innerMap.put(matrixIndex, new Complex (1.0f,0.0f));
                }
				else {
                    innerMap.put(matrixIndex, new Complex (0.0f,0.0f));
                }
			}
		}
	}
	
	public void SwitchRow(int rowA, int rowB){
		for (int i=0; i<=totalColumns-1; i++){
		    Complex temporaryComplex = Get(rowA, i);
		    Set(rowA, i, Get(rowB, i));
		    Set(rowB, i, temporaryComplex);
		}
	}

	public Matrix Add (Matrix mat1){
		Matrix result = new Matrix(totalRows,totalColumns);
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				result.Set(i,j,this.Get(i,j).Add(mat1.Get(i,j)));
			}
		}
		return result;
	}	
	
	public Matrix Substract (Matrix mat1){
		Matrix result = new Matrix(totalRows,totalColumns);
		for (int i=0; i<=totalRows-1; i++){
			for (int j=0; j<=totalColumns-1; j++){
				result.Set(i,j,this.Get(i,j).Substract(mat1.Get(i,j)));
			}
		}
		return result;
	}		

	public Matrix MultiplyBy (Matrix mat1){
		Matrix result = new Matrix(this.totalRows,mat1.totalColumns);
		try{
			if (this.totalColumns != mat1.totalRows)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
			for (int i=0; i<=this.totalRows-1; i++){
				for (int j=0; j<=mat1.totalColumns-1; j++){
					for (int k=0; k<=this.totalColumns-1; k++){
					result.Set(i,j,result.Get(i,j).Add(this.Get(i,k).MultiplyBy(mat1.Get(k,j))));
					}
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error: Column of first Matrix should be the same lenght as row of second Matrix.");
			System.exit(-1);
		}
		return result;
	}  
	
	public Complex Get(int row, int column){
        int matrixIndex = MatrixIndex(row, column);
		if(innerMap.containsKey(matrixIndex))
		    return innerMap.get(matrixIndex);
		else
		    return new Complex(0.0f, 0.0f);
	}
	
	public void Set(int row, int column, Complex value){
        int matrixIndex = MatrixIndex(row, column);
		if(innerMap.containsKey(matrixIndex))
		    innerMap.remove(matrixIndex);
        if(!value.isZero())
            innerMap.put(matrixIndex, value);
	}

	private int MatrixIndex(int row, int column)
    {
        return (totalRows*row) + column;
    }


	public void DebugPrintMatrixDetailsOnlyRealValues(){
		for (int i=0; i<totalRows; i++){
			System.out.print("["+i+"]"); 
			for (int j=0; j<totalColumns; j++){
				System.out.print(" "+(int)this.Get(i,j).GetRe());
			}
			System.out.println(" ");
		} 
	}
	
	public void DebugPrintMatrixDetailsComplexValues(){
		for (int i=0; i<totalRows; i++){
			System.out.print("["+i+"]"); 
			for (int j=0; j<totalColumns; j++){
			System.out.print(" ["+this.Get(i,j).ToNormalString()+"]");
			}
			System.out.println(" ");
		} 
	}
	
}