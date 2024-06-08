package Question;

import java.util.Scanner;

// 백준 Stick
// 막대기

public class Stick {


    public static void main(String[] args) {
        solution();
    }

    // 나누기는 음수가 될수 없음
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int remain = 0;

        while (n > 1){
            remain += n%2;
            n /= 2;

        }

        System.out.println(remain+n);

    }
}
