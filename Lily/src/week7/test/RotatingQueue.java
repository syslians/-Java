package week7.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotatingQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 큐의크기
        int m = Integer.parseInt(st.nextToken()); // 뽑아내려는 수의 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int moves = 0;

        for (int i = 0; i <m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = deque.indexOf(target); // List의 메서드라서 변수선언을 Deque<Integer>가 아니라, LinkedList<Integer>로 해야 한다고 함.
            int left = index; // 왼쪽으로 index번
            int right = deque.size()-index; // 오른쪽으로 size-index번

            // 더 적은 쪽으로 회전
            if (left <= right) {
                for (int j = 0; j<left; j++) {
                    deque.addLast(deque.removeFirst());
                }
                moves += left;
            } else {
                for (int j = 0; j < right; j++) {
                    deque.addFirst(deque.removeLast());
                }
                moves += right;
            }
            deque.removeFirst(); // 타겟이 맨 앞이되면 꺼내기
        }
        System.out.println(moves);
    }
}
