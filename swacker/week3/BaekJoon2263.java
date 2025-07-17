package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2263 {
    static int[] inorder, postorder;
    static int[] index; // 값 -> 인덱스 맵핑
    static StringBuilder sb = new StringBuilder();

    static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        // 루트는 postorder의 마지막 값
        int root = postorder[postEnd];
        sb.append(root).append(" ");

        // 루트의 인오더 인덱스
        int rootIndex = index[root];
        int leftSize = rootIndex - inStart;

        // 왼쪽 서브트리
        getPreorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        // 오른쪽 서브트리
        getPreorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        index = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            index[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        getPreorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }
}
