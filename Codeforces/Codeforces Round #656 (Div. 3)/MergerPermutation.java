import java.util.*;

public class MergerPermutation{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTest = input.nextInt();
        for (int test = 0; test < numTest; test++){
            int permutation = input.nextInt();
            List<Integer> origin = new ArrayList<>();
            Set<Integer> chamber = new HashSet<>();
            int num = input.nextInt();
            origin.add(num);
            chamber.add(num);
            for (int i = 1; i < permutation*2; i++){
                num = input.nextInt();

                if (!chamber.contains(num)){
                    origin.add(num);
                    chamber.add(num);
                }
            }

            for (int i = 0; i < origin.size()-1; i++){
                System.out.print(origin.get(i)+" ");
            }
            System.out.println(origin.get(origin.size()-1));
            // System.out.println(origin);
        }
    }
}