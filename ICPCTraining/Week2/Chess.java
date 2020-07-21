package Week2;

import java.util.Scanner;

public class Chess {
    // open.kattis.com/problems/chess
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for (int test = 0; test < numTests; test++){
            int []pos1 = {(int)input.next().charAt(0), input.nextInt()};
            int []pos2 = {(int)input.next().charAt(0), input.nextInt()};
            int []pos3 = new int[2];
            int []pos4 = new int[2];
            if ((pos1[0]+pos1[1]+pos2[0]+pos2[1])%2 != 0){
                System.out.println("Impossible");
            }
            
            // follow the main diagonal
            // pos1 -> pos3 -> pos4 -> pos2
            else{
                pos3 = newPos(pos1);
                pos4 = newPos(pos2);
                int counter = 0;
                String answer = " "+(char)pos1[0]+" "+pos1[1];

                if ((pos1[0] != pos3[0]) && (pos1[1] != pos3[1])){
                    answer += " "+(char)pos3[0]+" "+pos3[1];
                    counter ++;
                }
                if ((pos3[0] != pos4[0]) && (pos3[1] != pos4[1])){
                    answer += " "+(char)pos4[0]+" "+pos4[1];
                    counter++;
                }
                if ((pos4[0] != pos2[0]) && (pos4[1] != pos2[1])){
                    answer += " "+(char)pos2[0]+" "+pos2[1];
                    counter++;
                }
                System.out.println(counter+answer); 
            }
        }
        input.close();
    }
    public static int[] newPos(int[] pos){
        int[] result = new int[2];
        int row = pos[0] - 'A' + 1;
        int col = pos[1];
        if ((row+col) %2 == 0){ // black
            result[0] = (row+col)/2 + 'A' - 1;
            result[1] = (row+col)/2;
        }
        else{ // white
            result[0] = (row - col + 9)/2 + 'A' - 1;
            result[1] = (9 - row + col)/2;
        }
        return result;
    }

}