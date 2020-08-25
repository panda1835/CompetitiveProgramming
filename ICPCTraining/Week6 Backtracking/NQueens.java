import java.util.*;

public class NQueens {
    static List<int[]> queens;
    static int total = 0;
    static int n;
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        queens = new ArrayList<>();
        search(0);
        System.out.println(total);

        input.close();
    }

    public static void search(int col){
        if (col == n){
            total++;
            return;
        }
        else{
            int[] location = new int[2];
            for (int row = 0; row < n; row++){
                if(isValid(row, col)){
                    location[0] = row;
                    location[1] = col;
                    queens.add(location);
                    search(col+1);
                } 
                queens.remove(location);
            }
        }
    }

    public static boolean isValid(int row, int col){
        for(int[] piece : queens){
            // row
            if (piece[0] == row){
                return false;
            }
            // diag TL-BR
            if((piece[0]-piece[1]) == (row-col)){
                return false;
            }
            // diag BL-TR
            if((piece[0]+piece[1]) == (row+col)){
                return false;
            }
        }

        return true;
    }
}