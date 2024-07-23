package Question;

/**
 * 프로그래머스 하샤드 수
 * */
public class HarshadNumber {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static boolean solution(int x) {
        String xString = String.valueOf(x);
        int sum = 0;

        for (int i = 0; i < xString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(xString.charAt(i)));
        }

        return x%sum == 0;
    }
}
