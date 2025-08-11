package week7.BaekJoon20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BaekJoon20055 {
    public static void main(String[] args) throws IOException {
        int N, K, turn = 0;
        int[] belt;
        boolean[] robots;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robots = new boolean[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) belt[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = N-1;

        while(true) {
            turn++;
            // 1. 벨트 회전
            start = (start + 2*N - 1) % (2*N);
            end = (end + 2*N - 1) % (2*N);
            robots[end] = false; // 내리는 위치에는 로봇 무조건 내림

            // 2. 로봇 이동
            for(int i=N-2; i>=0; i--) {
                int idx = (start + i) % (2*N);
                int next = (idx + 1) % (2*N);
                if(robots[idx] && !robots[next] && belt[next] > 0) {
                    robots[idx] = false;
                    robots[next] = true;
                    belt[next]--;
                }
            }
            robots[end] = false;

            // 3. 올리는 위치에 로봇 올리기
            if(belt[start] > 0 && !robots[start]) {
                robots[start] = true;
                belt[start]--;
            }

            // 4. 내구도 0 체크
            int cnt = 0;
            for(int life : belt)
                if(life == 0) cnt++;
            if(cnt >= K) break;
        }
        System.out.println(turn);
        br.close();
    }
}
