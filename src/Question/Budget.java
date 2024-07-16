package Question;


import java.util.Arrays;

/**
 *
 *  프로그래머스 예산
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12982
 *
 * 아이디어
 * 1. 가장 많은 부서에게 전달해야하니 최소값으로 정렬후 전달하면됨
 * */
public class Budget {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4},9));
        System.out.println(solution(new int[]{2,2,3,3},10));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        // 퀵 정렬 진행
        quickSort(d,0,d.length-1);
        for (int i : d){

            // 차감
            budget -= i;

            if(budget >= 0){
                answer++;
            }else{
                break;
            }

        }

        return answer;
    }

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
