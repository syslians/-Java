package week7.BaekJoon1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class BackJoon1966 {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority));
                pq.add(priority);
            }

            int printCount = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                if (current.priority == pq.peek()) { // 현재 문서가 최고 우선순위
                    pq.poll();
                    printCount++;

                    if (current.index == M) { // 찾는 문서면 출력 후 종료
                        sb.append(printCount).append("\n");
                        break;
                    }
                } else { // 뒤로 보냄
                    queue.add(current);
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
