package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaekJoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine().trim());
        }
        List<String> list = new ArrayList<>(set);
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length())
                return s1.length() - s2.length();
            else
                return s1.compareTo(s2);
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
