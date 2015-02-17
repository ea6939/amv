package com.amv;

import junit.framework.TestCase;

public class VectorTest extends TestCase {

	private Vector v;
	
	protected void setUp() throws Exception {
		super.setUp();
		v = new Vector();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInitZero(){
		assertTrue("x not 0 at initialization", v.getX() == 0.0);
		assertTrue("y not 0 at initialization", v.getY() == 0.0);
		assertTrue("z not 0 at initialization", v.getZ() == 0.0);
		assertTrue("r not 0 at initialization", v.getR() == 0.0);
		assertTrue("theta not 0 at initialization", v.getTheta() == 0.0);
		assertTrue("phi not 0 at initialization", v.getPhi() == 0.0);
		
	}
	
	public void testXSetter(){
		v.setX(5.5);
		assertTrue(v.getX() == 5.5);
		assertTrue(v.getY() == 0);
		assertTrue(v.getZ() == 0);
		assertTrue(v.getR() == 1);
		assertTrue(v.getTheta() == 90);
		assertTrue(v.getPhi() == 0);
		
	}
	
	public void testYSetter(){
		v.setY(2);
		assertTrue(v.getX() == 0);
		assertTrue(v.getY() == 2);
		assertTrue(v.getZ() == 0);
		assertTrue(v.getR() == 1);
		assertTrue(v.getTheta() == 90);
		assertTrue(v.getPhi() == 90);
		
	}
	
	public void testZSetter(){
		v.setZ(1);
		assertTrue(v.getX() == 0);
		assertTrue(v.getY() == 0);
		assertTrue(v.getZ() == 1);
		assertTrue(v.getR() == 1);
		assertTrue(v.getTheta() == 0);
		assertTrue(v.getPhi() == 0);
		
	}
	
	public void testCartesianGetter(){
		v.setX(1);
		v.setY(1.5);
		v.setZ(2.5);
		
		assertTrue(v.getX() == v.getCartesianX());
		assertTrue(v.getY() == v.getCartesianY());
		assertTrue(v.getZ() == v.getCartesianZ());
		
	}


	public void testCartisianSetter(){
		v.setCartisianX(1.5);
		v.setCartisianY(2.5);
		v.setCartisianZ(3.5);
		
		assertTrue(v.getCartesianX() == 1.5);
		assertTrue(v.getCartesianY() == 2.5);
		assertTrue(v.getCartesianZ() == 3.5);
		
		assertTrue(v.getCartesianX() == v.getX());
		assertTrue(v.getCartesianY() == v.getY());
		assertTrue(v.getCartesianZ() == v.getZ());
	}
	
	public void testSpherical(){
		v.setCartisianX(1);
		v.setCartisianY(2);
		v.setCartisianZ(1);
		
		// where radius = sqrt(x*X + y*y + z*z)
		assertTrue(v.getRadius() == Math.sqrt(6));
		
		// where theta = radiansToDegrees(acos(z / r))
		assertTrue(v.getTheta() == Math.toDegrees(Math.acos(1/(Math.sqrt(6)))));
		
		// where phi = radiansToDegrees(atan2(y, x))
		assertTrue(v.getPhi() == Math.toRadians(Math.atan2(2,1)));
	}
	
	
	
}
