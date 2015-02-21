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

	public void testInitZero(){
		assertTrue(v.getX() == 0.0);
		assertTrue(v.getY() == 0.0);
		assertTrue(v.getZ() == 0.0);
		assertTrue(v.getR() == 0.0);
		assertTrue(v.getTheta() == 0.0);
		assertTrue(v.getPhi() == 0.0);
		
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
	
	
	public void testSpherical(){
		
		ArrayList<Double> listSpher = new ArrayList<Double>();
		v.setCartisian(1.0,2.0,1.0);
		
		// where radius = sqrt(x*X + y*y + z*z)
		assertTrue(v.getR() == Math.sqrt(6));
		
		// where theta = radiansToDegrees(acos(z / r))
		assertTrue(v.getTheta() == Math.toDegrees(Math.acos(1/(Math.sqrt(6)))));
		
		// where phi = radiansToDegrees(atan2(y, x))
		assertTrue(v.getPhi() == Math.toDegrees(Math.atan2(2,1)));
		
		listSpher = (ArrayList<Double>) v.getSpherical();
		assertTrue(listSpher.get(0) == Math.sqrt(6));
		assertTrue(listSpher.get(1) == Math.toDegrees(Math.acos(1/(Math.sqrt(6)))));
		assertTrue(listSpher.get(2) == Math.toRadians(Math.atan2(2,1)));
	}
	
	public void testPolartoCartesian(){
		
		double x = 1;
		double y = 1;
		double theta = 90;
		double r = Math.sqrt(2);
		
		v.convertToCartisian(r, theta);
		assertTrue(x == v.getX());
		assertTrue(y == v.getY());
	}
	
	public void testCartesianToPolar(){
		
		double x = 1;
		double y = 1;
		double theta = 90;
		double r = Math.sqrt(2);
		
		v.convertToPolar(x, y);
		assertTrue(r == v.getR());
		assertTrue(theta == v.getTheta());
	}
}
