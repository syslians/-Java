package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2 {
    // 백준 11399번

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 줄서있는 사람 수
        int[] time = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            time[i] = Integer.parseInt(st.nextToken()); // 각 순서의 사람이 돈을 인출하는데 걸리는 시간
        }

        Arrays.sort(time); // 오름차순 정렬 : 시간 적은 순부터 기다려야, 가장 적게 기다림...

        int sum = 0;
        int result = 0;
        for (int t : time) {
            sum += t;
            result += sum; // 누적합 구하기
        }
        System.out.println(result);
    }
}
