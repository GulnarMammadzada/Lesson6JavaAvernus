package services;

import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {


        double[] grades = new double[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < grades.length; i++) {
                System.out.println("Please enter your grades between 0 and 100!");
                grades[i] = scanner.nextDouble();
                while(grades[i]<0 || grades[i]>100){
                    System.out.println("Please enter grades between 0 and 100!");
                    grades[i]=scanner.nextDouble();
                }
        }

        System.out.println("Entered grades for 5 subjects:");
        Arrays.sort(grades);
        for (int i=0;i<grades.length;i++){
            System.out.println(grades[i]);
        }


        double average=averageGrade(grades);
        double max=maxGrade(grades);
        double min=minGrade(grades);

        System.out.println("Average grade is: " + average);
        System.out.println("Highest grade is: " + max);
        System.out.println("Lowest grade is: " + min);
    }

    public static double averageGrade(double[] grades){
        //Average grade:

//        double sum=0;
//        for(int i=0;i<grades.length;i++){
//            sum+=grades[i];
//        }
//        System.out.println("Average grade is: " + (sum/grades.length));

        double averageGrade=Arrays.stream(grades).average().getAsDouble();
        return averageGrade;
    }

    public static double minGrade(double[] grades) {
        //Min grade
//        double min=grades[0];
//        for (int i=0;i<grades.length;i++){
//            if(grades[i]<min){
//                min=grades[i];
//            }
//        }
//        System.out.println("Lowest grade is: " + min );

        double min = Arrays.stream(grades).min().getAsDouble();
        return min;

    }

    public static double maxGrade(double [] grades){
//        double max=grades[0];
//        for (int i=0;i<grades.length;i++){
//            if(grades[i]>max){
//                max=grades[i];
//            }
//        }
//        System.out.println("Highest grade is: "+ max);

        double max= Arrays.stream(grades).max().getAsDouble();
        return max;

    }


}
