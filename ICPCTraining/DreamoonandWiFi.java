import java.util.*;

public class DreamoonandWiFi {
    public static int counter = 0; // number of solutions
    public static int numQuestion = 0;
    public static int sum = 0;
    public static final char[] SET = {'+','-'};
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        input.close();
        
        sum = sumOfString(s1) - sumOfString(s2);
        for(int i = 0; i < s2.length(); i++){
            if(s2.charAt(i) == '?'){
                numQuestion += 1;
            }
        }
        StringBuilder string = new StringBuilder();

        solve(string);

        System.out.println(counter/numQuestion);
    }

    public static boolean solve(StringBuilder string){
        // base case
        if (string.length() == numQuestion){
            if (sumOfString(string.toString()) == sum){
                counter++;
                return true;
            }
            else{
                return false;
            }
        }
        // recursive case
        else{
            for (char c:SET){
                if(solve(string.append(c))){
                    return true;
                }
                string.deleteCharAt(string.length()-1);
                return false;
            }
        }
        return false;
    }

    public static int sumOfString(String s){
        int sum = 0;
        for (char c:s.toCharArray()){
            if(c=='+'){
                sum ++;
            }
            if(c == '-'){
                sum--;
            }
        }
        return sum;
    }
}