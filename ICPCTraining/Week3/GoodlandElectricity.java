import java.util.*;

public class GoodlandElectricity{

    // https://www.hackerrank.com/challenges/pylons/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCity = input.nextInt();
        int distribution = input.nextInt();
        int[] sum = new int[numCity];
        Set<Integer> zeros = new HashSet<>();
        Map<Integer, Set<Integer>> relation = new HashMap<>();

        for (int i = 0; i < numCity; i++){
            int city = input.nextInt();

            if(city == 1) {
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

        if(bol){
            int counter = 0;
            while(counter <= numCity){
                int flag = -1;

                int head = counter-distribution+1;
                int tail = counter+distribution-1;
                if (head<0){
                    head = 0;
                }
                if(tail >= numCity){
                    tail = numCity-1;
                }

                for(int i = head; i <= tail; i++){
                    if (relation.containsKey(i)){
                        if (relation.get(i).contains(counter)){
                            flag = i;
                        }
                    }
                }
                if(flag == -1) {
                    bol = false;
                    break;
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