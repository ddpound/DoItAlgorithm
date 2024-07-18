package Question;

import java.util.Arrays;

/**
 * 프로그래머스 행렬의 덧셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12950
 * 풀이시간 : 30분
 * */
public class ArrayPlus {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2}, {2, 3}, {5, 6}}, new int[][]{{3, 4}, {5, 6}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1}, {2}, {2}}, new int[][]{{3}, {4}, {2}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1,5,6,1,5,6,1,5,6,1,5,6}, {2,6,5,1,5,6,1,5,6,1,5,6}}, new int[][]{{3,6,5,3,6,5,3,6,5,3,6,5}, {4,2,3,3,6,5,3,6,5,3,6,5}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int t = 0; t < arr1.length; t++) {
            for (int i = 0; i < arr1[0].length; i++) {
                answer[t][i] = arr1[t][i] + arr2[t][i];
            }

            for (int z = 0; z < arr1[1].length; z++) {
                answer[t][z] = arr1[t][z] + arr2[t][z];
            }
        }



        return answer;
    }

}
