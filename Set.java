import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine()); // 연산 수 입력
        List<Integer> set = new ArrayList<>(); // ArrayList로 집합 표현

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken(); // 연산 명령어
            int x;

            switch (operation) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    if (set.indexOf(x) == -1) { // 중복 확인
                        set.add(x); // 요소 추가
                    }
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    int removeIndex = set.indexOf(x); // 요소 위치 찾기
                    if (removeIndex != -1) { // 요소가 있으면 제거
                        set.remove(removeIndex);
                    }
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if (set.indexOf(x) != -1) { // 요소 존재 확인
                        sb.append("1\n"); // 있으면 1 출력
                    } else {
                        sb.append("0\n"); // 없으면 0 출력
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    int toggleIndex = set.indexOf(x); // 요소 위치 찾기
                    if (toggleIndex == -1) { // 없으면 추가
                        set.add(x);
                    } else { // 있으면 제거
                        set.remove(toggleIndex);
                    }
                    break;
                case "all":
                    set.clear(); // 기존 집합 비우기
                    for (int j = 1; j <= 20; j++) { // 1~20 추가
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear(); // 집합 비우기
                    break;
            }
        }

        System.out.print(sb); // 결과 출력
        br.close();
    }
}