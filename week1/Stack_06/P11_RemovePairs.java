package week1.C06_Stack;

import java.util.Stack;

public class P11_RemovePairs {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개어 분석하라
        * 알파벳 소문자로 구성된 문자열
        * 같은 알파벳 2개  붙어 있는 짝 찾기
        * 짝을 찾으면 제거하기
        * 앞뒤로 문자열 이어 붙이기
        *
        * 위의 과정을 반복해서, 문자열을 모두 제거한다면 1 반환, 아니면 0 반환
        * baabaa -> bbaa -> aa
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가해라
        * 제약 조건
        * 문자열의 길이 : 1,000,000 이하의 자연수
        * 문자열은 모두 소문자로 이루어져 있다.
        *
        * 세 번째, 입력값을 분석하라
        * s "baabaa" result 1
        * s "cdcd"  result 0
        *
        * 책. 저자님의 분석
        * : 문자열 길이는 최대 100만이므로..
        * 이중 반복문, 즉 시간복잡도가 O(N^2)인 알고리즘으로 접근하면 무조건 시간 초과가 발생!
        * 이 문제는 시간 복잡도가 O(N)인 알고리즘을 적용해야 함.
        *
        * 문자열 제거 과정 생각해보기
        * 슬프게도.. 이 문제도 바로 스택을 떠올리기 쉽지 않음..
        * 코드는 간단하지만, ㄷ알고리즘을 떠올리기 어려움
        * -> 그래서, 일단 문제를 이해하고, 간단한 입력값, 출력값으로 문제가 해결되는 과정을
        * 직접 그려보는게 좋다..
        *
        *
        * */
        System.out.println(Solution11.solution("bbaa"));
    }
}

class Solution11 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 스택이 비어있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 스택의 맨 위 문자 제거
            } else {
                stack.push(c); // 스택에 현재 문자 추가
            }
        }
        return stack.isEmpty()? 1:0; // 스택이 비어있으면 1, 그렇지 않으면 0 반환
    }
}

// 책. 저자님 시간복잡도
// N : s의 길이... 문자열의 모든 문자를 한 번씩 순회하므로
// 시간 복잡도는 O(N)