package Week4;
 
import java.util.Arrays;
import java.util.Scanner;

public class Bonetrousle {
    // https://www.hackerrank.com/challenges/bonetrousle/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int numTest = 0; numTest < t; numTest++){
            long n = input.nextLong();
            long k = input.nextLong();
            int b = input.nextInt();

            
            long[] sticks = new long[b];
            long sum = 0;
            for (int i = 0; i < b; i++){
                sticks[i] = k - i;
                sum += k - i;
            }
            long left = sum - n;
            long hold = sticks[b-1];
            if (n <= sum){
                for (int i = b-1; i >=0; i--){
                    long temp = Math.min(hold - 1, left); 
                    sticks[i] -= temp;
                    left -= temp;
                    if(left == 0){
                        break;
                    }
                }
            }
            
            if (left > 0 || n > sum){
                System.out.println(-1);
            }
            else{
                for(int i = 0; i < b-1; i++){
                    System.out.print(sticks[i]+" ");
                }
                System.out.println(sticks[b-1]);
            }
        }

        input.close();
    }
}