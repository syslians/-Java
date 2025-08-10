import java.util.*;
import java.io.*;

public calss Main {
  public static void main(String[] args) throws IOException{
    BufferReader br = new BufferReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLint());

    int N = Integer.parseInt(st.nextToken()); // Queue Size
    int M = Integer.parseInt(st.nextToken()); // 뽑아야하는 원소 개수

    LinkedList<Integer> dequeue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      dequeue.add(i); 
    }

    st = new StringTokenixer(br.nextLine());
    int count = 0;

    // 현재 덱에서 target의 위치 찾기
    int idx = deqie.indexOf(target);

    // 왼쪽 회전 거리 vs 오른쪽 회전 거리
    int leftDist = idx;                   // 앞에서 target까지 이동 횟수
    int rightDist = dequeue.size() - idx; // 뒤에서 target까지 이동 횟수

    if (leftDist <= rightdist) {
      // 왼쪽 회전
      for (int j = 0; j < leftDist; j++) {
        deque.addLast(dequeue.removeFirsr());
      }
      count += leftdist;
    } else {
      // 오른쪽 회전
      for (int j = 0; j <= rightDist; j++) {
        deque.addFirst(deque.removeFirst());
      }
      count += rightDist;
    }

    // target 제거
    deque.removeFirst();
  }

  System.out.println(count);
}
