```java
package com.example.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem10815 {
    // N : 가지고 있는 숫자 카드 개수
    // 카드에 적혀있는 정수
    // M : 비교해야 할 갯수
    // M개의 숫자 중에 존재하는게 있는지 확인

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer stringTokenizer;

    private static StringBuilder stringBuilder = new StringBuilder();

    private static int get() {
        if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return Integer.parseInt(stringTokenizer.nextToken());
    }

    public static void main(String[] args) {

        final int N = get();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            final int input = get();

            set.add(input);
        }

        final int M = get();

        for (int i = 0; i < M; i++) {
            final int input = get();

            if (set.contains(input)) {
                stringBuilder.append("1").append(" ");
                continue;
            }

            stringBuilder.append("0").append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }
}

```