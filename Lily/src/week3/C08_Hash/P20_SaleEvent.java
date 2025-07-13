package Lily.src.week3.C08_Hash;

import java.util.HashMap;

public class P20_SaleEvent {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개어 분석하기
        *
        * 일정 금액을 지불하면 10일동안 회원자격을 부여
        * 매일 1 가지 제품을 할인하는 행사를 함
        * 할인 제품은 하루에 하나만 구매할 수 있음
        * 정현이는 자신이 원하는 제품과 수량이 할인하는 나랒와 10일 연속으로 일치할 때에 맞춰서 회원가입을 하려고 함
        *
        * ex. 정현이가 원하는 제품
        * 바나나 3개, 사과 2 개, 쌀 2개, 돼지고기 2개, 냄비 1개
        * 마트에서 14일간 회원 대상 할인 제품 - 날짜 순서대로...
        * 치킨 사과 사과 바나나 쌀 사과 돼지고기 바나나 돼지고기 쌀 냄비 바나나 사과 바나나
        *  1   2   3    4  5  6    7      8     9   10  11  12   13  14
        *
        * => 열흘 동안 냄비는 할인하지 않으므로, 첫째 날에는 가입 X
        * 둘째 날부터 열흘 동안은 바나나를 원하는 만큼 구매할 수 없으므로 가입 X
        * 셋째, 넷째, 다섯째 날부터 각각 열흘 동안은 원하는 제품과 수량이 일치하므로... 셋 중에 하루에 회원가입을 한다!
        *
        * want : 정현이가 원하는 제품을 나타내는 문자열
        * number : 정현이가 원하는 제품의 수량을 나타내는 정수 배열
        * discount : XYZ마트에서 할인하는 제품을 나타내는 문자열
        *
        * 회원가입 시 정현이가 원하는 제품을 모두 할인받을 수 있는 회원 등록 날짜의 총 일수를 반환하는 solution() 함수를 완성하세요
        * 가능한 날이 없으면 0 을 return 한다.
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
        * [제약 조건]
        * 1<= want의 길이 = number의 길이 <= 10
        * 1<= number의 원소 <= 10
        * number[i]는 want[i]의 수량
        * number의 총합 10
        * 10 <= discount의 길이 <= 100,000
        * want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열
        * 1 <= want의 원소의 길이, discount의 원소의 길이 <= 12
        *
        * 세 번째, 입력사항을 분석하기
        * want  ["banana", "apple", "rice", "pork", "pot"]
        * number [3, 2, 2, 2, 1]
        * discount ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
        * result 3
        *
        * want ["apple"]
        * number [10]
        * discount ["banana", 8개... "banana"]
        * result 0
        *
        * 책 -> 이렇게 입력값의 관계를 보고 그림을 그리면서 어떤 자료구조를 떠올릴 수 있어야 한다!!
        *
        * */
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(discount.length);
        System.out.println(solution(want, number, discount));

    }

    private static int solution(String[] want, int[] number, String[] discount) {
        // 1. want, number 배열의 값을 해시맵에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0; // 2. 총 일수를 계산할 변수 초기화

        // 3. 특정일 i에 회원가입 시 할인받을 수 있는 품목 체크
        for (int i=0; i<discount.length-9; i++) {
            // 4. i일 회원가입 시 할인받는 제품 및 개수를 담을 해시맵
            HashMap<String, Integer> discount10d = new HashMap<>();

            // 5. i일 회원가입 시 할인받는 제품 및 개수로 해시맵 구성
            for (int j=i; j<i+10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0)+1);
                }
            }

            // 6. 할인하는 상품의 개수가 원하는 수량과 일치하면 정답 변수에 1 추가
            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }
        return answer;
    }
}
