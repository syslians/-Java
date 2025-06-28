package week1.Stack_06;

import java.util.ArrayDeque;

public class P08_CorrectParentheses {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하라
        *
        * 괄호가 바르게 짝지어졌다-> '(' 시작, ')' 끝남
        * "()()" "(())()" 올바른 괄호
        * ")()(" 또는 "(()(" 올바르지 않은 괄호
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
        * 제약 조건
        * 문자열 s의 길이 : 100,000 이하의 자연수
        * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다
        *
        * 세 번째, 입력사항을 분석하라
        * s "()()" answer true
        * s "(())()" answer true
        * s ")()(" answer false
        * s "(()(" answer false
        *
        *
        * 책. 저자님 문제 분석.
        * 괄호 짝 맞추기 -> 스택을 사용하면 된다
        *
        * */

        System.out.println(solution("(()(")); // "(())"

    }

    public static boolean solution(String str) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch=='(') {
                stack.push(ch);
            } else if (ch==')') {
                // peek 으로 값만 확인해봐야 함. pop()->peek()으로 수정함
                if (stack.isEmpty() || stack.peek() == ch) { // 기록1 : 스택에서 꺼낸 값이 ')'이면 이미 짝이 맞지 않다..
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

// 책 시간복잡도
// N : str 의 길이.. str을 순회하며 괄호의 쌍을 확인하므로
// 시간 복잡도는 O(N) 입니다...
// 참고로 괄호 쌍을 확인할 때 push() 메서드와 pop() 메서드의 시간 복잡도는 O(1) 입니다.
