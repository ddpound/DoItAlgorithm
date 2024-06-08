package Question;

import java.io.*;
import java.util.Scanner;


// 백준 토너먼트
// https://www.acmicpc.net/problem/1057
public class Tournament {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(16,1,2));
        System.out.println(solution(16,8,9));
        System.out.println(solution(1000,20,31));
        System.out.println(solution(65536,1000,35000));
        System.out.println(solution(60000,101,891));
        System.out.println(solution(7801,200,711));

        solutionBack();
        solution();
    }

    // 부르트 포스 접근법
    /**
     * IDEA
     * 1. n 을 반으로 나눈다.
     * 2. a와 b 를 n 과 비교한다. (나눈 나온 결과 값 x , 1 부터 n 이면 a 는 x 과 같은지 까지 비교, b는 x 초과 값 부터 n 의 마지막)
     * 3. 만약 a와 b같은 범위라면 1번부터 다시 시작
     * 4. 만약 둘의 범위 가 반으로 나뉘었을때 다르다면 나누고 나온 최대값의 2의 n승값이 그 결과임
     *
     * 2의 제곱근 n 을 구한다고 생각하면 됨 만약
     * 2의 제곱근의 값이 아니라면 2로 나눈후 남은 값을 빼고 진행하면 됨
     *
     * */
    public static int solution(int n, int a, int b) {
        int answer = -1;

        int exponent = -1;
        while (true){
            n = Math.round((float) n /2);
            //System.out.println(n + " t");
            // 범위 체크
            // 걸리면 n 승 구하기
            if(b <= n && n <= a){
                exponent = (int) Math.ceil((Math.log(n*2) / Math.log(2)));
                break;
            } else if ( a <= n && n <= b) {
                exponent = (int) Math.ceil((Math.log(n*2) / Math.log(2)));
                break;
            } else if (a >= n && b >= n) {
                exponent = (int) Math.ceil((Math.log(n) / Math.log(2)));
                break;
            }

            if(n == 1) break;
        }

        answer = exponent;

        return answer;
    }

    // 백준 입력 방식
    public static void solutionBack() throws IOException {
        int answer = -1;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        //System.out.println((Math.log(468) / Math.log(2)) + "dd");
        int exponent = -1;
        while (true){
            n = Math.round((float) n /2);
            //System.out.println(n + " t");
            // 범위 체크
            // 걸리면 n 승 구하기
            if(b <= n && n <= a){
                exponent = (int) Math.ceil((Math.log(n*2) / Math.log(2)));
                break;
            } else if ( a <= n && n <= b) {
                exponent = (int) Math.ceil((Math.log(n*2) / Math.log(2)));
                break;
            } else if (a >= n && b >= n) {
                exponent = (int) Math.ceil((Math.log(n) / Math.log(2)));
                break;
            }

            if(n == 1) break;
        }


        answer = exponent;

        System.out.println(answer);
    }

    // 해설지의 도움을 받음
    // 문제의 이해력 부족...
    // 시간을 더 들였으면 됐을지도..
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int zimin =sc.nextInt();
        int hansu =sc.nextInt();
        int count = 0;

        while(zimin != hansu) {
            zimin = zimin/2 + zimin%2;
            hansu = hansu/2 + hansu%2;
            count++;
        }
        System.out.println(count);
    }

}
