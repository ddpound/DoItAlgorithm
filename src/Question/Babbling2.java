package Question;

/**
 * 프로그래머스 옹알이2
 * babbling2
 * 약간의 함정이 들어있는 문제? 같음
 * 일단 연속된 말이 들어올수는 업다고 했는데
 * 그럼 연속적이지만 않으면 말할 수 있다는 의미인가?
 *
 * 아이디어
 * 1. 연속된 문자열 조합은 안된다
 * 2. 각각의 시작 알파벳은 다 다름 a, y, w, m
 * 3. 시작 인덱스로 어떤 문자열을 제거할 지 선택
 * */
public class Babbling2 {

    public static void main(String[] args) {
        //System.out.println("result : " + solution(new String[]{"ayaye"}));
        System.out.println("result : " + solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
        System.out.println("result : " + solution(new String[]{"aya", "yee", "u", "maa"}));
        //System.out.println("result : " + solution(new String[]{"ayayeaa"}));

    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for (String baby : babbling){
            boolean flag = true;
            String memory = ""; // 중복 방지를 위한 문자열

            // 해당 문자열 길이만큼 반복
            for (int i = 0; i < baby.length();) {

                if(baby.charAt(i) == 'a' && !memory.equals("a") && i+3 <= baby.length() &&  baby.substring(i, i+3).equals("aya")) {
                    memory = "a";
                    i += 3;
                }else if(baby.charAt(i) == 'y' && !memory.equals("y") && i+2 <= baby.length() &&  baby.substring(i, i+2).equals("ye")) {
                    memory = "y";
                    i += 2;
                }else if(baby.charAt(i) == 'w' && !memory.equals("w") && i+3 <= baby.length() && baby.substring(i, i+3).equals("woo")){
                    memory = "w";
                    i += 3;
                }else if(baby.charAt(i) == 'm' && !memory.equals("m") && i+2 <= baby.length() && baby.substring(i, i+2).equals("ma")){
                    memory = "m";
                    i += 2;
                }else{
                    // 모든 상황이 해당없으면 바로 break 걸면됨
                    flag = false;
                    break;
                }
            }
            //System.out.println(baby + " :: :: " + flag);
            if(flag) answer++;
        }

        return answer;
    }
}
