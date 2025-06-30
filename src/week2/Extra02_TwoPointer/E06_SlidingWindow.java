package week2.Extra02_TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class E06_SlidingWindow {
    public static void main(String[] args) {
        // 목표 : 가장 긴 중복 없는 부분 문자열 길이
        String s = "abcadefp"; //abcabcbb
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right=0; right<s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++)); // 연속된 중복 없는 구간 찾기...
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left +1); // 최대 길이 갱신
        }
        System.out.println(max);
    }
}
