package Question;
import java.util.*;

/**
 * 프로그래머스 할인행사
 *
 * 1. 배열 갯수가 10만개 일때 이미 이중 for문은 안된다고 확인
 * 2. 문제를 읽어보았을땐 queue 자료구조 방식이 적절하다고 생각이 들었음.
 *
 * */
public class DiscountEvent {

    public static void main(String[] args) {
        String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number = new int[]{3, 2, 2, 2, 1};
        String[] discount = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};


        System.out.println(solution(want,number,discount));
    }

    // number의 합을 다 더하자
    // 맞는게 있으면 +1 해주고 없다면 -1 해주자
    // 0이 된다면 바로 끝내자 answer를 반환해서
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 1;
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> hash = new HashMap<>(); // 인덱스를 저장해줌

        int[] answerInt;

        for (int i = 0; i < want.length; i++) {
            hash.put(want[i], i);
        }


        for (int i = 0; i < discount.length; i++) {

            if(queue.size() > 9){
                String p = queue.poll();
            }

            // 등록, 빼기
            queue.offer(discount[i]);

            if(queue.size() == 10){
                answerInt = new int[number.length];
                for (String q : queue){
                    if(hash.containsKey(q)){
                        answerInt[hash.get(q)] += 1;
                    }
                }
                System.out.println(queue);
                System.out.println(Arrays.toString(answerInt));
                System.out.println(Arrays.toString(answerInt));
                if(Arrays.equals(number, answerInt)){
                    answer++;
                }
            }
        }
        System.out.println(queue);
        return answer;
    }

}
