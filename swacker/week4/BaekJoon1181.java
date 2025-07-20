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
        Set<String> wordSet = new HashSet<>();
        String input;
        System.out.println("단어 입력 ('exit' 입력 시 종료 및 정렬 결과 출력):");

        // 단어 입력 받기 ('exit'이 입력되면 중단)
        while (true) {
            input = br.readLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            wordSet.add(input);
        }

        // Set을 List로 변환 후 정렬
        List<String> words = new ArrayList<>(wordSet);
        words.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder())
        );

        // 출력
        System.out.println("\n정렬 결과:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
