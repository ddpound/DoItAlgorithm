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
        System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));

    }

    public static int solution(String[] babbling) {
        String aya = "aya"; // 3
        String ye = "ye"; // 2
        String woo = "woo"; // 3
        String ma = "ma"; // 2

        int answer = 0;
        for (String baby : babbling){

            // 해당 문자열 길이만큼 반복
            for (int i = 0; i < baby.length();) {
                System.out.println(i + "where");
                if(baby.charAt(i) == 'a' &&  baby.substring(i, i+3).equals("aya")) {
                    System.out.println("a");
                    i += 3;
                    System.out.println(i);
                }else if(baby.charAt(i) == 'y' &&  baby.substring(i, i+2).equals("ye")) {
                    System.out.println("y");
                    i += 2;
                    System.out.println(i);
                }else if(baby.charAt(i) == 'w' && baby.substring(i, i+3).equals("woo")){
                    i += 3;
                }else if(baby.charAt(i) == 'm' && baby.substring(i, i+2).equals("ma")){
                    i += 2;
                }else{
                    // 모든 상황이 아니라면 브레이크하고 끝내자
                    break;
                }
                // 만약 중간에 걸리면 break 끝까지 도달 하면 값 ++
                if(i == baby.length()-1) answer++;
            }
        }






        return answer;
    }
}
