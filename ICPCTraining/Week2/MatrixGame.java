package Week2;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MatrixGame {
    // codeforces.com/problemset/problem/1365/A
    /**
     * Ideas
     * 1 0 0 1 0 0    
     * 0 0 0 0 0 0    0 0 0 0
     * 1 0 0 0 0 0 -> 0 0 0 0
     * 0 0 0 0 0 0    0 0 0 0
     * 0 0 0 0 0 0
     * For each turns, no matter which cell the player claims, it can be transformed into
     * -> 0 0 0
     *    0 0 0
     * -> 0 0
     * After each turn, exactly one row and one column is invalid to claim
     * Stop when there is only 1 row or 1 column
     * In case 0 row or 0 column at the beginning, the 1st is absolutely lose
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for (int test = 0; test < numTests; test++){
            int numRow = input.nextInt();
            int numCol = input.nextInt();
            Set<Integer> row = new HashSet<>(); // store valid row
            Set<Integer> col = new HashSet<>(); // store valid column
        
            for (int i = 0; i < numRow; i++){
                row.add(i);
            }
            for (int i = 0; i < numCol; i++){
                col.add(i);
            }
            for (int i = 0; i < numRow; i++){
                for(int j = 0; j < numCol; j++){
                    if (input.nextInt() == 1){
                        if (col.contains(j)){
                            col.remove(j);
                        }
                        if (row.contains(i)){
                            row.remove(i);
                        }
                    }
                }
            }

            int counter = 0;
            int[] zeros = {row.size(), col.size()};
            if ((zeros[0] == 0) || (zeros[1] == 0)){ // no way at the first step
                counter = 1;
            }
            else{
                while((zeros[0] != 1) && (zeros[1] != 1)){ // eliminate each row after each iteration
                    zeros[0] -= 1;
                    zeros[1] -= 1;
                    counter ++;
                }
            }
            if (counter %2 == 1){
                System.out.println("Vivek");
            }
            else{
                System.out.println("Ashish");
            }
        }
        input.close();
    }
}