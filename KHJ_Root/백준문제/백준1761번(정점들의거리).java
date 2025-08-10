import java.io.*;
import java.util.*;

class Edge {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<Edge>[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점 수 입력
        N = Integer.parseInt(br.readLine());
        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 (N-1개)
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w)); // 무방향 트리
        }

        // 쿼리 수 입력
        int M = Integer.parseInt(br.readLine());
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int distance = bfs(u, v);
            bw.write(distance + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // BFS로 두 정점 간 거리 계산
    static int bfs(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1); // -1: 미방문
        dist[start] = 0; // 시작점 거리 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == end) { // 목표 정점 도달
                return dist[curr];
            }

            for (Edge edge : graph[curr]) {
                int next = edge.vertex;
                int weight = edge.weight;
                if (dist[next] == -1) { // 미방문 정점
                    dist[next] = dist[curr] + weight;
                    queue.add(next);
                }
            }
        }

        return -1; // 도달 불가능 (트리이므로 발생하지 않음)
    }
}
