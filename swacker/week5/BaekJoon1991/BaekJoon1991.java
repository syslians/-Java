package week5.BaekJoon1991;

import java.util.Scanner;

public class BaekJoon1991 {
    static Node[] nodes = new Node[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node((char)(i + 'A'));
        }

        for (int i = 0; i < N; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            nodes[root - 'A'].left = (left == '.') ? null : nodes[left - 'A'];
            nodes[root - 'A'].right = (right == '.') ? null : nodes[right - 'A'];
        }

        preorder(nodes[0]);  // 'A' 노드는 0번 인덱스
        System.out.println();
        inorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);
    }

    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
