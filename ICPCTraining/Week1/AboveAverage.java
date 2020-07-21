package Week1;
import java.util.Scanner;

public class AboveAverage{
    // open.kattis.com/problems/aboveaverage

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number_of_test = input.nextInt();
        for(int i = 0; i < number_of_test; i++){
            int number_of_grades = input.nextInt();
            int [] grades = new int[number_of_grades];
            for (int j = 0; j < number_of_grades; j++){
                grades[j] = input.nextInt();
            }
        input.close();
        System.out.printf("%.3f%s %n",aboveAverage(grades),"%");
        }
    }

    public static double aboveAverage(int[] grades){
        double result = 0;
        int average = 0;
        for (int i = 0; i < grades.length; i++){
            average += grades[i];
        }
        average /= grades.length;
        for (int i = 0; i< grades.length; i++){
            if (grades[i] > average){
                result ++;
            }
        }
        return result*100/grades.length;
    }
}