package Question;


import java.util.HashMap;

/**
 * 프로그래머스 롤케이크 자르기
 * 아이디어
 * 1. 인덱스별로 가지수를 저장하는 배열 2개를 만들어준다.
 * 2. a 배열은 맨 처음 0번 인덱스 부터 시작한다.
 * 3. b 배열은 topping list 의 길이-1 인덱스 즉 맨 마지막 인덱스 부터 시작해서 가지수를 저장한다.
 * 4. 시간복잡도는 3번만 for문을 돌리면 되어서 3 * n 이며 상수를 제외하니 빅오는 O(n) 이 된다.
 * */
public class CuttingRollCake {

    public static void main(String[] args) {

    }


    public static int solution(int[] topping) {
        int answer = 0;
        int[] a = new int[topping.length];
        int[] b = new int[topping.length];

        // 가지수 측정을 위한 HashMap을 하나 만들자.
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            if(hashMap.isEmpty() || !hashMap.containsKey(topping[i])){
                hashMap.put(topping[i], topping[i]);
            }

            // 가지수 만큼 반복
            a[i] = hashMap.size();
        }

        hashMap = new HashMap<>();

        for (int i = topping.length-1; i > 0; i--) {
            if(hashMap.isEmpty() || !hashMap.containsKey(topping[i])){
                hashMap.put(topping[i], topping[i]);
            }

            // 가지수 만큼 반복
            b[i] = hashMap.size();
        }

        for (int i = 0; i < a.length-1; i++) {
            if(a[i] == b[i+1]) answer++;
        }

        return answer;
    }


}
