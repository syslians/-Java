```java
package com.example.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * https://www.acmicpc.net/problem/2263
 */

public class Problem7785 {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer stringTokenizer;

    private static StringBuilder stringBuilder = new StringBuilder();

    private static String get() {
        if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return stringTokenizer.nextToken();
    }

    private static int getValue() {
        return Integer.parseInt(get());
    }

    public static void main(String[] args) {
        int n = getValue();

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            final String name = get();
            final String command = get();

            if ("enter".equals(command)) {
                set.add(name);
                continue;
            }

            set.remove(name);
        }


        for (String it : set) {
            stringBuilder.append(it).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}

```