import java.util.*;

public class GoodlandElectricity{

    // https://www.hackerrank.com/challenges/pylons/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numCity = input.nextInt();
        int distribution = input.nextInt();
        
        Map<Integer, Integer[]> relation = new HashMap<>();

        for (int i = 0; i < numCity; i++){
            int city = input.nextInt();

            if(city == 1) {
                if (!relation.containsKey(i)){
                    relation.put(i, new Integer[2]);
                }
                int low = i-distribution+1;
                int high = i+distribution-1;
                if (low<0){
                    low = 0;
                }
                if(high >= numCity){
                    high = numCity-1;
                }
                for (int j = low; j <= high; j++){
                    relation.get(i)[0] = low;
                    relation.get(i)[1] = high;
                }
            }
        }

        boolean bol = true;
        int ans = 0;

        if(bol){
            int counter = 0;
            while(counter < numCity){
                int flag = -1;

                int low = counter - distribution+1;
                int high = counter + distribution-1;
                if (low<0){
                    low = 0;
                }
                if(high >= numCity){
                    high = numCity-1;
                }

                for(int i = high; i >= low; i--){
                    if (relation.containsKey(i)){
                        if ((counter <= relation.get(i)[1]) && 
                        ((counter >= relation.get(i)[0]))){
                            flag = i;
                            break;
                        }
                    }
                }
                if(flag == -1) {
                    bol = false;
                    break;
                }
                ans++;
                counter = relation.get(flag)[1] + 1;
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