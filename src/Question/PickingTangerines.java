package Question;

import java.util.*;

/**
 * 프로그래머스 귤 고르기
 * */
public class PickingTangerines {

    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
        System.out.println(solution(5, new int[]{1, 1, 1, 1, 2, 2, 2, 3, 12, 34, 55554, 333434, 122, 3,2,3,2}));
        System.out.println(solution(1, new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 2, 3, 2}));
        System.out.println(solution(9, new int[]{10000000,2,3,4,5,6,3,2,3,2,2,2,2,3,4,5,5}));
        System.out.println(solution(9, new int[]{1,3,1,1,1,5,5,5,1,1,1,1,1,1,2,3,3}));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> key = new HashMap<>();

        // 종류별로 분류
        for (int i : tangerine){
            if(key.isEmpty()){
                key.put(i,1);
            }else if (key.containsKey(i)){
                int add = key.get(i)+1;
                key.put(i, add);
            }else {
                key.put(i,1);
            }
        }

        System.out.println(key);
        List<Integer> keySet = new ArrayList<>(key.keySet());

        // Value 값으로 내림차순 정렬
        keySet.sort((o1, o2) -> key.get(o2).compareTo(key.get(o1)));

        // Value 값으로 오름차순 정렬
//        keySet.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return key.get(o1).compareTo(key.get(o2));
//            }
//        });

        for (Integer ke : keySet) {
            System.out.print("Key : " + ke);
            System.out.println(", Val : " + key.get(ke));

            // 음수가 됐을때만 뺄셈을 시도
            if(k > 0){
                k -= key.get(ke);
                answer++;
            }

        }


        return answer;
    }
}
