package Week5;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] A = {2,3,-7,5,6,7,10,9,2,3,8,8,1};
        List<int[]> memo = new ArrayList<>(A.length); // memo[max length, reference]
        Stack<Integer> result = new Stack<Integer>();

        // Initialization:
        // each element has init reference points to itself
        // first element has 1 max length which tailed by it
        for (int i = 0; i < A.length; i++){
            int[] a = {1,i}; 
            memo.add(i, a);
        }

        int global_max = 0; // max length across the whole array
        int pos = 0; // position of the next element in result the sequence

        // Start with the second element
        for (int i = 1; i < A.length; i++){
            int max = 1; // local maximum on max length of elements before i
            for (int j = 0; j < i; j++){
                if (A[j] < A[i] && memo.get(j)[0]+1 > max){
                    max = memo.get(j)[0]+1;
                    memo.get(i)[1] = j; // reference element i-th to j-th
                    memo.get(i)[0] = max;
                }
            }
            
            if (max > global_max) global_max = max;
            if (memo.get(i)[0] == global_max){
                pos = i;
            }
        }

        // Write the sequence to a Stack
        while (true){
            result.add(A[pos]);
            pos = memo.get(pos)[1];

            if (memo.get(pos)[1] == pos){
                result.add(A[pos]);
                break;
            }
        }

        while(!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
        System.out.println();
    }
}