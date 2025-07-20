package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0; // 집합 S를 비트마스킹(000..0)으로 표현

        int M = Integer.parseInt(br.readLine());

        label:
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input == null) break;
            StringTokenizer st = new StringTokenizer(input);
            String cmd = st.nextToken();

            switch (cmd) {
                case "stop":
                    // 프로그램 종료(중단)
                    break label;
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    S |= (1 << (x - 1)); // x번째 비트를 1로 설정

                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (x - 1)); // x번째 비트를 0으로 설정

                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append((S & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    S ^= (1 << (x - 1)); // x번째 비트를 반전

                    break;
                }
                case "all":
                    S = (1 << 20) - 1; // 20비트 모두 1로 설정 (111...1)

                    break;
                case "empty":
                    S = 0; // 전부 0

                    break;
            }
        }
        System.out.print(sb);
    }
}
