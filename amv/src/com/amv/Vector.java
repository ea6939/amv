package com.amv;

import java.util.ArrayList;
import java.util.List;


public class Vector {

	double x = 1,y = 0, z=0, theta, r, phi;
	List<Double> listCart = new ArrayList<Double>();
	List<Double> listSpher = new ArrayList<Double>();

	public void setX(double d) {
		// TODO Auto-generated method stub
	}

	public void setY(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setZ(double d) {
		// TODO Auto-generated method stub
		
	}
	
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCartisian(double x, double y, double z){
		
	}
	
	public List<Double> getCartesian(){
	
		listCart.add(x);
		listCart.add(y);
		listCart.add(z);
		return listCart;
		
	}
	
	
	public double getTheta() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getPhi() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Double> getSpherical(){
		
		listSpher.add(r);
		listSpher.add(theta);
		listSpher.add(phi);
		return listSpher;
	}
	/*
	public double getCartesianX(){
		return 0;
		
	}

	public double getCartesianZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getCartesianY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCartisianX(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setCartisianY(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setCartisianZ(double d) {
		// TODO Auto-generated method stub
		
	}
	*/


}
