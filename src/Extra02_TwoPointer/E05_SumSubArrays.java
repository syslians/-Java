package week2.Extra02_TwoPointer;

public class E05_SumSubArrays {
    public static void main(String[] args) {
        // 길이가 N인 수열이 주어지고, 그 연속 부분합 중 합이 S 이상인 가장 짧은 구간의 길이를 구하는 문제

        int[] arr = {5,1,3,5,10,7,4,9,2,8};
        int s= 15;
        int left = 0; // 왼쪽 포인터
        int sum = 0;  // 현재 부분합
        int minLength = Integer.MAX_VALUE; // 조건을 만족하는 가장 짧은 길이

        // 오른쪽 포인터를 하나씩 증가시키면서 전체 배열 순회
        for (int right = 0; right <arr.length; right++) {
            sum += arr[right]; // 현재 값을 부분합에 추가

            // 현재 부분합이 s 이상일 때만 -> 구간 축소 시도
            while (sum>=s) {
                // 현재 구간 길이 계산하고 최솟값 갱신
                minLength = Math.min(minLength, right - left +1);
                sum -= arr[left++]; // 왼쪽 포인터 값 제거하고 이동 (구간 축소)
            }
        }
        // 만약 조건을 만족하는 구간이 없었다면 0 출력
        System.out.println(minLength == Integer.MAX_VALUE? 0:minLength);
    }
// 연속된 구간의 합이 S 이상이 되는 가장 짧은 구간을 찾는 문제에서,
// 투 포인터로 오른쪽 확장 + 왼쪽 축소를 반복하면서 최소 길이를 찾아낸다.
}
