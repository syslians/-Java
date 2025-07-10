package week3.C08_Hash;

import java.util.HashMap;

public class C08_Note {
    public static void main(String[] args) {
        // 개념은 코딩 테스트 합격자 되기_자바편 봤음!!! 그냥 책보셈!!
        // HashMap 클래스 사용하기
        // HashMap<KeyType, ValueType> 입니다
        HashMap<String, Integer> hashMap = new HashMap<>();

        // HashMap에 데이터 추가
        hashMap.put("ABC", 10);
        hashMap.put("BBB", 20);
        hashMap.put("AAA", 30);
        hashMap.put("ABC", 15);

        System.out.println(hashMap.isEmpty()); // false
        System.out.println(hashMap.get("ABC")); // 15
        System.out.println(hashMap.containsKey("ABC")); // true

        hashMap.remove("ABC");
        System.out.println(hashMap.size()); // 2

        hashMap.clear(); // 해시맵의 모든 데이터 삭제
        System.out.println(hashMap.isEmpty()); // true

    }
}
