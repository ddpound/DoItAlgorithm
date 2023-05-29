package Question;

public class Question6 {

    public long solution(int r, int c) {
        long answer = 0;


        int a = factorial((r-1)+(c-1));
        int b = factorial((r-1)) * factorial((c-1));

        answer = a/b;
        return answer;
    }

    static int factorial(int n){
        if(n ==1){
            return 1;
        }
        return n * factorial(n-1);
    }


}
