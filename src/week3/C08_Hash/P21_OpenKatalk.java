package src.week3.C08_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P21_OpenKatalk {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개어 분석하기
        * [닉네임]님이 들어왔습니다
        * [닉네임]님이 나갔습니다
        *
        * 채팅창에서 닉네임 변경방법
        * 1. 채팅방을 나간 후 새로운 닉네임으로 변경
        * 2. 채팅방에서 닉네임 변경
        *
        * - 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 바뀜
        * Muzi가 나간 후 Prodo라는 닉네임으로 들어올 경우 기존 채팅방에 남아있는 닉네임도 변경됨
        * Muzi님이 들어왔습니다.
        * Prodo님이 들어왔습니다.
        * Muzi님이 나갔습니다.
        * ------------------>Muzi 를 Prodo로 변경 후 재입장
        * Prodo님이 들어왔습니다.
        * Prodo님이 들어왔습니다.
        * Prodo님이 나갔습니다.
        * Prodo님이 들어왔습니다.
        *
        * 중복 닉네임을 허용하믕로.. 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 2명임
        * 맨 처음 해팅방에 두 번째로 들어왔던 Prodo -> Ryan 으로 닉네임을 변경하면...
        *
        * Prodo님이 들어왔습니다.
        * Ryan님이  들어왔습니다.
        * Prodo님이 나갔습니다.
        * Prodo님이 들어왔습니다.
        *
        * 이렇게 바뀜.
        *
        * record : 채팅방에 들어오고 나가거나 닉네임을 변경한 기록이 담긴 문자열 배열 record
        * 모든 기록이 처리된 다음 최종으로 방을 개설한 사람이 보는 메시지를 문자열 배열 형태로 반환...
        *
        * 두 번째, 제약사항을 파악하고, 테스트케이스를 추가하라
        * [제약 조건]
        * record 문자열이 담긴 배열. 길이는 1이상 100,000 이하
        * 모든 유저는 [유저 이이디]로 구분
        * [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장
        *   "Enter [유저 아이디] [닉네임]" (예 : "Enter uid1234 Muzi")
        * [유저 아이디] 사용자가 채팅방에서 퇴장
        *   "Leave [유저 아이디" (예: "Leave uid1234")
        * [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경
        *   "Change [유저 아이디] [닉네임]" (예: "Change uid1234 Muzi")
        * 첫 단어는 Enter, Leave, Change 중 하낭미각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어짐
        * 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별
        * 유저 아이디와 닉네임의 길이는 1이상 10이하
        * 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못된 입력은 주어지지 않음
        *
        * 세 번째, 입력값을 분석하라
        * [입출력의 예]
        * record ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234, "Enter uid1234 Prodd", "Change uid4567 Ryan"]
        * result ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
        *
        * --------------------------------------------------------
        *
        *
        * (책) 궁극적으로 코딩 테스트를 잘하려면...
        * 이렇게 피룡한 질문을 하고 스스로 답하는 것이 중요합니다!!!!
        *
        * */
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    private static String[] solution(String[] record) {
        // Enter/Leave 메시지를 저장할 해시맵 생성
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다."); // 상태 상태값
        msg.put("Leave", "님이 나갔습니다.");
        System.out.println(msg.toString());

        HashMap<String, String> uid =  new HashMap<>();

        // 1. record의 각 줄을 하나씩 처리
        for (String s: record) {
            String[] cmd = s.split(" ");
            if (cmd.length == 3) { // 2. Enter 또는 Change인 경우
                uid.put(cmd[1], cmd[2]); // 유저아이디 닉네임
            }
            System.out.println(uid.toString());
        }

        // 답을 저장할 answer List 생성
        ArrayList<String> answer = new ArrayList<>();
        // 3. record의 각 줄을 하나씩 처리
        for (String s: record) {
            String[] cmd =  s.split(" ");
            // 4. 각 상태에 맞는 메시지를 answer에 저장
            if (msg.containsKey(cmd[0])) {
                answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }

        return answer.toArray(new String[0]);
    }
}

// (책) 시간 복잡도
// N record의 길이... 첫 번째 반복문에서 record의 모든 항목을 순회하므로 시간 복잡도는 O(N)
// 두 번째 반복문의 시간 복잡도는 O(N). 따라서 최종 시간 복잡도는 O(N)