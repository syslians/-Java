package week_1;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1918 {
    // 연산자 우선순위 반환
    public static int precedence(char op) {
        if (op == '(') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }

    public static String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetter(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            } else { // 연산자
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("중위 표기식 입력: ");
        String infix = sc.nextLine();
        System.out.println("후위 표기식: " + toPostfix(infix));
        sc.close();
    }
}
