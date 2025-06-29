package week1.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P1_PostfixNotation {
    public static void main(String[] args) throws IOException {
        /*
        * 후위표기식(백준 1918번)
        *
        * 첫 번째, 문제를 쪼개서 분석하기
        * 우선순위에 따라 괄호로 묶어준다
        * a+b*c -> (a+(b*c))
        * 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨준다
        * (a+bc*) -> abc*+
        *
        * 두 번째, 제약사항 파악하고 테스트케이스 추가하기
        * 피연산자는 알파벳 대문자
        * 수식에서 한번씩만 등장
        * -A+B와 같이 -가 가장 앞에 오거나
        * AB와 같이 *가 생략되는 등의 수식은 주어지지 않음.
        * 표기식은 알파벳 대문자와 +,-,*,/,(,)로만 이루어져 있음.
        * 길이는 100을 넘지 않음.
        *
        * 세 번째, 입력사항을 분석하라
        *
        *
        *
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String express = br.readLine();

        System.out.println(toPostfix(express));

    }

    public static String toPostfix(String express) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : express.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch); // 피연자 -> 바로 출력
            } else if (ch=='(') {
                stack.push(ch);
            } else if (ch==')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop()); // '(' 나올 때까지 연산자 출력
                }
                stack.pop(); // 여는 괄호 '(' 버리기 (출력안함)
            } else { // 연산자
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    // 연산자 우선순위
    public static int precedence(char op) {
        if (op =='+' || op == '-') return 1;
        if (op=='*' || op == '/') return 2;
        else return 0;
    }
}
