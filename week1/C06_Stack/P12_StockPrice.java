package week1.C06_Stack;

import java.util.Arrays;
import java.util.Stack;

public class P12_StockPrice {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하라
        * 초 단위로 기록된 주식 가격이 담긴 배열 prices 가 매개변수로 주어짐
        * 가격이 떨어지지 않은 기간은 몇 초인지를 반환하기
        *
        * 두 번째, 제약사항 파악하고 테스트케이스 추가하기
        * 제약 조건
        * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
        * prices의 길이는 2이상 100,000 이하입니다.
        *
        * 세 번째, 입력값을 분석하기
        * prices [1,2,3,2,3]
        * return [4,3,1,1,0]
        *
        * */
        int[] prices = new int[] {1, 6, 9, 5};
        System.out.println(Arrays.toString(Solution12.solution(prices)));

    }
}

class Solution12 {
    public static int[] solution(int[] prices) {

        int n = prices.length; // 가격의 길이
        int[] answer = new int[n]; // 가격이 떨어지지 않은 기간을 저장할 배열

        // 스택을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<n; i++) {
            while ( !stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop(); // 0
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int j =  stack.pop();
            answer[j] = n-1-j;
        }
        return answer;

    }
}

// 책...시간복잡도
// N : prices의 길이. 최악의 경우 각 prices의 원소들은 한 번씩 푸쉬/팝 하므로 시간 복잡도는 O(N)이다.