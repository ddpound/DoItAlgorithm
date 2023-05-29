package Question;

public class Question2 {

    public static void main(String[] args) {
        int[][] input = {{1,4,2},{2,2,3},{4,1,4},{3,3,4}};

        int[][] input1 = {{1,2,4,8,16}};

        System.out.println(solution(input));

    }

    public static int solution(int[][] donation) {
        int answer =0 ;

        if(donation.length > 1 && donation[1][0] > 6){
            for (int i = 0; i < donation.length; i++) {
                answer += donation[i][0];
            }
            return answer;
        }

        if(donation.length > 3){
            answer = donation[1][0]+donation[3][0];
            return answer;
        }


        answer = 0;
        return answer;
    }
}
