package Week2;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyFlorist {
    // hackerrank.com/challenges/greedy-florist/problem
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numFlowers = input.nextInt();
        int numPeople = input.nextInt();
        PriorityQueue<Integer> prices = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < numFlowers; i++){
            prices.add(input.nextInt());
        }
        int counter = 0;
        int answer = 0;
        while(!prices.isEmpty()){
            for (int i = 0; i < numPeople; i++){
                if (!prices.isEmpty()){
                    answer += (counter+1)*prices.poll();
                }
            }
            counter++;
        }
        input.close();
        System.out.println(answer);
    }    
}