package week2.Extra02_TwoPointer;

public class E03_ConceptTwoPointer {
    public static void main(String[] args) {
        /*
        * 투 포인터 (Two Pointers)
        * - 정렬된 배열에서 두 개의 포인터를 움직이며 문제를 해결
        * - 보통 i와 j를 앞뒤에서 이동시키며 구간 탐색
        * - 시간복잡도 : O(n)
        *
        * 대표 문제 유형
        * 두 수의 합 : i=0, j=n-1, 합이 목표보다 크면 j--, 작으면 i++
        * 부분합 : i, j를 양쪽에서 당기며 구간 합 조절
        * 중복 제거 : 슬라이딩 윈도우처럼 사용
        *
        * 기본 예시는 아래 코드 참조
        *
        * 연결 리스트 : 노드/연결/포인터
        * 삽입/삭제가 자주 일어나는 곳
        * 연속된 합, 두 수의 조합
        *
        * 투 포인터 : 인덱스/두 위치/구간
        * 연속된 합, 두 수의 조합
        * 정렬 배열 문제, 누적합 문제
        *
        * 1. 연결 리스트는 중간 삽입/삭제에 강하고, 구현형 문제에서 등장
        * 2. 투 포인터는 '정렬된 배열에서 O(n)'으로 문제를 푸는 핵심 전략
        * 3. 둘 다 시간복잡도 줄이기 위한 전략적 구조
        *
        *
        *
        * */

        int[] arr = {1, 3, 5, 7, 9};
        int target = 10;

        int i=0, j = arr.length-1;
        while (i<j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                System.out.println("Found: " + arr[i] +", "+ arr[j]);
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}
