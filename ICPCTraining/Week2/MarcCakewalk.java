package Week2;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;

public class MarcCakewalk{
    // hackerrank.com/challenges/marcs-cakewalk/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numberOfCake = input.nextInt();
        Integer[] cakes = new Integer[numberOfCake];
        for (int i = 0; i < numberOfCake; i++){
            cakes[i] = input.nextInt();
        }

        Arrays.sort(cakes, Collections.reverseOrder());

        long answer = 0;
        for (int i = 0; i < numberOfCake; i++){
            answer += (long)Math.pow(2, i)*cakes[i]; 
        }
        input.close();
        System.out.println(answer);
    }
}