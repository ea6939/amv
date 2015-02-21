package com.amv;

import junit.framework.TestCase;

public class OperationsTest extends TestCase {

	private Vector v1, v2, v3;
	private Vector vResult;
	private double result;
	private Operations ops;
	
	protected void setUp() throws Exception {
		super.setUp();
		v1 = new Vector();
		v2 = new Vector();
		v3 = new Vector();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// Vector addition
	public void testAddNull(){
		vResult = ops.add(null,null,null);
		assertTrue(vResult.getX() == 0);
		assertTrue(vResult.getY() == 0);
		assertTrue(vResult.getZ() == 0);	
	}
	
	public void testAddOneNullVector(){
		vResult = ops.add(v1,null,null);
		assertTrue(vResult.getX() == 0);
		assertTrue(vResult.getY() == 0);
		assertTrue(vResult.getZ() == 0);
	}
	
	public void testAddTwoNullVectors(){
		vResult = ops.add(v1,v2,null);
		assertTrue(vResult.getX() == 0);
		assertTrue(vResult.getY() == 0);
		assertTrue(vResult.getZ() == 0);
	}
	
	public void testAddThreeNullVectors(){
		vResult = ops.add(null,null,null);
		assertTrue(vResult.getX() == 0);
		assertTrue(vResult.getY() == 0);
		assertTrue(vResult.getZ() == 0);
	}
	
	public void testVectorAddition(){
		v1.setCartisian(2,4,1);
		v2.setCartisian(1,5,7);
		v3.setCartisian(5,2,1);
		
		vResult = ops.add(v1,v2,v3);
		assertTrue(vResult.getX() == 8);
		assertTrue(vResult.getY() == 11);
		assertTrue(vResult.getZ() == 9);		
	}
	
	public void testInitialVectors(){
		v1.setCartisian(2,4,1);
		v2.setCartisian(1,5,7);
		v3.setCartisian(5,2,1);
		
		vResult = ops.add(v1,v2,v3);
		
		assertTrue(v1.getX() == 2);
		assertTrue(v1.getY() == 4);
		assertTrue(v1.getZ() == 1);	
		
		assertTrue(v2.getX() == 1);
		assertTrue(v2.getY() == 5);
		assertTrue(v2.getZ() == 7);	
		
		assertTrue(v3.getX() == 5);
		assertTrue(v3.getY() == 2);
		assertTrue(v3.getZ() == 1);	
	}
	
	//dot(scalar) product (2 vectors)
	
	public void testTwoNullVectors(){
		result = ops.scalarProduct(null, null);
		assertTrue(result == 0);
	}
	public void testOneVectorNull(){
		
		result = ops.scalarProduct(v1,null);
		
		assertTrue(result == 0);
	}
	
	public void testScalarProduct(){
		v1.setCartisian(2,4,0);
		v2.setCartisian(1,5,0);
		
		result = ops.scalarProduct(v1,v2);
		
		// x1*x2 + y1*y2;
		assertTrue(result == (2*1)+(4*5));
	}
	
	// vector (cross product)
	public void testCrossProduct(){
		v1.setCartisian(2,4,0);
		v2.setCartisian(1,5,0);
		
		// x1*y2 - x2*y1;
		result = ops.crossProduct(v1,v2);
		assertTrue(result == (2*5)-(4*1));
	}
}
