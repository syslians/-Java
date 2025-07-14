package Lily.src.week3.C08_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P23_ReportResult {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석
        * 두 번째, 제한조건 파악 및 테스트 케이스 추가
        * 세 번째, 입력값 분석
        *
        * 책 - 문제 분석하고 풀기 참조
        *
        * reportedUser
        * 신고당한 유저 - 신고한 유저...
        * 한 유저를 여러번 신고해도 신고 횟수는 1회로 처리 -> 해시맵의 value에 중복있으면 안되므로 해시셋 이용
        * reportedUser를 순회하면서 신고자가 k명 이상인지 확인
        *
        * 정답 - 정지당한 유저가 있을 때 이를 신고한 유저에게 알린 횟수
        * count
        * 해시맵... 키:신고한 유저, 값:처리 결과 메일을 받은 횟수...
        * 신고자가 k명 이상이면 정지된 것이므로, 신고자의 결과 통보 메일 수신 횟수 +1

        *
        * */
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String,Integer> count = new HashMap<>();

        // 1. 신고 기록 순회
        for (String r: report) {
            String[] s = r.split(" ");
            String userId = s[0]; // 신고자
            String reportedId = s[1]; // 신고당한 사람

            if (!reportedUser.containsKey(reportedId)) { // 2. 신고당한 기록이 없다면
                reportedUser.put(reportedId, new HashSet<>()); // 해시맵은 키에 대한 기본값이 없으므로... 해당 키-값 데이터가 없다면 우선 키에 대한 값을 추가해주어야 한다. 키에 대한 값이 없으면 새로운 해시셋으로 초기화한다.
            }
            // 3. 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry: reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) { // 4. 정지 기준에 만족하는지 확인
                for (String uid: entry.getValue()) { // 5. 해시셋을 순회하며 count 계산
                    count.put(uid, count.getOrDefault(uid, 0)+1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        // 6. 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i=0; i<id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}

// 시간복잡도 O(N) 책 참조..