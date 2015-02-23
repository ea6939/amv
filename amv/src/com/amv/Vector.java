/*
 * amv calculator
 * ELITSA ASENOVA - 260481980, JUNYANG WANG - 260251358
 */
package com.amv;

import java.util.ArrayList;
import java.util.List;


public class Vector {

	double x = 0, y = 0, z = 0, theta = 0, r = 0, phi = 0;
	List<Double> listCart = new ArrayList<Double>();
	List<Double> listSpher = new ArrayList<Double>();

	 // create the zero vector of length N
    public Vector() {
    	
    }
	
    public Vector(double x, double y, double z) {
    	this.x = x;
		this.y = y;
		this.z = z;
		this.r = (double) (Math.sqrt(x*x + y*y + z*z));
		this.theta = Math.toDegrees(Math.acos(z / r));	
		this.phi = Math.toDegrees(Math.atan2(y, x));
    }
    
    public void setX(double x) {
		// TODO Auto-generated method stub
    	this.x = x;
    	this.r = (double) (Math.sqrt(x*x + y*y + z*z));
		this.theta = Math.toDegrees(Math.acos(z / r));	
		this.phi = Math.toDegrees(Math.atan2(y, x));
	}

	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
		this.r = (double) (Math.sqrt(x*x + y*y + z*z));
		this.theta = Math.toDegrees(Math.acos(z / r));	
		this.phi = Math.toDegrees(Math.atan2(y, x));
	}

	public void setZ(double z) {
		// TODO Auto-generated method stub
		this.z = z;
		this.r = (double) (Math.sqrt(x*x + y*y + z*z));
		this.theta = Math.toDegrees(Math.acos(z / r));	
		this.phi = Math.toDegrees(Math.atan2(y, x));
	}
    
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public double getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	public void setCartisian(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = (double) (Math.sqrt(x*x + y*y + z*z));
		this.theta = Math.toDegrees(Math.acos(z / r));	
		this.phi = Math.toDegrees(Math.atan2(y, x));
	}
	
	public List<Double> getCartesian(){
	
		listCart.add(x);
		listCart.add(y);
		listCart.add(z);
		return listCart;
		
	}
	
	
	public double getTheta() {
		// TODO Auto-generated method stub
		return theta;
	}

	public double getR() {
		// TODO Auto-generated method stub
		return r;
	}

	public double getPhi() {
		// TODO Auto-generated method stub
		return phi;
	}
	
	public List<Double> getSpherical(){
		
		listSpher.add(r);
		listSpher.add(theta);
		listSpher.add(phi);
		return listSpher;
	}

	public void convertToCartisian(double r2, double theta2) {
		// TODO Auto-generated method stub
		x = Math.cos(theta2) * r2;
		y = Math.sin(theta2) * r2;
	}

	public void convertToPolar(double x2, double y2) {
		// TODO Auto-generated method stub
		r = Math.sqrt( x2 * x2 + y2 * y2 );
		theta = Math.toDegrees(Math.atan2(y2, x2));
	}
	
	public String toString() {
        String s = "(" + x + ", " + y + ", " + z + ")";
        return s;
    }

}