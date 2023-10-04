package Question;


/**
 *  콜라츠 문제 2023-10-04
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12943
 *
 */

public class CollatzQuestion {
    public static void main(String[] args) {
        int resultNum = solution( 626331);
        System.out.println(resultNum);
    }
    public static int solution(int num) {
        int answer = 0;
        boolean repeat = true;

        while(repeat){
            if(answer == 500 || num < 0) {
                answer = -1;
                repeat = false;
            } else if (num == 1) {
                repeat = false;
            } else{
                if(num%2 == 0){
                    num = num/2;
                }else{
                    num = num*3+1;
                }
                System.out.println(num);
                answer++;
            }
        }
        return answer;
    }

}
