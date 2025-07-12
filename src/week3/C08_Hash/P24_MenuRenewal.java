package src.week3.C08_Hash;

import java.util.*;

/*
* 이건 문제 이해부터 잘 안된다 ㅠ ㅠ 이해해서 쓰려니...재귀가 이해안감ㅋㅋㅋㅋㅋㅋ
* 아니!!! 중딩때부터 배운건데 왜이럼.. ㅠ ㅠ 엉엉
* ㅋㅋㅋㅋ오카방에서 재귀만화도 그려주시는데... 그래서 이번엔 이해할 수 있게 이론적으로 설명해 주시는거죠?ㅎㅎㅎㅎㅎ
* 일단... 내일 수학과 친구 만나면ㅋㅋㅋ 재귀 개념 물어보고..아니 나도 재귀 개념은 안다고오!!! 진짜 아는건가?
*
* 그리고, stream API 쓰는거 왤케 어렵게 느껴지누.. 어색해서 그러겠지.. 저자님은 저걸 어케 짜는겨..
* 그래도 별 3개여서 해보고 트리 하자 했는데, 역시 트리하고나서 도전했어야 했나...!
* 무튼 일단 여기서 중지하고 다음에 다시 보겠으! 2025.7.12
*
* orders : 각 손님들이 주문한 단품 메뉴들이 문자열 형식으로 담긴 배열
* course : 스카피가 추가하고 싶어하는 코스 요리를 구성하는 단품 메뉴들의 개수가 담긴 배열
* 스카피가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 반환...
*
*
*
* */
public class P24_MenuRenewal {
    // 만들 수 있는 메뉴 구성과 총 주문 수를 저장하라 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 1. 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 2. 모든 코스 후보에 대해서
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o)) // 3. 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet().stream()
                    .filter(entry -> cnt.equals(entry.getValue()) && cnt >1)
                    .forEach(entry -> answer.add(entry.getKey()))); // 6. 코스 메뉴만 answer 리스트에 추가
        }
        Collections.sort(answer); // 7. 오른차순으로 정렬
        return answer.toArray(new String[0]);
    }

    // 만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, String result) {
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1 증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i=idx; i<order.length; i++) {
            combinations(i+1, order, result + order[i]);
        }
    }

}
