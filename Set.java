import java.io.*;
import java.util;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine()); // 연산 수 입력
        int set = 0; // 비트마스크로 집합 표현 (초기 공집합)

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken(); // 연산 명령어
            int x;

            switch (operation) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set |= (1 << (x - 1)); // x번째 비트를 1로 설정 (추가)
                    break;
                case "remove":
                    /**/
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if ((set & (1 << (x - 1))) != 0) { // x번째 비트가 1인지 확인
                    /**/
                    }                                     
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    set ^= (1 << (x - 1)); // x번째 비트를 반전
                    break;
                case "all":
                    set = (1 << 20) - 1; // 1~20 비트를 모두 1로 설정
                    break;
                case "empty":
                    set = 0; // 모든 비트를 0으로 설정
                    break;
            }
        }

        System.out.print(sb); // 결과 출력
        br.close();
    }
}
