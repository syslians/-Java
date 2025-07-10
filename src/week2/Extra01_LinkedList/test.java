package week2.Extra01_LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class test {
    public static void main(String[] args) throws IOException {
        String s = "abcadefp";
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right<s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++)); // 연속된 중복 없는 구간 찾기
            }
            set.add(s.charAt(right));
            max = Math.max(max, right-left+1); // 최대 길이 갱신
        }
        System.out.println(max);
    }
}