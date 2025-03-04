package Question;


/**
 * 프로그래머스 택배상자 꺼내기
 * https://school.programmers.co.kr/learn/courses/30/lessons/389478
 *
 * */
public class TakeOutTheDeliveryBox {

    public static void main(String[] args) {
        System.out.println(solution(22,6,8));
        System.out.println(solution(13,3,6));
        System.out.println(solution(100,1,2));
    }

    // 모든 시작값은 1로 시작
    public static int solution(int n, int w, int num) {
        int answer = 0;

        int h = n / w; // 상자 적재 장소 높이
        h += n % w > 0 ? 1 : 0; // 남은 상자가 있으면 최종 높이

        int spareOfBoxNumber = n % w; // 한줄이 다 차지 않는 남는 상자 개수

        // 마지막 남은 상자 라인이 역방향인지 체크, 참이면 역방향
        boolean lastLineReverse = h % 2 == 0;

        // 위치 구하기, 모두 1로 시작함을 염두
        int heightPosition = 1;
        int widhtPosition = 1;

        // 높이 구하기
        while (true){
            if (w * heightPosition >= num){
                break;
            }
            heightPosition++;
        }

        boolean positionReverse = false;

        // 위치가 역방향인지 정방향인지 체크 (짝수면 역방향)
        if(heightPosition % 2 == 0) positionReverse = true;

        // 포지션 라인의 마지막 번호 (위치는 아님)
        int positionLineLastNumber = w * heightPosition;
        int positionLineStartNumber = (w * heightPosition) - ( w - 1 );


        // 정확한 위치
        heightPosition = h - (heightPosition - 1);

        // 너비 위치 계산
        // 역방향이면 마지막 번호에서 빼기, 정방향이면 num - 시작값 이면 포지션이 나옴, 1로 시작한다고 가정했으니 1 더해줘야함
        widhtPosition = positionReverse ? (positionLineLastNumber - num) + 1 : (num - positionLineStartNumber) + 1;


        // 남은 상자가 있다면, 높이가 +1 되어있는거니  빈공간 계산해서 빼주기
        if(spareOfBoxNumber > 0){
            // 남은 공간
            int spaceArea = w - spareOfBoxNumber;

            // 정방향이면 빈 공간이 끝에서 시작함, 역방향이면 빈공간이 맨 처음에 시작됨
            int spaceAreaStartPosition = lastLineReverse ? 0 : ( w - 1 );
            int spaceAreaEndPosition = lastLineReverse ? spaceAreaStartPosition + spaceArea  : spaceAreaStartPosition - (spaceArea - 1);

            // spaceAreaStartPosition ~ spaceArea 까지의 공간이 나는 거임
            if(widhtPosition <= spaceAreaEndPosition && widhtPosition >= spaceAreaStartPosition){
                // 빈공간에 걸린거니 -1 해줘야함
                heightPosition--;
            }
        }

        answer = heightPosition;

        return answer;
    }

}
