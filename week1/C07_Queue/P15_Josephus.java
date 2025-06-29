package week1.C07_Queue;

import java.util.ArrayDeque;

public class P15_Josephus {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개어 분석하라
        * N명의 사람이 원 형태로 서있음
        * 각 사람은 1부터 N까지 번호표를 갖고 있음.. ㅋㅋㅋㅋ오징어게임 보고 문제 푸니까 다 오징어 게임같넨ㅋㅋㅋ
        * 그리고 임의의 숫자 K기 주어졌을 때, 다음과 같이 사람을 없앱니다... (예? 진짜 오징어 게임입니까...??하하;;;;;하하하하ㅏ하)
        * *이 문제는 유대인 역사가인 프라비우스 요세푸스가 만든 문제입니다.
        *
        * 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다.
        * 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다
        *
        * N과 K가 주어졌을 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수를 구현해주세요
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
        * [ 제약조건 ]
        * N과 K는 1이상 1000이하의 자연수입니다.
        *
        * 세 번째, 입력사항을 분석하라
        * 입출력의 예
        * N 5, K 2, return 3
        *
        *
        * */
        System.out.println(Solution15.solution(5, 2));

    }
}

class Solution15 {
    static int solution(int N, int K) {
        // 1부터 N까지의 번호를 deque에 추가
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            deque.addLast(i);
        }

        // deque에 하나의 요소가 남을 때까지 반복
        while (deque.size() >1) {
            // K번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
            for (int i=0; i<K-1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst(); // K번째 요소 제거
        }
        return deque.pollFirst(); // 마지막으로 남은 요소 반환
    }
}

// 책. 시간복잡도
// N : w전체 사람 수, K : 제거된 사람의 번호. K-1번 poll하고 1번 add하는 동작을 N번 반복하므로..
// 최종 시간 복잡도는 O(N*K) 입니다.