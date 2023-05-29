package week1;

import java.util.ArrayList;

public class Cellphone {

    public static void main(String[] args) {

        int[] inNumbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(inNumbers,hand));
    }

    // 2 5 8 0

    public static String solution(int[] numbers, String hand) {

        int[] lpoint = {3,0};
        int[] rpoint = {3,2};
        int[] point = {0,0};

        int llength = 3;
        int rlangth = 3;

        String answer = "";
        for (int i =0; i< numbers.length ; i++) {
            llength = 3;
            rlangth = 3;
            int number = numbers[i];

            if(numbers[i]== 1 || numbers[i] ==4 || numbers[i] ==7){

                if(numbers[i] == 1){
                    lpoint = new int[]{0 ,0};
                }
                if(numbers[i] == 4){
                    lpoint = new int[]{1 ,0};
                }
                if(numbers[i] == 7){
                    lpoint = new int[]{2 ,0};
                }
                answer += "L";

            } else  if(numbers[i]== 3 || numbers[i] ==6 || numbers[i] ==9){

                if(numbers[i] == 3){
                    rpoint = new int[]{0 ,2};
                }
                if(numbers[i] == 6){
                    rpoint = new int[]{1 ,2};
                }
                if(numbers[i] == 9){
                    rpoint = new int[]{2 ,2};
                }
                answer += "R";
            }else if(numbers[i]== 2 || numbers[i] ==5 || numbers[i] ==8 || numbers[i] ==0){

                if(numbers[i] == 2){
                    point = new int[]{0 ,1};
                }
                if(numbers[i] == 5){
                    point = new int[]{1 ,1};
                }
                if(numbers[i] == 8){
                    point = new int[]{2 ,1};
                }
                if(numbers[i] == 0){
                    point = new int[]{3 ,1};
                }

                llength = Math.abs(lpoint[0] - point[0]) + Math.abs(lpoint[1] - point[1]);
                rlangth = Math.abs(rpoint[0] - point[0]) + Math.abs(rpoint[1] - point[1]);

                if(llength == rlangth){
                    if (hand.equals("right")){
                        rpoint = new int[]{point[0],point[1]};
                        answer+= "R";
                    }if (hand.equals("left")){
                        lpoint = new int[]{point[0],point[1]};
                        answer+= "L";
                    }
                } else if(rlangth < llength){
                    rpoint = new int[]{point[0],point[1]};
                    answer+= "R";
                } else {
                    lpoint = new int[]{point[0],point[1]};
                    answer+= "L";
                }

            }

        }

        return answer;
    }

}
