package week3.C08_Hash;

import java.util.HashMap;

public class P19_PlayerNotDone {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개어 분석하라
        *
        * 많은 선수 중 단 한명의 선수를 제외하고 모든 선수가 마라톤 완주함
        * participant : 마라톤에 참여한 선수들의 이름이 담긴 배열
        * completion : 완주한 선수들의 이름이 담긴 배열
        * 완주하지 못한 선수의 이름을 반환하는 solution() 함수를 작성해라.
        *
        * 두 번째, 제약 사항을 파악하고 테스트케이스를 추가하라
        * [제약 조건]
        * 마라톤 경기에 참여한 선수 수는 1명 이상 100,000명 이하입니다.
        * -> 아까 문제 18번처럼, 일일히 비교해서 완주 못한 사람 찾으면 O(N^2)..
        * -> O(NlogN) 또는 O(N)알고리즘을 찾아야 합니다..(책)
        * completion 길이는 participant 길이보다 1 작습니다.
        * 참가자 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        * 참가자 중에는 동명이인이 있을 수 있습니다.
        *
        * 세 번째, 입력값을 분석하라
        * [입출력의 예]
        * participant ["leo", "kiki", "eden"]
        * completion ["eden","kiki"]
        * return "leo"
        *
        * */
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

    }

    private static String solution(String[] participant, String[] completion) {
        // 1. 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 2. 완주한 선수들의 이름을 해시맵에 저장
        for (String string: completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        // 3. 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for (String string: participant) {
            // 4. 완주하지 못한 선수를 찾으면 반환
            if (hashMap.getOrDefault(string, 0) == 0) {
                return string;
            }
            hashMap.put(string, hashMap.get(string)-1);
        }
        return null;
    }
}

// 시간 복잡도 분석하기(책)
// N : participant 길이, K : completion 길이
// 완주한 선수들의 이름을 해시맵에 추가하는 연산의 시간 복잡도 O(K)
// 참가자의 이름을 해시맵에서 제외하는 연산의 시간 복잡도는 O(N)
// 추가로, completion의 최대 길이는 N-1이므로 K대신  N-1로 대체하면
// 시간 복잡도는 O(2* (N-1)) -> O(N)