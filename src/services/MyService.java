package services;

import java.util.Arrays;

public class MyService {

    public static void main(String[] args) {


        MyService myService=new MyService();
        System.out.println(myService.checkName("Gulnar"));

        //Task1:
        String [] books={"Lord of the rings","Harry Potter","Dune","Narnia"};
        for(int i=0;i< books.length;i++){
            System.out.println(books[i]);
        }

        //Task2:
        double [] dailyExpenses=new double[5];
        dailyExpenses[0]=12.5;
        dailyExpenses[1]=23;
        dailyExpenses[4]=14.2;

        double weeklyExpenses=0;
        for(int i=0;i<dailyExpenses.length;i++){
            weeklyExpenses+=dailyExpenses[i];
            System.out.println(weeklyExpenses);
        }


        //Task3:
        int[][] scores = {
                {85, 90, 78},
                {76, 88, 95},
                {90, 92, 89},
                {70, 80, 85}
        };

        for (int i=0;i<scores.length;i++){
            for(int j=0;j<scores[i].length;j++){
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }



        //Task5:
        int[] prices={123,12,23,54,10};
        Arrays.sort(prices);
        for(int price:prices){
            System.out.println(price);
        }


        //Task6:
        //First way:
        int [] ids={0,1,2,3,4};
        int [] copyIds=new int[5];

        for(int i=0;i<ids.length;i++){
            copyIds[i]=ids[i];
        }
        for(int id:copyIds){
            System.out.println(id);
        }

        //Second way:
        int [] copyIds=Arrays.copyOf(ids,ids.length);
        for(int id:copyIds){
            System.out.println(id);
        }


        //Task7:
        //First way:
        double [] numbers={12.5,32.3,45};
        double min=numbers[0];
        double max=numbers[0];

        for(int i=0;i<numbers.length;i++){
            if (numbers[i]>max){
                max=numbers[i];
            }if(numbers[i]<min){
                min=numbers[i];
            }

        }System.out.println(max);
        System.out.println(min);

        //Second way:
        double max=Arrays.stream(numbers).max().getAsDouble();
        double min=Arrays.stream(numbers).min().getAsDouble();
        System.out.println(max);
        System.out.println(min);

    }

    //Task4:
    String [] names={"Nermin","Ləman","Fatime"};
    public int checkName(String name){
        for(int i=0;i<names.length;i++){
            if (names[i].equals(name)){
                return i;
            }
        }
        return -1;
    }
}
