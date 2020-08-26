import java.util.*;

public class ThreePairwiseMaximums {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTest = input.nextInt();
        for(int test = 0; test < numTest; test++){
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            if(x !=y && y!=z && x!=z){
                System.out.println("NO");
            }
            else if(x==y && y==z && z==x){
                System.out.println("YES");
                System.out.println(x+" "+x+" "+x);
            }
            else{
                int max = Math.max(Math.max(x,y),z);
                int min = Math.min(Math.min(x,y),z);

                if ((x+y+z-max-min) == min){
                    System.out.println("NO");
                }
                else{
                    System.out.println("YES");
                    System.out.println(max+" "+min+" 1");
                }
            }
        }
    }
}