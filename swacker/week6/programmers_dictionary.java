package week6;

import java.util.ArrayList;
import java.util.List;

public class programmers_dictionary {
    List<String> list = new ArrayList<>();
    String[] chars = { "A", "E", "I", "O", "U" };

    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
    }

    void dfs(String word) {
        list.add(word);
        if (word.length() == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(word + chars[i]);
        }
    }
}
