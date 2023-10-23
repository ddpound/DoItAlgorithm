package Question;

// https://school.programmers.co.kr/learn/courses/30/lessons/12922
// 수박수박 , 프로그래머스

public class WaterMelon {

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static String solution(int n) {
        String answer = "";
        boolean switchString = true;

        for (int i = 0; i < n; i++) {
            if(switchString){
                answer += "수";
                switchString = false;
            }else {
                answer += "박";
                switchString = true;
            }
        }



        return answer;
    }
}
