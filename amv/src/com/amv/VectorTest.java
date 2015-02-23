/*
 * amv calculator
 * ELITSA ASENOVA - 260481980, JUNYANG WANG - 260251358
 */
package com.amv;

import java.util.ArrayList;

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
	
	// test the setters for x, y and z
	public void testXSetter(){
		v.setX(1);
		assertTrue(v.getX() == 1);
		
	}
	
	public void testYSetter(){
		v.setY(2);
		assertTrue(v.getY() == 2);
	}
	
	public void testZSetter(){
		v.setZ(1);
		assertTrue(v.getZ() == 1);
	}
	
	// test cartesian getter to return an array list (x,y,z)
	public void testCartesianGetter(){
		
		ArrayList<Double> listTestCar = new ArrayList<Double>();
		
		v.setX(1);
		v.setY(1.5);
		v.setZ(2.5);
		double x = v.getX();
		double y = v.getY();
		double z = v.getZ();
		
		listTestCar = (ArrayList<Double>) v.getCartesian();
		assertTrue(x == listTestCar.get(0));
		assertTrue(y == listTestCar.get(1));
		assertTrue(z == listTestCar.get(2));
		
	}

	// test cartesian setter to return initialize a vector in
	// the form of an array list (x,y,z)
	public void testCartisianSetter(){
		
		ArrayList<Double> listTestCar1 = new ArrayList<Double>();
		v.setCartisian(1,2,3);
		
		listTestCar1 = (ArrayList<Double>) v.getCartesian();
		
		assertTrue(listTestCar1.get(0) == 1);
		assertTrue(listTestCar1.get(1) == 2);
		assertTrue(listTestCar1.get(2) == 3);
		
		assertTrue(listTestCar1.get(0) == v.getX());
		assertTrue(listTestCar1.get(1) == v.getY());
		assertTrue(listTestCar1.get(2) == v.getZ());
	}
	
	// test getters of spherical coordinates r, theta and phi
	// test arraylist getter for the spherical coord (r,theta,phi)
	public void testSpherical(){
		
		ArrayList<Double> listSpher = new ArrayList<Double>();
		v.setCartisian(1.0,2.0,1.0);
		double r = v.getR();
		//System.out.println(r);
		// where radius = sqrt(x*X + y*y + z*z)
		assertTrue(v.getR() == Math.sqrt(6));
		
		// where theta = radiansToDegrees(acos(z / r))
		assertTrue(v.getTheta() == Math.toDegrees(Math.acos(1/(Math.sqrt(6)))));
		
		// where phi = radiansToDegrees(atan2(y, x))
		assertTrue(v.getPhi() == Math.toDegrees(Math.atan2(2,1)));
		
		listSpher = (ArrayList<Double>) v.getSpherical();
		assertTrue(listSpher.get(0) == Math.sqrt(6));
		assertTrue(listSpher.get(1) == Math.toDegrees(Math.acos(1/(Math.sqrt(6)))));
		assertTrue(listSpher.get(2) == Math.toDegrees(Math.atan2(2,1)));
		
	}
	
	// test conversion from polar to cartesian coordinates
	public void testPolartoCartesian(){
	
		double theta = 90;
		double r = Math.sqrt(1);
		double x = Math.cos(theta) * r;
		double y = Math.sin(theta) * r;
		
		v.convertToCartisian(r, theta);
		assertTrue(x == v.getX());
		assertTrue(y == v.getY());
	}
	
	
	// test conversion from cartesian coordinates
	public void testCartesianToPolar(){

		double x = 1;
		double y = 1;
		double r = Math.sqrt( x * x + y * y );
		double theta = Math.round(Math.toDegrees(Math.acos(x / r)));	
	
		v.convertToPolar(x, y);
		
		System.out.println(r);
		System.out.println(theta);
		System.out.println(v.getR());
		System.out.println(v.getTheta());
	
		assertTrue(r == v.getR());
		assertTrue(theta == v.getTheta());
	}
	
}
