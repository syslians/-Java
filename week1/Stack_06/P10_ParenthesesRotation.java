package week1.Stack_06;

import java.util.ArrayDeque;
import java.util.HashMap;

public class P10_ParenthesesRotation {
    public static void main(String[] args) {
        /*
        * 첫 번째. 문제를 쪼개서 분석하기
        * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의
        * "()" "[]" "{}"
        * 만약 A가 올바른 괄호 문자열이라면, "(A)", "[A]", "{A}"도 올바른 괄호 문자열.
        * ex) "[]" 올바른 문자열, "([])" 올바른 문자열
        * 만약 A, B가 올바른 괄호 문자열이라면, AB도 올바른 괄호 문자열
        * ex) "([])" 올바른 문자열, "{}([])" 올바른 문자열
        *
        * 매개변수 : 대괄호, 중괄호, 소활호로 이루어진 문자열 s
        * s를 왼쪽으로 x( 0 <= x < (s의길이) ) 칸만큼 회전시켰을 때
        * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 반환..
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가
        * 제약 조건
        * s의 길이는 1이상 1,000이하
        *
        * 세 번째, 입력값을 분석하라
        * s "[](){}" result 3
        * s "}]()[{" result 2
        * s "[)(]" result 0
        * */



    }
}

class Solution10 {
    public static int solution(String s) {
        // 1. 괄호 정보 저장. 코드를 간결하게 할 수 있음
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length(); // 원본 문자열 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌
        int answer = 0;

        // 2. 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
        A:for (int i=0; i<n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // 3. 시작 위치 i부터 원보 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            for (int j=i; j<i+n; j++) {
                char c = s.charAt(j);
                // 해시맵 안에 해당 키가 없다면 열리는 괄호임 -> 이 부분부터는 기존 로직과 동일..
                if (!map.containsKey(c)) { // 닫힌 괄호가 없다면
                    stack.push(c);
                } else {
                    // 닫힌 괄호
                    // 4. 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if (stack.isEmpty() || stack.pop().equals(map.get(c)))
                        continue A; // 오.. 이게되네 처음봄
                }
            }
            // 3. 에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
            if (stack.isEmpty())
                answer++;
        }
        return answer;
    }
}

// 책. 시간복잡도
// N : s의 길이.
// 회전한 괄호 문자열의 유효성을 체크할 때
// 이중 반복문을 활용하므로.. 시간복잡도는 O(N^2)
// push() 메서드와 pop() 메서드의 시간 복잡도는 O(1)