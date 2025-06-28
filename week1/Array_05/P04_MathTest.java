package week1.Array_05;

import java.util.ArrayList;
import java.util.Arrays;

public class P04_MathTest {
    /*
    * 첫 번째, 문제를 쪼개기. 분석하기
    * 수포자1 찍는 방식 저장
    * 수포자2 찍는 방식 저장
    * 수포자3 찍는 방식 저장
    * 1번부터 마지막 문제까지 정답이 순서대로 저장된 배열 answers 주어짐
    * 각각 문제 맞힌 갯수 구하기
    * 가장 문제를 많이 맞힌 사람 배열에 담아 반환하기
    *
    * 두 번째, 제약사항 파악 및 테스트케이스 추가
    * 제약 조건
    * 시험은 최대 10,000 문제로 구성되어 있다
    * 문제의 정답은 1,2,3,4,5 중 하나입니다
    * 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬하세요
    *
    * 세 번째, 입력사항 분석하기
    * 시간복잡도 N이 10000 이므로.. O(NlogN) 이하..
    *
    *
    * */

    public static void main(String[] args) {

        // 정답 임으로 셋팅
        int[] answers = new int[] {1, 3, 2, 4 ,2};


        System.out.println(Arrays.toString(solution(answers)));
    }

    private static int[] solution(int[] arr) {

        int[] answers = arr.clone();

        // 기록1 : 배열에 담아서 보내려 했더니, 파라미터 수도 많아지고, solution 안에서 계산하기도 복잡함
        // 책에처럼 이차원 배열에 담아서 한번에 보내보자
//        int[] mathMan1 = new int[] {1, 2, 3, 4 ,5};
//        int[] mathMan2 = new int[] {2, 1 ,2, 3, 2, 4, 2, 5};
//        int[] mathMan3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] pattern = new int[][] {
                {1, 2, 3, 4 ,5}, // pattern[0].length -> 5
                {2, 1 ,2, 3, 2, 4, 2, 5}, // pattern[1].length -> 8
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // pattern[2].length -> 10
        };

        // 수포자 점수 저장할 배열
        int[] scores = new int[3];
//
        // 정답 일치 확인
        // i : 0 0 0 / 1 1 1
        // j : 0 1 2 / 0 1 2
        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    // answers[0] == pattern[0][0%5] -> pattern[0][0]
                    // answers[0] == pattern[1][0%8] -> pattern[1][0]
                    // answers[0] == pattern[2][0%10] -> pattern[2][0]
                    // answers[1] == pattern[0][1%5] -> pattern[0][1]
                    // answers[1] == pattern[1][1%8] -> pattern[1][1]
                    // answers[1] == pattern[2][1%10] -> pattern[2][1]
                    // answers[2] == pattern[0][2%5] -> pattern[0][2]
                    // answers[2] == pattern[1][2%8] -> pattern[1][2]
                    // answers[2] == pattern[2][2%10] -> pattern[2][2]
                    // ...
                    // answers[4] == pattern[0][4%5] -> pattern[0][4]
                    // answers[4] == pattern[1][4%8] -> pattern[1][4]
                    // answers[4] == pattern[2][4%10] -> pattern[2][4]
                    // answers[5] == pattern[0][5%5] -> pattern[0][0] : 정답길이 > 패턴길이 경우 : 처음 데이터로 시작..

                    scores[j]++;
                }
            }
        }

        // 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 책. 시간복잡도 계산
// N : answers의 길이
// 수포자들의 패턴과 정답을 비교하는 부분 : O(N)
// scores를 순회하면서 가장 높은 점수를 받은 수포자르 추가하는 연산 : O(N)