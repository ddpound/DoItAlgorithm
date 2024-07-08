package Question;

/**
 * 프로그래머스 -> 크기가 작은 부분 문자열
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class SmallNumberString {

    public static void main(String[] args) {
        System.out.println(solution("3141592","271"));
        System.out.println(solution("500220839878","7"));
        System.out.println(solution("10203","15"));
        System.out.println(solution("23460000000000000006","1"));
        System.out.println(solution("293849302910293049","203940392039403940"));
    }


    public static int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length(); i++) {

            if(i + p.length() > t.length()) break;

            double number = Double.parseDouble(t.substring(i, i + p.length()));

            if (number <= Integer.parseInt(p)) {
                answer++;

            }
        }

        return answer;
    }

}
