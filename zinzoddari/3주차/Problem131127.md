```java
import java.util.HashMap;
import java.util.Map;

public class Problem131127 {
    public static void main(String[] args) {
        System.out.println((solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})));
        System.out.println((solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})));
    }

    public static int solution(final String[] want, final int[] number, final String[] discount) {
        Map<String, Integer> wish = new HashMap<>();

        int result = 0;

        for (int i = 0; i < want.length; i++) {
            wish.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> temp = new HashMap<>();

            for (int j = i; j < i + 10; j++) {

                if (!wish.containsKey(discount[j])) {
                    break;
                }

                temp.put(discount[j], temp.getOrDefault(discount[j], 0) + 1);
            }

            if (wish.equals(temp)) {
                result++;
            }
        }

        return result;
    }
}
```