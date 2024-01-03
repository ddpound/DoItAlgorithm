package Question;

/**
 * 나머지가 1이되는 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87389
 * */
public class RestAwaysOne {

    public static void main(String[] args) {
        System.out.println(solution(934899));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= 1000000; i++) {
            if(n%i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
