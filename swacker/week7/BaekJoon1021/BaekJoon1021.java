package week7.BaekJoon1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BaekJoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) dq.addLast(i);

        st = new StringTokenizer(br.readLine());
        int ops = 0;

        for (int k = 0; k < M; k++) {
            int target = Integer.parseInt(st.nextToken());
            // LinkedList 구현체이므로 indexOf 사용 가능
            int idx = indexOf(dq, target);
            int size = dq.size();

            if (idx <= size - idx - 1) {
                // 왼쪽(앞)으로 idx만큼 회전
                for (int i = 0; i < idx; i++) {
                    dq.addLast(dq.pollFirst());
                    ops++;
                }
                // 이제 맨 앞이 target
                dq.pollFirst();
            } else {
                // 오른쪽(뒤)로 size - idx 만큼 회전
                int times = size - idx;
                for (int i = 0; i < times; i++) {
                    dq.addFirst(dq.pollLast());
                    ops++;
                }
                dq.pollFirst(); // 맨 앞이 target
            }
        }

        System.out.println(ops);
        br.close();
    }

    // Deque에는 직접 index 접근이 없으므로 순회로 인덱스 찾기
    private static int indexOf(Deque<Integer> dq, int value) {
        int idx = 0;
        for (int v : dq) {
            if (v == value) return idx;
            idx++;
        }
        return -1; // 존재 보장된 문제에서는 여기로 오지 않음
    }
}
