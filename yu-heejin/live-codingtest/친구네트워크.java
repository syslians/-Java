import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> friends = new HashMap<>();
            int friendNumber = 1;
            
            // 최대 등장 가능한 친구의 수
            int[] parent = new int[f * 2];
            int[] connectedFriends = new int[f * 2];
            
            for (int i = 0; i < f; i++) {
                String[] input = br.readLine().split(" ");

                // Union-Find를 위한 Map 초기화
                if (friends.get(input[0]) == null) {
                    friends.put(input[0], friendNumber);
                    friendNumber++;
                }

                if (friends.get(input[1]) == null) {
                    friends.put(input[1], friendNumber);
                    friendNumber++;
                }
            }
        }
    }

    private static void find(int a, int b) {
        
    }

    private static void union(int a, int b) {
        
    }
}