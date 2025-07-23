package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaekJoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 줄 N 입력
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }
        List<String> words = new ArrayList<>(wordSet);
        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        for (String word : words) {
            System.out.println(word);
        }
    }
}
