package Question;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기


import java.util.ArrayList;

public class Pair {

    // 다 돌릴 필요가 없네..? 그냥 일부분만 찾아내서 1 과 0 출력
    public static void main(String[] args) {
        System.out.println(solution("baaaabccfdd"));
    }

    public static int solution(String s)
    {
        int answer = -1;
        int end = 0;

        StringBuffer sb = new StringBuffer();
        sb.append(s);

        int number = 0;
        while (end <= 2) {
            if(sb.length() == 0 || sb.length() == 1){
                answer = 1;
                break;
            }

            if (number + 1 > sb.length() - 1) {
                end++;
                number = 0;
            }

            System.out.println(sb.charAt(number) + " :::: " + sb.charAt(number+1));
            if (sb.charAt(number) == sb.charAt(number + 1)) {
                sb.deleteCharAt(number);
                sb.deleteCharAt(number);
                end = 0;
            }
            System.out.println(sb);

            number++;
        }

        if(sb.length() > 0){
            answer = 0;
        }

        return answer;
    }


}
