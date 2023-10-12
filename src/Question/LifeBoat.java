package Question;

// 구명보트
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

public class LifeBoat {

    public static void main(String[] args) {
        int[] people = {70, 50, 80};
        System.out.println(solution(people,100));
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        quickSort(people, 0, people.length-1);

        int i = 0;
        int last = people.length -1;

        do {
            if (people[i] + people[last] > limit) {
                last--;
                answer++;
            } else {
                last--;
                i++;
                answer++;
            }

        } while (i <= last);
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
