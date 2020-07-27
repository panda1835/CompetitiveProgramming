import java.util.*;

public class CloudyDay {
    // https://www.hackerrank.com/challenges/cloudy-day/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        // --------------------------------------
        int numCity = input.nextInt();
        int[] cityPopulation = new int[numCity];
        // city[location][population]
        // ArrayList<int[][]> city = new ArrayList<>();
        for (int i = 0; i < numCity; i++){
            cityPopulation[i] = input.nextInt();
        }
        int[] cityLocation = new int[numCity];
        for (int i = 0; i < numCity; i++){
            cityLocation[i] = input.nextInt();
        }

        int numCloud = input.nextInt();
        int[] cloudRange = new int[numCloud];
        int[] cloudLocaion = new int[numCloud];
        for (int i = 0; i < numCloud; i++){
            cloudLocaion[i] = input.nextInt();
        }
        for (int i = 0; i < numCloud; i++){
            cloudRange[i] = input.nextInt();
        }
        // --------------------------------------
        ArrayList<Integer> cityMap = new ArrayList<>();
        for (int i = 0; i < numCity; i++){
            cityMap.add(cityLocation[i], cityPopulation[i]);
        }
        ArrayList<Integer> cloudMap = new ArrayList<>();
        for (int i = 0; i < numCloud; i++){
            cloudMap.add(cloudLocaion[i], 1);
            for (int j = cloudLocaion[i] - cloudRange[i]; 
                    j <= cloudLocaion[i] + cloudRange[j]; j++){
                cloudMap.add(j,1);
            }
        }

        int max = 0;
        long ans = 0;
        for (int i = 0; i < numCity; i++){
            if (cloudMap.get(cityLocation[i]) != 1){
                ans += cityLocation[i];
            }
        }



        System.out.println(ans);
        input.close();
    }
}