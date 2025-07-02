package week2.Extra01_LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class E03_Yose {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // 7 3
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for( int i=1; i<=n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (!list.isEmpty()) {
            index = (index+k-1) % list.size(); // 회전 인덱스
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}