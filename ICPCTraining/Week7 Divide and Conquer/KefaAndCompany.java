import java.util.*;

public class KefaAndCompany{

    // http://codeforces.com/problemset/problem/580/B
    
    static Map<Integer, Long> friendMap = new HashMap<>();
    
    static int d;
    static long maxFriendFactor = 0;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        d = input.nextInt();
        friendMap = new HashMap<>();
        
        for (int i = 0; i < n; i++){
            int m = input.nextInt();
            int s = input.nextInt();
            if (friendMap.keySet().contains(m)){
                friendMap.put(m, friendMap.get(m) + s);
            }
            else{
                friendMap.put(m, (long)s);
            }
        }
    
        List<Integer> moneyList = new ArrayList<>();
        for (int i: friendMap.keySet()){
            moneyList.add(i);
        }
        
        Collections.sort(moneyList); 
        
        for(int lower = 0; lower < moneyList.size(); lower++){
    
            long sum = 0;
            int upper = binarySearchLeast(lower, moneyList);
            for (int i = lower; i < upper+1; i++){
                sum += friendMap.get(moneyList.get(i));
            }
            if (maxFriendFactor < sum){
                maxFriendFactor = sum;
            }
        }

        System.out.println(maxFriendFactor);
        input.close();
    }


    /**
     * lower = 2, d = 10
     * [1,2,3,4,5,6,7,8,9,10,11,12,13,14] -> [3..12] -> return 11
     * 
     * @param moneyList list of friends money in increasing order
     * @param lower the current examined friend
     * @return the index of the highest number that is no more than d-difference
     * from number at lowerbound index
     */
    public static int binarySearchLeast(int lower, List<Integer> moneyList){
        int max = lower + d;
        int lo = lower;
        int hi = moneyList.size()-1;
        while (lo<hi-1){
            int mid = (int) Math.floor((lo+hi)/2);
            if (moneyList.get(mid) < max){
                lo = mid;
            }
            else{
                hi = mid;
            }
        }
        if (moneyList.get(hi) > max){
            return lo;
        }
        return hi;
    }


}