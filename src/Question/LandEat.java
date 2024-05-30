package Question;

import java.util.Arrays;
import java.util.Stack;

public class LandEat {

    public static void main(String[] args) {
        System.out.println(solutionDP(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
        System.out.println(solutionDP(new int[][]{{4,7,8,3},{2,4,7,5},{3,1,2,6}}));
        System.out.println(solutionDP(new int[][]{{9,8,7,6},{9,8,7,6},{7,9,7,6}}));
        System.out.println(solutionDP(new int[][]{{4,3,2,1},{1,2,3,4},{4,3,2,5}}));
        System.out.println(solutionDP(new int[][]{{1,2,3,4},{1,2,3,4},{1,2,4,3}}));
        System.out.println(solutionDP(new int[][]{{6,7,1,2}, {2,3,10,8}, {1,3,9,4}, {7,11,4,9}}));
        System.out.println(solutionDP(new int[][]{{6,7,1,2}, {2,3,10,8}, {1,3,9,4}, {7,11,4,9}}));

    }

    static int solution(int[][] land) {
        int answer = 0;

        Stack<Integer> wherePoint = new Stack<>(); // 바로 전 칸이 몇번이였는지

        for (int i = 0; i < land.length; i++) {
            int max = 0;
            int sameNumber = -1;

            if(!wherePoint.isEmpty()){
                sameNumber = wherePoint.pop();
            }

            for (int j = 0; j < land[i].length; j++) {
                if(max < land[i][j] && j != sameNumber){
                    max = land[i][j];
                    wherePoint.push(j); // 바로 전이 몇번째 인덱스 였는지
                }
            }
            System.out.println(max);
            answer += max;
        }


        return answer;
    }

    /**
     * DP 알고리즘 구현
     * 풀이 방향의 도움을 받았음.
     *
     * */

    static int solutionDP(int[][] land) {
        int[][] newLand = new int[land.length][4]; // DP를 위한 메모리

        // 첫번째 줄,열 값 넣어주기, 초기화
        for (int i = 0; i < land[0].length; i++) {
            newLand[0][i] = land[0][i];
        }

        /**
         * 다음줄의 DP를 사용할 때, 자기와 같은 열은 제외함.
         * 첫번째 열은 이미 돌았으니 1부터 시작
         */
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if(j != k && max < (land[i][j] + newLand[i-1][k])){
                        max = land[i][j] + newLand[i-1][k];
                    }
                }

                newLand[i][j] = max;
            }

        }
        System.out.println(Arrays.deepToString(newLand));
        int answer = 0;

        int resultMax = 0;
        for (int i = 0; i < newLand[newLand.length-1].length; i++) {
            if(resultMax < newLand[newLand.length-1][i]){
                resultMax = newLand[newLand.length-1][i];
            }

        }

        return resultMax;
    }

}
