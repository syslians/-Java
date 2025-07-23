```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem42579 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public static int[] solution(final String[] genres, final int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Map<Integer, Integer>> temp = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            final String name = genres[i];
            map.put(name, map.getOrDefault(name, 0) + plays[i]);

            if (temp.get(name) == null) {
                temp.put(name, new HashMap<>());
            }

            temp.get(name).put(i, plays[i]);
        }

        int limit = 2;
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(it -> {
                    List<Map.Entry<Integer, Integer>> count = temp.get(it.getKey()).entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                            .collect(Collectors.toList());

                    for (int i = 0; i < count.size(); i++) {
                        if (i == limit) {
                            break;
                        }

                        list.add(count.get(i).getKey());
                    }
                });

        return list.stream().mapToInt(Integer::intValue)
                .toArray();
    }
}
```