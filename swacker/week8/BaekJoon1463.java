package week8;

import java.util.Scanner;

class BaekJoon1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 0; // 1은 이미 1이므로 연산 필요 없음

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 빼는 경우

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[N]);
        sc.close();
    }
}
