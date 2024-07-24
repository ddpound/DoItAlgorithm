package Question;

// 프로그래머스 : 약수의 개수와 덧셈
// https://school.programmers.co.kr/learn/courses/30/lessons/77884
// 소요시간 20분
public class AdditionOfDivisors {

    public static void main(String[] args) {
        System.out.println(solution(13,17));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        int childSum = 0;

        for (int i = left; i <= right; i++) {

            childSum = 0;
            for (int j = 1; j <= i; j++) {
                if(i%j==0){
                    childSum++;
                }
            }

            // 짝수라면
            if(childSum%2 == 0) answer += i;
            else answer -= i;


        }


        return answer;
    }

}
