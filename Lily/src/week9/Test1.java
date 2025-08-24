package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    // 백준 5585번 : 거스름돈
    // JOI잡화점에서는 언제나 거스름돈 개수가 가장 적게 잔돈을 준다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine()); // 물건 가격
        int change = 1000 - price; // 거스름돈
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0; // 거스름돈의 개수

        for (int c : coins) {
            count += change/c;
            change %= c;
        }
        System.out.println(count);
    }
}
