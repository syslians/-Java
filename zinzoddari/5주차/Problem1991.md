```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1991 {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static String get() {
        if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return stringTokenizer.nextToken();
    }

    private static int getValue() {
        return Integer.parseInt(get());
    }

    private static char[][] tree = new char[26][2];

    public static void main(String[] args) {
        int n = getValue();

        for (int i = 0; i < n; i++) {
            String parent = get();
            String left = get();
            String right = get();

            int idx = parent.charAt(0) - 'A';
            tree[idx][0] = left.charAt(0);
            tree[idx][1] = right.charAt(0);
        }

        preorder('A');
        stringBuilder.append('\n');
        inorder('A');
        stringBuilder.append('\n');
        postorder('A');

        System.out.println(stringBuilder.toString().trim());
    }

    private static void preorder(char node) {
        if (node == '.') {
            return;
        }

        stringBuilder.append(node);
        preorder(tree[node - 'A'][0]);
        preorder(tree[node - 'A'][1]);
    }

    private static void inorder(char node) {
        if (node == '.') {
            return;
        }

        inorder(tree[node - 'A'][0]);
        stringBuilder.append(node);
        inorder(tree[node - 'A'][1]);
    }

    private static void postorder(char node) {
        if (node == '.') {
            return;
        }

        postorder(tree[node - 'A'][0]);
        postorder(tree[node - 'A'][1]);
        stringBuilder.append(node);
    }
}
```