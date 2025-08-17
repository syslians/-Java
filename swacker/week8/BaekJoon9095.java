package week8;

import java.util.Scanner;

class BaekJoon9095 {
    static int[] dp = new int[11]; // n이 10 이하

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < 11; i++) dp[i] = -1; // 초기화

        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(topDown(n));
        }
        sc.close();
    }

    static int topDown(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        if(dp[n] != -1) return dp[n];
        return dp[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
    }
}
