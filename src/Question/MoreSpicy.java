package Question;

import java.util.ArrayList;

// 프로그래머스 더맵게
// 수정 날짜 2024-06-29
// https://school.programmers.co.kr/learn/courses/30/lessons/42626

/**
 *
 * 아이디어
 * 1. 최종적으로 섞인 값이 K 보다 크면 Heap에 담아두고 필요할때 써먹음
 * 2. 정렬된리스트에서 반복문이 끝나는 조건은 k 이상인 값을 만나면 break됨
 * 3. 스코빌 공식을 써도 k를 넘지 못하는 값들을 넣는 heap 생성 거기에 담아둠
 * 4. 본 list의 값을 꺼낼때 k보다 작으면 다음 값과 heap 저장된 넘지못한 값과 비교
 * 5.
 * */
public class MoreSpicy {

    public static void main(String[] args) {

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        double sumScovile = 0;

        // 정렬
        quickSort(scoville,0,scoville.length-1);




        return answer;
    }

    // 값 변경, static 이여서 따로 반환하지 않아도 적용된다.
    static void swap(int[]a, int idx1, int idx2){
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    static void quickSort(int[] a, int left, int right){
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int x = a[(pl + pr) /2]; // 피벗

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

}
