package Question;

public class PaintOver {

    public static void main(String[] args) {
        System.out.println(solution(8,4, new int[]{2,3,6}));
        System.out.println(solution(4,1, new int[]{1,2,3,4}));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int passNumber = 0;

        for(int i : section){
            if(passNumber == 0){
                passNumber = (i+m) - 1;
                answer++;
            }else{
                if(i > passNumber){
                    passNumber = (i+m) - 1;
                    answer++;
                }
            }

        }

        return answer;
    }
}
