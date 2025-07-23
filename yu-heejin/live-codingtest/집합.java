import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> s = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());

        for (int t = 0; t < m; t++) {
            String[] input = br.readLine().split(" ");
            int value = 0;

            if (!input[0].equals("all") && !input[0].equals("empty")) {
                value = Integer.parseInt(input[1]);
            }
            
            switch (input[0]) {
                case "add":
                    if (s.indexOf(value) == -1) {
                        s.add(value);
                    }
                    break;
                case "remove":
                    int removeIndex = s.indexOf(value);
                    if (removeIndex != -1) {
                        s.remove(removeIndex);
                    }
                    break;
                case "check":
                    if (s.indexOf(value) != -1) {
                        bw.write(1 + "\n");
                        bw.flush();
                    } else {
                        bw.write(0 + "\n");
                        bw.flush();
                    }
                    break;
                case "toggle":
                    int toggleIndex = s.indexOf(value);
                    if (toggleIndex == -1) {
                        s.add(value);
                    } else {
                        s.remove(toggleIndex);
                    }
                    break;
                case "all":
                    Collections.sort(s);
                    break;
                case "empty":
                    s = new ArrayList<Integer>();
            }
        }
    }
}