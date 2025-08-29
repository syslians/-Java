package week9;

import java.util.Scanner;

class BaekJoon5355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = sc.nextInt();       // 물건 가격 입력
        int change = 1000 - price;      // 거슬러 줄 돈
        int count = 0;

        int[] coins = {500, 100, 50, 10, 5, 1}; // 동전 단위

        for (int coin : coins) {
            count += change / coin;   // 해당 동전으로 줄 수 있는 개수
            change %= coin;           // 남은 돈 갱신
        }
        sc.close();
        System.out.println(count);
    }
}
