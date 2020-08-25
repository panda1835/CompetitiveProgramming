
import java.util.*;
public class VONNY{
    //  https://www.spoj.com/problems/VONNY/
    static final int[][] dominos = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},
                                    {1,1},{1,2},{1,3},{1,4},{1,5},{1,6},
                                   {2,2},{2,3},{2,4},{2,5},{2,6},
                                         {3,3},{3,4},{3,5},{3,6},
                                               {4,4},{4,5},{4,6},
                                                     {5,5},{5,6},
                                                           {6,6}};
    static final int[] direction = {'r','d'};
    static int[][] validBox;
    static int[][] validDominos;
    static int[][] box;
    static int counter = 0;

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int numTests = input.nextInt();
        for (int test = 0; test < numTests; test++){
            counter = 0;
            box = new int[7][8];
            validBox = new int[7][8];
            validDominos = new int[7][7];
            // read box
            for (int i = 0; i < 7; i++){
                for (int j = 0; j < 8; j++){
                    box[i][j] = input.nextInt();
                }
            }
            int[] pos = {0,0};
            solve(pos);
            System.out.println(counter);  
        }
        input.close();
    }

    public static void solve(int[] pos){
        int row = pos[0];
        int col = pos[1];
        if (complete(validDominos)){
            counter++;
            return;
        }
        else{
            validBox[row][col] = 1;
            if(fill('r', pos)){
                // System.out.println(Arrays.toString(next(pos, validBox)));
                solve(next(pos, validBox));
                unfill('l', pos);
            }
            
            if(fill('d', pos)){
                // System.out.println(Arrays.toString(next(pos, validBox)));
                solve(next(pos, validBox));
                unfill('u', pos);
            }
            
            else{
                return;
            }
        }
    }

    public static int[] next(int[] pos, int[][] validBox){
        int[] nextPos = new int[2];
        int nextRow = pos[0];
        int nextCol = pos[1];
        do{
            if (nextCol >= 7){
                nextCol = 0;
                nextRow++;
            }
            else{
                nextCol++;
            }
        } while (validBox[nextRow][nextCol] == 1);   
        nextPos[0] = nextRow;
        nextPos[1] = nextCol;
        System.out.println("next "+Arrays.toString(nextPos));
        return nextPos;
    }

    public static boolean complete(int[][] validDominos){
        for (int i = 0; i  < 7; i++){
            for (int j = 0 ; j < 8; j++){
                if (validDominos[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean fill(char direction, int[] pos){
        int row = pos[0];
        int col = pos[1];
        if(direction == 'r'){
            if(col >=7) return false;
            if(validBox[row][col+1] == 1) return false;
            else{
                int left  = box[row][col];
                int right = box[row][col+1];
                // System.out.println(left+" "+right);
                if(validDominos[left][right] == 1) return false; // already taken
                else{
                    validDominos[left][right] = 1;
                    validDominos[right][left] = 1;
                    validBox[row][col+1] = 1;
                    return true;
                }
            }
        }
        if(direction == 'd'){
            if(row >=6) return false;
            if(validBox[row+1][col] == 1) return false;
            else{
                int up  = box[row][col];
                int down = box[row+1][col];
                if(validDominos[up][down] == 1) return false; // already taken
                else{
                    validDominos[up][down] = 1;
                    validDominos[down][up] = 1;
                    validBox[row+1][col] = 1;
                    return true;
                }
            }
        }
        
        return true;
    }

    public static void unfill(char direction, int[] pos){
        int row = pos[0];
        int col = pos[1];
        if(direction == 'u'){
            validBox[row+1][col] = 0;
        }
        if(direction == 'l'){
            validBox[row][col+1] = 0;
        }
    }
}