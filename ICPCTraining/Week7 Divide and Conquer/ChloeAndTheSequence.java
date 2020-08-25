import java.util.*;
public class ChloeAndTheSequence{

    // http://codeforces.com/problemset/problem/743/B
    /**
     * Insight: The 2 halves are equal, seperated by a number at index
     * 2**(n-1), thus I only need to check the left half by decrease k as its 
     * remainder by modulo with 2**(n-1) iteratively.
     * The iteration stops when the index k is a power of 2, 
     * for instance 2**m, and its value is m+1.
     * 
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long k = input.nextLong();

        while(!powerOf2(k)) {
            k %= (long) Math.pow(2,n-1);
            n -= 1;
        }

        System.out.println((int)(Math.log(k)/Math.log(2))+1);
        input.close();
    }

    /**
     * Check a number a power of 2
     * @param k number for check
     * @return true if k is a power of 2
     */
    public static boolean powerOf2(long k){
        while(k != 1){
            if (k%2==0){
                k /= 2;
            }
            else{
                return false;
            }
        }
        return true;
    }
}