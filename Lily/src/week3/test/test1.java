package Lily.src.week3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class test1 {
    public static void main(String[] args) {
        // 친구 네트워크 - 백준 4195번
        /*
        * 1. 문제를 쪼개어 분석하기
        * 민혁이가 소셜 네트워크 사이트에서 친구 모으는 것이 취미임.
        * 친구 관계가 생긴 순서대로 주어짐...
        * 두 사람의 친구 네트워크에 몇 명이 있는지 구해라
        * 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
        *
        *
        * 예제 입력1
        * 2
        * 3
        * A B
        * B C
        * B D
        * 3
        * A1 B1
        * C1 D1
        * B1 C1 -> 연결되는 친구가 있어야 친구 수가 확장됨.
        *
        * 예제 출력1
        * 2
        * 3
        * 4
        * 2
        * 2
        * 4 -> 연결되는 친구가 있어야 친구 수가 확장됨.
        *
        * */
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < testCase; i++) {
            int friendRelationCount = Integer.parseInt(br.readLine()); // 친구 관계 수

            for (int j = 0; j < friendRelationCount; j++) {
                String[] relation = br.readLine().split(" ");
                String f1 = relation[0];
                String f2 = relation[1];

                friendExtend(f1, f2);
            }
        }

    }

    public static int friendExtend(String f1, String f2) {
        HashMap<String, String> map = new HashMap<>();

        return 0;
    }

}
