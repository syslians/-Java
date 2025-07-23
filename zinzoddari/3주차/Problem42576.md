```java
import java.util.HashMap;
import java.util.Map;

public class Problem42576 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String dd : map.keySet()) {
            if (dd.equals("marina")) {
                map.remove(dd);
            }
        }

        for (String name : participant) {
            if (map.containsKey(name)) {
                if (map.get(name) == 1) {
                    map.remove(name);
                    continue;
                }

                map.put(name, map.get(name) - 1);
                continue;
            }

            return name;
        }

        return null;
    }
}

```