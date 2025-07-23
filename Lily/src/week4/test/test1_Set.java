package Lily.src.week4.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class test1_Set {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        Set<Integer> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            String input1 = input[0];
            int input2 = 0;

            if (input.length == 2) {
                input2 = Integer.parseInt(input[1]);
            }

            switch (input1) {
                case "add" :
                    hs.add(input2);
                    break;
                case "remove" :
                    hs.remove(input2);
                    break;
                case "check" :
                    if (hs.contains(input2)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle" :
                    if(hs.contains(input2)) {
                        hs.remove(input2);
                    } else {
                        hs.add(input2);
                    }
                    break;
                case "all" :
                    hs.clear();
                    for (int j=0; j<20; j++) {
                        hs.add(j+1);
                    }
                    break;
                case "empty" :
                    hs.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
