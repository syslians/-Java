package week1.C05_Array;

import java.util.Arrays;
import java.util.Collections;

public class P02_ArrayControl {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하라
        *
        * 정수 배열 하나 받는다
        * 배열 중복값 제거
        * 배열 데이터를 내림차순으로 정렬
        * 반환하기
        *
        * 두 번째, 제약사항 파악 테스트케이스 추가
        * 제약조건
        * - 배열 길이는 2 이상 1,000 이하
        * - 각 배열의 데이터 값은 -100.000 이상 100.000 이하
        *
        * 배열 길이가 P01과 달리 최대값이 1,000 이므로
        * O(N^2) 시간복잡도 아래로 다 가능함
        *
        * 세 번째, 입력사항 분석
        * 배열 데이터 값이 -100000, 100000 인것도 추가해서 테스트해보기
        *
        *
        *
        * */
        int n = 1000; // 주어졌다고 가정
        int arr[] = new int[n]; // int 배열이므로 0으로 초기화
        arr[0] = -100000; // 추가한 입력값 테스트케이스 넣어보기
        arr[1] = 100000;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        int[] clone = arr.clone();

        // 중복값 제거 -> 저자님 스트림, 자바 표준 API 소스 참고함
        Integer[] result = Arrays.stream(clone).boxed().distinct().toArray(Integer[]::new);
        // 내림차순 정렬 : reverseOrder() 없으면 오름차순 기본
        Arrays.sort(result, Collections.reverseOrder());
        // int형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();

    }
}
