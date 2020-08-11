package Week5;

import java.util.*;
public class Knapsack{
    public static int numItem;
    public static int maxWeight;

    public static int[] w; // weight array
    public static int[] v; // value array
    // public static int[][] memo = new int[40][(int)1e9];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        numItem = input.nextInt();
        maxWeight = input.nextInt();

        w = new int[numItem]; // weight array
        v = new int[numItem]; // value array
        // memo = new int[40][(int)1e9];
        for(int i = 0; i < numItem;i++){
            w[i] = input.nextInt();
            v[i] = input.nextInt();
        }
        System.out.println(val(0, maxWeight));
    }

    public static int val(int id, int remW){
        if (remW == 0 && id > 0){
            return 0;
        }
        if (id == numItem){
            return 0;
        }
        if (w[id] > remW){
            return val(id + 1, remW);
        }
        else{
            return Math.max(val(id+1, remW), v[id] + val(id+1, remW-w[id]));
        }
    }
}