package Question;

import java.util.Scanner;

/**
 * 프로그래머스 직사각형 별찍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12969
 * 소요시간 : 10분
 * */
public class RectangularDot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String result = "";

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                result += "*";
            }
            result += "\n";
        }


        System.out.println(result);
    }


}
