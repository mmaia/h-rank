package mmaia.amazon;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Solution {
  private static class AMZNPoint {
    AMZNPoint(double x, double y) {
      this.x = x;
      this.y = y;
    }
    private double x;
    private double y;

    public String toString() {
      DecimalFormat df = new DecimalFormat("#0.0000");
      return df.format(x) + " " + df.format(y);
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

  public static void main(String[] args) {
    test();

    Scanner in = new Scanner(System.in);

    int n = in.nextInt();

    double refX = in.nextDouble();
    double refY = in.nextDouble();
    AMZNPoint ref = new AMZNPoint(refX,refY);

	int universeSize = in.nextInt();
    List<AMZNPoint> universe = new ArrayList<AMZNPoint>();

    while(in.hasNextDouble()) {
      double newX = in.nextDouble();
      if(!in.hasNextDouble()) {
        throw new RuntimeException("Invalid Input");
      }
      double newY = in.nextDouble();

      universe.add(new AMZNPoint(newX, newY));
    }

    List<AMZNPoint> closestPoints = getClosestPoints(n, ref, universe);

    for(AMZNPoint p : closestPoints) {
      System.out.println(p);
    }
  }

  private static List<AMZNPoint> getClosestPoints(int n, AMZNPoint ref, List<AMZNPoint> universe) {
	  //holds the list of closest points.
	  List<AMZNPoint> result = new ArrayList<AMZNPoint>(n);
	  List<ClosestPoint> clPoint = new ArrayList();
	  ClosestPoint cp = null;
	  //doing brute force first, compare each element in universe and calculate distance.
	  for (AMZNPoint amznPoint : universe) {
		  //creates objects ClosestPoint to than sort, after that keep only the n closest ones
		  cp = new Solution().new ClosestPoint();
		  cp.setPointA(ref);
		  cp.setPointB(amznPoint);
		  clPoint.add(cp);
	}
	 
	  clPoint = cp.sortWithComparatorAscending(clPoint);
	  clPoint = clPoint.subList(0, n);
	  
	  //couldn't finish.. the idea would be to keep only the n closest points and than extract them and add to the result list that would be returned.
	  for (ClosestPoint closestPoint : clPoint) {
		result.add(closestPoint.getPointB());
	}
	 //now add the ref which is a pointA in all ClosestPoints
	 result.add(clPoint.get(0).getPointA());
	 return result;
  }
  
  

  private static void test() {
    /* Add your test code here */
    /* Ensure that your test cases do not print to stdout when submitting */
    /* your final code as this will break the automated testing */
  }
  
  class ClosestPoint{
		private AMZNPoint pointA;  
		private AMZNPoint pointB;
		private double distance;
		
		public ClosestPoint(){
			distance = Double.MAX_VALUE;
		}
		
		public AMZNPoint getPointA() {
			return pointA;
		}
		public void setPointA(AMZNPoint pointA) {
			this.pointA = pointA;
		}
		public AMZNPoint getPointB() {
			return pointB;
		}
		public void setPointB(AMZNPoint pointB) {
			this.pointB = pointB;
		}
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		
		
		/**
		    **Implements standard math expression to calc. 2 points distance, this with another one passed as parameter
			**/
		    public double calcDistance(){
				double result = Double.MIN_VALUE;
				result = Math.sqrt( 
							(pointA.x - pointB.x) * (pointA.x - pointB.x) + 
							(pointA.y - pointB.y) * (pointA.y - pointB.y) 
						); 
				return result;
			}
		
		/**
		 * Sorts list of Points by distance, implements inner comparator instead of Comparable so I don't have to change class signature as I am not sure if it's allowed.
		 * @param listToSort
		 * @return the sorted list by distance.
		 */
		public List<ClosestPoint> sortWithComparatorAscending(List<ClosestPoint> listToSort){
			//decided to create a new list so I don't risk cross reference //TODO - need to evaluate this better if I have time
			List<ClosestPoint> result = new ArrayList<ClosestPoint>(listToSort);
			
			//if using java 8 could possibly replace the inner class by lambda :) 
			Collections.sort(result, new Comparator<ClosestPoint>() {
		        public int compare(ClosestPoint closestPointA, ClosestPoint closestPointB){
		          int result = 0;
		          if(closestPointA.calcDistance() < closestPointB.calcDistance()){
		        	  result = -1;
		          }
		          else if(closestPointA.calcDistance() > closestPointB.calcDistance()){
		        	  result = 1;
		          }
		          
		          return result;
		        }
		      }
		    );//end sort with inner class implementation.
			return result;
		}
  }
  
}