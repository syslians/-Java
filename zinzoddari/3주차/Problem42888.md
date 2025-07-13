```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem42888 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public static String[] solution(final String[] record) {
        Map<String, String> map = new HashMap<>();

        Map<String, String> commandMap = Map.of(
                "Enter", "님이 들어왔습니다.",
                "Leave", "님이 나갔습니다."
        );

        List<Print> temp = new ArrayList<>();

        for (String it : record) {
            StringTokenizer stringTokenizer = new StringTokenizer(it, " ");

            final String command = stringTokenizer.nextToken();

            final String uid = stringTokenizer.nextToken();

            if ("Enter".equals(command) || "Change".equals(command)) {
                final String nickname = stringTokenizer.nextToken();

                map.put(uid, nickname);
            }

            if ("Enter".equals(command) || "Leave".equals(command)) {
                temp.add(new Print(command, uid));
            }
        }

        String[] result = new String[temp.size()];

        for (int i = 0; i < temp.size(); i++) {
            result[i] = map.get(temp.get(i).getUid()) + commandMap.get(temp.get(i).getCommand());
        }

        return result;
    }
}


class Print {
    private String command;
    private String uid;

    public Print(String command, String uid) {
        this.command = command;
        this.uid = uid;
    }

    public String getCommand() {
        return command;
    }

    public String getUid() {
        return uid;
    }
}
```