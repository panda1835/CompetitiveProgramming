import java.util.*;

public class GoodlandElectricity{

    // https://www.hackerrank.com/challenges/pylons/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCity = input.nextInt();
        int distribution = input.nextInt();
        int a = 0;
        int[] sum = new int[numCity];
        Set<Integer> zeros = new HashSet<>();
        Map<Integer, Set<Integer>> relation = new HashMap<>();

        for (int i = 0; i < numCity; i++){
            int city = input.nextInt();
            if (city == 0){
                zeros.add(i);
            }
            else{
                if (!relation.containsKey(i)){
                    relation.put(i, new HashSet<Integer>());
                }
                int head = i-distribution+1;
                int tail = i+distribution-1;
                if (head<0){
                    head = 0;
                }
                if(tail >= numCity){
                    tail = numCity-1;
                }
                for (int j = head; j <= tail; j++){
                    relation.get(i).add(j);
                    sum[j] ++;
                }
            }
        }

        boolean bol = true;
        int ans = 0;
        for(int i:zeros){
            if (sum[i] == 0){
                bol = false;
                break;
            }
        }

        if(bol){
            int counter = 0;
            int flag = 0;
            while(counter <= numCity){
                for(int i = 0; i < numCity; i++){
                    if (relation.containsKey(i)){
                        if (relation.get(i).contains(counter)){
                            flag = i;
                        }
                    }
                }
                ans++;
                int precounter = counter;
                for(int i = flag; i < numCity; i++){
                    if (!relation.get(flag).contains(i)){
                        counter = i;
                        break;
                    }
                }
                if (precounter == counter) break;  
            }
        }
        
        if(bol){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
        
        input.close();
    }
    
}