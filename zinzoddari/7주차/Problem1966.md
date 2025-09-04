```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1966 {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int getValue() throws IOException {
        if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        }

        return Integer.parseInt(stringTokenizer.nextToken());
    }

    public static void main(String[] args) throws IOException {
        final int T = getValue();

        for (int i = 0; i < T; i++) {
            final int N = getValue();
            final int M = getValue();

            Queue<Document> priority = new PriorityQueue<>();
            Queue<Document> queue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                final Document document = new Document(j, getValue());
                priority.offer(document);
                queue.offer(document);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                final Document document = queue.poll();

                if (priority.peek().getImportance() == document.getImportance()) {
                    count++;
                    priority.poll();
                } else {
                    queue.offer(document);
                    continue;
                }

                if (document.getIndex() == M) {
                    stringBuilder.append(count).append("\n");
                    break;
                }
            }
        }

        System.out.println(stringBuilder.toString().trim());
    }

    static class Document implements Comparable<Document> {
        int index;
        int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }

        @Override
        public int compareTo(Document o) {
            return o.importance - importance;
        }

        public int getIndex() {
            return index;
        }

        public int getImportance() {
            return importance;
        }
    }
}
```