```java
import java.util.HashSet;
import java.util.Set;

public class Hash {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[] {2, 3, 5, 9}, 10));
    }

    public static boolean solution(final int[] arr, final int target) {

        Set<Integer> set = new HashSet<>();

        for (int it : arr) {
            if (set.contains(target - it)) {
                return true;
            }

            set.add(it);
        }

        return false;
    }
}

```