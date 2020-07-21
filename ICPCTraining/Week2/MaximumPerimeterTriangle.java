package Week2;
import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumPerimeterTriangle {
    // hackerrank.com/challenges/maximum-perimeter-triangle/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numSticks = input.nextInt();
        PriorityQueue<Integer> sticks = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < numSticks; i++){
            sticks.add(input.nextInt());
        }
        int a,b,c;
        b = sticks.poll();
        c = sticks.poll();
        boolean answer = false;

        while(!sticks.isEmpty()){
            a = b;
            b = c;
            c = sticks.poll();
            if((a+b>c) && (b+c>a) && (c+a>b)){
                System.out.println(c+" "+b+" "+a);
                answer = true;
                break;
            }
        }
        input.close();
        if (!answer){
            System.out.println(-1);
        }
        
    }
    
}