package week1.C05_Array;

import java.util.Arrays;

public class P05_MatrixMulti {
    public static void main(String[] args) {
        /*
        * 첫 번째. 문제를 쪼개서 분석하기
        * 2차원행렬 arr1, arr2 입력받기
        * arr1에 arr2를 곱하기
        * 결과 반환
        *
        * 두 번째. 제약사항 파악하기. 테스트케이스 추가하기
        * 제약 조건
        * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다
        * 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수입니다
        * 곱할 수 있는 배열만 주어집니다.
        *
        * 세 번째. 입력사항 분석하기
        * N이 ... arr1 100x100 arr2 100x100 -> 10^4, 10^4
        * 시간복잡도 구하는거 모르겠음.. 저자님꺼 참고.
        *
        * 책. 저자님 -> N은 행 혹은 열의 길이이다.
        * 행과 열의 길이는 같다...
        * arr1의 행과 열의 수를 r1, c1
        * arr2의 행과 열의 수를 r2, c2
        * r1*c1*c2만큼 연산한다.
        * 최종 시간복잡도는 O(N^3)
        *
        * */

        int[][] arr1 = new int[][] {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = new int[][] {{3,3}, {3,3}};

        System.out.println((Arrays.deepToString(solution(arr1, arr2))));

    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {

        // 행렬 arr1,  arr2의 행과 열의 수
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][c2];

        for (int i=0; i<r1; i++) {
            for (int j=0; j<c2; j++) {
                // 곱하기
                for (int k=0; k<c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
