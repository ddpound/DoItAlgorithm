package Question;

public class SeoulKim {

    public static void main(String[] args) {

    }

    public static String solution(String[] seoul) {

        int i = 0;
        for (String s : seoul){
            if(s.equals("Kim")) break;
            else i++;
        }

        return "김서방은 "+i+"에 있다";
    }
}
