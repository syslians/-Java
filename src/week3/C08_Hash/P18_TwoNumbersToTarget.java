package week3.C08_Hash;

import java.util.HashSet;

public class P18_TwoNumbersToTarget { // Solution 클래스라고 쳐!
    private static boolean solution(int[] arr, int target) { // 주어지는 입력값
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // 1. target에서 현재 원소를 뺀 값이 해시셋에 있는지 확인
            if (hashSet.contains(target-i)) {
                return true;
            }
            // 2. 해시셋 현재 값 저장
            hashSet.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하라
        *
        * 배열 arr : n개의 양의 정수로 이루어짐.
        * 정수 target 주어짐배열에서 합이 target인 두 수가 arr에 있는지 찾기
        * 있으면 true, 없으면 false 반환
        *
        * 두 번째, 제약사항을 파악하고, 테스트케이스를 추가하라
        *
        * [ 제약 조건 ]
        * n은 2이상 10,000 이하의 자연수입니다.
        * -> 각각 더하는 경우의 수를 하면.. 시간 복잡도 O(N^2).. 최대 1억번이여서 효율 떨어짐(첵)
        * arr의 각 원소는 1이상 10,000 이하의 자연수입니다.
        * arr의 원소 중 중복되는 원소는 없습니다.
        * target은 1 이상 20,000 이하의 자연수입니다.
        *
        * 세 번째, 입력값을 분석하라
        * [입출력의 예]
        * arr [1, 2, 3, 4, 8] target 6, return true
        * arr [2, 3, 5, 9] target 10, return false
        * */
        int n = 5;
        int[] arr = {1, 2, 3, 4, 8};
        System.out.println(solution(arr, 6));
    }
}
