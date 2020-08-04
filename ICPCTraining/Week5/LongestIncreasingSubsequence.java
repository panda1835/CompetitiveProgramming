package Week5;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] A = {0,-7,10,9,2,3,8,8,1};
        List<Integer[]> memo = new ArrayList<>(A.length); // memo[max length, reference]
        Stack<Integer> result = new Stack<Integer>();
        for (int i = 0; i < A.length; i++){
            memo.add(i, new Integer[2]);
        }
        memo.get(0)[0] = 0;

        int global_max = 0;
        int pos = 0;

        for (int i = 0; i < A.length; i++){
            memo.get(i)[1] = i;
            int max = -1;
            for (int j = 0; j < i; j++){
                if (A[j] < A[i] && memo.get(j)[0]+1 > max){
                    max = memo.get(j)[0]+1;
                    memo.get(i)[1] = j;
                }
            }
            memo.get(i)[0] = max;
            if (memo.get(i)[0] > global_max){
                pos = i;
            }
        }

        while(memo.get(pos)[1] != pos){
            result.add(A[pos]);
            pos = memo.get(pos)[1];
        }
        while(!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
        System.out.println();
    }
}