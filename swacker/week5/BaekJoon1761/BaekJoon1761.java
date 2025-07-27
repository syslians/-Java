package week5.BaekJoon1761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1761 {
    static int n, h;
    static List<Node>[] adj;
    static int[][] parent;
    static int[] depth, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        // log2(n) + 1
        h = (int)(Math.log(n) / Math.log(2)) + 1;
        parent = new int[n + 1][h];
        depth = new int[n + 1];
        dist = new int[n + 1];

        // 트리 정보와 거리, parent 채우기
        dfs(1, 0, 0, 0);

        // parent [각 2^i 위 부모] 채우기
        for (int i = 1; i < h; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = getLCA(a, b);
            int len = dist[a] + dist[b] - 2 * dist[lca];
            sb.append(len).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int v, int p, int d, int w) {
        depth[v] = d;
        dist[v] = w;
        parent[v][0] = p;
        for (Node nxt : adj[v]) {
            if (nxt.to != p) dfs(nxt.to, v, d + 1, w + nxt.w);
        }
    }

    static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a; a = b; b = tmp;
        }
        for (int i = h - 1; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[a][i];
            }
        }
        if (a == b) return a;
        for (int i = h - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
