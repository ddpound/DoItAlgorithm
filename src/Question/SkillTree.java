package Question;


/**
 * 프로그래머스 스킬트리
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 *
 * 아이디어
 * 0. 해당 문자열 순회때마다 skill 검색
 * 1. 있다면 skill.charAt(i) 와 비교
 * 2. 같다면 i++, 다음 char 로 넘어감
 * 2-1. 다르다면 break 후 끝내기
 * 3. skill tree의 끝까지 도달 했다면 result++
 *
 *
 * */
public class SkillTree {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillT : skill_trees) {
            // 비교할때 필요한 인덱스 표시기, 순회가 다 되면 0으로 돌아간다.
            int index = 0;
            boolean judge = true;

            for (int i = 0; i < skillT.length(); i++) {
                // 스킬트리 검색 후 맨 첫번째 인덱스면 순회 시작
                if(skill.contains(String.valueOf(skillT.charAt(i)))){
                    if(skill.charAt(index) == skillT.charAt(i)){
                        index++;
                    }else{
                        judge = false;
                        break;
                    }
                }
            }

            // 문제없이 끝까지 돌았다면 answer 값 추가
            if(judge) answer++;
        }

        return answer;
    }
}
