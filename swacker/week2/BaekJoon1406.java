package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : br.readLine().toCharArray()) left.push(c);
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L': if (!left.isEmpty()) right.push(left.pop()); break;
                case 'D': if (!right.isEmpty()) left.push(right.pop()); break;
                case 'B': if (!left.isEmpty()) left.pop(); break;
                case 'P': left.push(cmd.charAt(2)); break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.print(sb);
    }
}
