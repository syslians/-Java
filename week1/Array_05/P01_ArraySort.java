package week1.C05_Array;

import java.util.Arrays;

public class P01_ArraySort {
    public static void main(String[] args) {
        /*
        * 1. 문제 분석 연습하기
        * 첫번 째, 문제를 쪼개서 분석하라
        * 정수배열을 담을 곳 만들기
        * 정수배열을 정렬하기
        * 반환히기
        *
        * 두 번째, 제약 사항을 파악하고 테스트케이스를 추가하라
        * [제약사항]
        * 정수 배열의 길이 : 2 이상 10^5 이하
        * 정수 배열의 각 데이터 값 : -100,000 이상 100,000 이하
        *
        * 테스트케이스
        * 입력 [ -100000, 100000, 0, -1. 1 ]
        * 출력 [-100000, -1, 0, 1, 100000 ]
        *
        * 배열의 길이 10^5인 것도 테스트
        * int[] arr = new int[100000];
        *
        * 세 번째, 입력값을 분석하라
        * 저자님이 문제 분석하고 풀기에서 써놓았드싱,
        *
        * 제약조건을 보면 데이터 개수는 최대 10^5
        * 즉, 제한시간이 3초라면 O(N^2) 알고리즘은 사용할 수 없다.
        *
        * 10^5이면 O(NlogN) 써야할듯..
        *
        * ===> 제약 조건에 따른 알고리즘의 선택을 생각해야 함!
        *
        *
        * */
        // 정수 배열 담을 곳 만들기
        int[] org = new int[100000];
        // 테스트데이터 추가
        // 실제 시험에선 배열 arr이 주어지겠지..
//        org[0] = -100000;
//        org[1] = -1;
//        org[2] = 0;
//        org[3] = 1;
//        org[4] = 100000;

        // 정수 배열을 정렬하기 & 반환하기
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] arr) {
        // 원본 배열 바로 정렬시
//        Arrays.sort(arr);
//        return arr;

        // 원본 배열을 두고, 복사해서 새로운 배열로 정렬할 때
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}
