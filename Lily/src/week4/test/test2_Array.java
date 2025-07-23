package Lily.src.week4.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class test2_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i <N; i++) {
            hs.add(br.readLine());
        }
    }
}
