package Question;

/**
 * 부족한 금액 계산하기 (23-10-05)
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * */
public class InsufficientAmount {

    public static void main(String[] args) {
        System.out.println(solution(2334,20,2500));
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += ((long) price * i);
        }
        System.out.println(sum);
        answer = money - sum;
        if(answer >= 0){
            answer = 0;
        }
        return answer*(-1);
    }
}
