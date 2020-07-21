package Week2;

import java.util.Scanner;
import java.lang.Math;

public class GreedyPolygons {
    // open.kattis.com/problems/greedypolygons
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for (int test = 0; test < numTests; test++){
            int n = input.nextInt();
            int l = input.nextInt();
            int d = input.nextInt();
            int g = input.nextInt();
            double answer = area(n,l); // original area
            answer += 1.*n*circularSector(d*g, 180-1.*(n-2)*180/n); // additional circular sectors 
            answer += 1.*n*d*g*l; // additional rectangles
            System.out.println(answer);
        }
        input.close();
    }
    /**
     * Compute Area of a n-regular polygon with side l
     * @param n number of vertices
     * @param l length of edge
     * @return Area of n-polygon side l
     */
    public static double area(int n, int l){
        double angle = 1.*(n-2)*180/n;
        double radius = 1.*l/2*Math.tan(Math.toRadians(angle/2));
        double area = .5*radius*l*n;
        return area;
    }

    /**
     * Compute the circular sector created by 2 radius which form an angle phi
     * @param radius size of radius
     * @param phi the centric angle
     * @return the area of the circular sector
     */
    public static double circularSector(int radius, double phi){
        double partial = phi/360;
        return partial*radius*radius*Math.PI;
    }
}