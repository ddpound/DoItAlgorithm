package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQuestion {



    public static void main(String[] args) {



        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};

        solution(arr1, arr2);
    }


    public static int[][] solution(int[][] arr1, int[][] arr2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();



        for(int i=0; i < arr1[0].length; i++){
            int re1 = arr1[0][i] + arr2[0][i];
            list1.add(re1);
        }
        for(int j=0; j < arr1[2].length ; j++){
            int re2 = arr1[1][j] + arr2[1][j];
            list2.add(re2);
        }

        int[][] answer = {{list1.get(0),list1.get(1)},{list2.get(0),list2.get(1)}};

        System.out.println(list1);
        System.out.println(list2);

        return answer;
    }

}
