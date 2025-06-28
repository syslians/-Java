package week1.Stack_06;

import java.util.Stack;

public class P09_Conversion_10_2 {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하기
        * 10진수를 입력받기
        * 2진수로 변환하기
        * 반환하기
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
        * 제약 조건
        * decimal은 1이상 10억 미만의 자연수
        *
        * 세 번째, 입력값을 분석하라
        * decimal 10 -> 반환값 1010
        * decimal 27 -> 반환값 11011
        * decimal 12345 -> 반환값 11000000111001
        *
        *
        * */
        System.out.println(Solution.solution(13));

    }
}

class Solution {
    public static String solution(int decimal) {

        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) { // 0보다 클때까지만 돈다..
            int remainder = decimal%2;
            stack.push(remainder);
            decimal /= 2; // 마지막에 2로 나눈 값이 0이 되므로...
        }

        // String의 + 연산은 시간 복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilde를 사용함.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}