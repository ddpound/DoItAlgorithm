package Question;


import java.util.Stack;

/**
 * 괄호 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * stack으로 풀어주어야함
 * 풀이 출처 https://velog.io/@joonghyun/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B4%84%ED%98%B8%ED%9A%8C%EC%A0%84%ED%95%98%EA%B8%B0-%EC%9E%90%EB%B0%94
 * */
public class RotatingParentheses {
    public static void main(String[] args) {
        // list 처음과 마지막 비교
        System.out.println(solution("}]()[{"));
    }

    public static int solution(String s) {
        int answer = 0;
        char[] sChar = s.toCharArray();

        // 옆으로 이동시킬 필요없이 하나씩 뒤로 밀어서 읽어주면됨
        // 배열의 길이만큼 그리고 0번째와 마지막번째만 붙여서 비교해보면됨
        // { 이거일때 } 이게 오면 1 이런식으로

        // 문자열길이만큼 반복
        for (int i = 0; i < s.length(); i++) {
            String words = "";

            // 시작 인덱스는 i , 끝 인덱스는 무조건 i-1
            int index = i;
            int endIndex = index -1;
            if(index == 0 ){
                endIndex = s.length()-1;
            }
            for (int j = 0; j < s.length(); j++) {
                words += sChar[index];
                // 끝에 도달
                if(index == s.length()-1){
                    index = 0; // 0으로 순환
                }else{
                    index++;
                    endIndex++;
                }
            }
            // 검사
            // 단계별로 받고 비어있으면 ++;
            Stack<String> stack = new Stack<>();
            char[] wordChars = words.toCharArray();
            System.out.println(words);
            for(int j = 0; j < s.length(); j++){
                String indexString = String.valueOf(wordChars[j]);
                if(stack.isEmpty()){
                    stack.push(indexString);
                }else if(indexString.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }else if(indexString.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else if (indexString.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                }else{
                    stack.push(indexString);
                }
            }
            System.out.println(stack);
            if(stack.isEmpty()){
                answer++;
            }
            words = "";
        }

        return answer;
    }


}
