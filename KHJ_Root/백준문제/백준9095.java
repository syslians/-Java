import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] dp = bew int[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (inr i = 4; i <= 11; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    for (int i  = 0; i < t; i++) {
      int n = sc.nextInt();
      System.out.println(dp[n]);
    }
  }
}
