package mmaia.amazon.closestpoints.integers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This is a well known and documented problem and basically there's 2 accepeted approaches to solve that, brute force and divide and quonquer.
 * The brute force approach, as the name states, will compare each one of the points with each other and it ends with the closest 2. This implementation
 * in java its trivial as java has a java.awt.Point object that already provides a method to compare distances.
 * The second well known approach to this problem would be to divide the collection of points in 2 groups sorted by x(horizontal) and y(vertical) and than 
 * process oly the best candidates sorting them during each comparsion round. 
 * //TODO - COMPLETE THEORY HERE IF I HAVE THE TIME.  
 */
public class Solution {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * this is a brute force implementation, will compare all points with each other and get the closest ones as the result. It's probably more efficient 
	 * in situations where only a few points need to be compared if there's a lot of points the best known approach would be to divide sort and compare.
	 */
	public final static ClosestPoint compareAllBrute(List<Point> points){
		ClosestPoint result = new ClosestPoint();
		//temp holder for the minimum distance.
		double tempMinimumDistance = Double.MAX_VALUE;
		
		//nested for to compare each element in the collection.
		for (Point pointA : points) {
			for(Point pointB: points){
				//check if not comparing same points on the list
				if(pointA != pointB){
					tempMinimumDistance = pointA.distance(pointB);
					//compare current distance from ClosestPoint if it's higher than the one being compared update ClosestPoint object to be returned.
					if(result.getDistance() > tempMinimumDistance){
						result.setDistance(tempMinimumDistance);
						result.setPointA(pointA);
						result.setPointB(pointB);
					}
				}	
			}
		}
		return result;
	}
	
	/**
	 * If an array is passed just wraps the transformation to list and delegates to the implementation that receives a List to resolve.
	 * @param points as an array os Points
	 * @return the ClosestPoint object holding the 2 closest points
	 */
	public final static ClosestPoint compareAllBrute(Point[]points){
		List<Point> pointsList = Arrays.asList(points);
		return compareAllBrute(pointsList);
	}	
	
	
	/**
	 * Method that uses the full list and filters it based on the best possible options left after applying the sort on the list
	 * @param points to be filtered
	 * @return a list with only the best possibilities to be compared.
	 */
	public List<Point> leaveOnlyBestOptions(List<Point> points){
		List<Point> result = new ArrayList<Point>();
		
		//TODO - implement this if have time.
		throw new UnsupportedOperationException("Sorry, not yet implemented.");
//		return result;
	}
	
	
}//Ends Solution.java implementation

/**
 * Class that will hold the closest point
 * @author mmaia
 *
 */
class ClosestPoint{
	private Point pointA;  
	private Point pointB;
	private double distance;
	
	public ClosestPoint(){
		pointA = new Point();
		pointB = new Point();
		
		//initializes distance to the biggest so can be used to compare while processing.
		distance = Double.MAX_VALUE;
	}
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	} 
	
	/**
	 * Sorts list of Points by x axis.
	 * @param listToSort
	 * @return the sorted list by x axis.
	 */
	public static List<Point> sortWithComparatorByXAxis(List<Point> listToSort){
		//decided to create a new list so if sorting by Y also happens doesn't risk pointer
		//TODO - need to evaluate this better.
		List<Point> result = new ArrayList<Point>(listToSort);
		
		//if using java 8 could possibly replace the inner class by lambda :) 
		Collections.sort(result, new Comparator<Point>() {
	        public int compare(Point pointA, Point pointB){
	          int result = 0;
	          if (pointA.getX() < pointB.getX()){
	        	  result = -1;  
	          }
	          if (pointA.getX() > pointB.getX()){
	        	  result = 1;  
	          }
	          return result;
	        }
	      }
	    );//end sort with inner class implementation.
		
		return result;
	}
}