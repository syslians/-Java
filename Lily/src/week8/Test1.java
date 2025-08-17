package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim()); // 테스트케이스 개수

        int n = 11;
        int[] dp = new int[n+1];
        dp[0] = 1; // 아무것도 안더하는 경우
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 22
        dp[3] = 4; // 1_1_1, 1+2, 2+1, 3

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            // dp[4] = dp[3] + dp[2] + dp[1] = 4 + 2 + 1 = 7
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine().trim());
            sb.append(dp[input]).append("\n");
        }
        System.out.println(sb);
    }
}
