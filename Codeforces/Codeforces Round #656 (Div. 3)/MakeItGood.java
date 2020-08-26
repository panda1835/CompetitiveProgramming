import java.util.*;
public class MakeItGood {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numTest = input.nextInt();
        for(int test = 0; test < numTest; test++){
            int result = 0;
            int numElement = input.nextInt();
            // int [] array = new int[numElement];
            Queue<Integer> array = new LinkedList<>();

            for(int i = 0; i < numElement; i++){
                array.add(input.nextInt());
            }
            
            while(true){
                if(isFeasible(array)){
                    System.out.println(result);
                    break;
                }
                else{
                    array.remove();
                    result++;
                }
            }
        }
    }

    public static boolean isFeasible(Queue<Integer> array1){
        Integer[] array2 = new Integer[array1.size()];
        Integer[] array = array1.toArray(array2);
        int j = -1;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                j = i;
                break;
            }
        }
        if(j != -1){
            for (int i = j; i < array.length-1; i++){
                if(array[i] < array[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}