package Week1;

import java.util.Scanner; 
import java.lang.Math;

public class TrollHunt{
    // open.kattis.com/problems/trollhunt
    public static void main(String[] args){
        int b,k,g;
        Scanner input = new Scanner(System.in);
        b = input.nextInt()-1; //minus the original bridge
        k = input.nextInt();
        g = input.nextInt();

        System.out.println((int)Math.ceil(1.*b/(k/g)));
        input.close();

    }
}