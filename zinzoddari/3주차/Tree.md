```java
import java.util.Arrays;

public class Tree {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    public static String[] solution(final int[] nodes) {
        //왼쪽 자식 노드 : 부모 노드 배열 인덱스 * 2 + 1
        //오른쪽 자식 노드 : 부모 노드의 배열 인덱스 * 2 + 2
        final String[] result = new String[3];

        //기준은 부모.
        //전위 : 부모 -> 왼쪽 -> 오른쪽
        //중위 : 왼쪽 -> 부모 -> 오른쪽
        //후위 : 왼쪽 -> 오른쪽 -> 부모
        result[0] = before(nodes, 0).trim();
        result[1] = middle(nodes, 0).trim();
        result[2] = after(nodes, 0).trim();

        return result;
    }

    private static String before(int[] nodes, int target) {
        if (target >= nodes.length) {
            return "";
        }

        return nodes[target] + " "
                + before(nodes, target * 2 + 1)
                + before(nodes, target * 2 + 2);
    }

    private static String middle(int[] nodes, int target) {
        if (target >= nodes.length) {
            return "";
        }

        return middle(nodes, target * 2 + 1)
                + nodes[target] + " "
                + middle(nodes, target * 2 + 2);
    }

    private static String after(int[] nodes, int target) {
        if (target >= nodes.length) {
            return "";
        }

        return after(nodes, target * 2 + 1)
                + after(nodes, target * 2 + 2)
                + nodes[target] + " ";
    }

    public static int get(final int target, final int weight) {
        return target * 2 + weight;
    }
}

```