/*
 * amv calculator
 * ELITSA ASENOVA - 260481980, JUNYANG WANG - 260251358
 */

package com.amv;

public class Operations {

	public Operations(){
		
	}
	   
	// scalar addition
	public Vector add(Vector v1, Vector v2, Vector v3) {
		// TODO Auto-generated method stub
		 Vector vResult = new Vector();
		 vResult.x = v1.x + v2.x + v3.x;
		 vResult.y = v1.y + v2.y + v3.y;
		 vResult.z = v1.z + v2.z + v3.z;
	     return vResult;
	}

	public Vector times(Vector v1, double factor) {
		// TODO Auto-generated method stub
		 Vector vResult = new Vector();
		 vResult.x = factor * v1.x;
		 vResult.y = factor * v1.y;
		 vResult.z = factor * v1.z;
	     return vResult;
	}

	// cross (vector) product
	public Vector crossProduct(Vector v1, Vector v2) {
		// TODO Auto-generated method stub
		Vector vResult = new Vector();
		vResult.x = v1.y * v2.z - v1.z * v2.y;
		vResult.y = v1.z * v2.x - v1.x * v2.z;
		vResult.z = v1.x * v2.y - v1.y * v2.x;
		return vResult;
	}
	
	// scalar (dot) product
	public double scalarProduct(Vector v1, Vector v2) {
		double sum = 0.0;
	    sum = v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	    return sum;
	}

	// vector magnitude
	public double getMagnitude(Vector v) {
		// TODO Auto-generated method stub
		return Math.sqrt(scalarProduct(v, v));
	}

	
}