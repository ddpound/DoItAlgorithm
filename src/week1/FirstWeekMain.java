package week1;

// 첫째주 페이지()


import java.util.ArrayList;
import java.util.Random;


public class FirstWeekMain {
    int a;



    public FirstWeekMain(int a , int b){
        this.a = a+ b;
    }




    public static void main(String[] args) {

        FirstWeekMain in = new FirstWeekMain(10, 20);
        ArrayList data;

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }

        array[3] = 10;

        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }

    }

}
