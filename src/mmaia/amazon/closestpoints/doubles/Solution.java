package mmaia.amazon.closestpoints.doubles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a well known and documented problem and basically there's 2 accepted approaches + a multithreaded one to solve it, brute force and a faster sort by axis and than compare only the best options.
 * The brute force approach, as the name states, will compare each one of the points with each other and it ends with the closest 2. This implementation
 * in java its trivial if using only integers and x and y as java has a java.awt.Point object that already provides a method to compare distances. If not we need to implement 
 * our own Point class with a calcDistance method based on a mathematical equation to define the distance between points.
 * 
 * The second well known approach to this problem would be to sort the points by it's x or y axis and than process only the ones with possible minimum distance based on 
 * one of the axis. This usually limits considerably the number of possible target points to be compared and works better if there's a big number of points to be compared.
 * 
 * There would be an even more efficient approach if using a multithreaded environment where the list of points to be compared could be divided in n threads
 * and each thread process it's own list in parallel and than at the end just compare the best result from each thread to find the closest one.
 *  
 *  I decided implementing first the brute force approach as the time is very short and at least I can be sure it will pass the test. I don't think I will have the time to finish the full implementation
 *  of the faster approach, but I will at least leave a skeleton of what would be my solution for that.
 *  
 *  I'd like to quote Fowler from his classic Refactoring book here. "Any fool can write code that a computer can understand, good programmers write code that humans can understand!". 
 *  
 *  Also Joshua Bloch in his classic Effective Java book mention in one of the chapters(can't remember exactly which chapter) many aphorisms from different authors where they basically states that we should write 
 *  good programs rather than fast ones. Of course there's exceptions but I would allways favor first the easy and more readable implementation, write the test cases to that to than, if needed in a particular case, 
 *  implement the faster code and make sure this more complex and faster approach is still valid against the test cases we wrote before, that would be the correct approach to improve the performance of an algorithm.
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
					tempMinimumDistance = pointA.calcDistance(pointB);
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
 * Point implementation that has double digits for x an y
 * @author mmaia
 */
class Point{
	private double x;
	private double y;
	
	//Implements standard math expression to calc. 2 points distance.
	public double calcDistance(Point point){
		double result = Double.MIN_VALUE;
		result = Math.sqrt( 
					(this.x - point.getX()) * (this.x - point.getX()) + 
					(this.y - point.getY()) * (this.y - point.getY()) 
				); 
		return result;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

/**
 * Class that will hold the closest point and will be used during processing to hold distances.
 * TODO - Might need a distance property, add if required
 * @author mmaia
 *
 */
class ClosestPoint{
	private Point pointA;  
	private Point pointB;
	private double distance;
	
	public ClosestPoint(){
		//initializes to 0,0
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