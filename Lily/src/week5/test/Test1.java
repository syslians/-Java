package week5.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Node> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            // 아래 방식은 챗gpt...형님의 풀이..
            // map에 해당 문자가 key로 없으면 Node를 새로 생성해서 추가하고,
            // 이미 있다면 기존 Node를 그대로 반환해서 parent.left에 연결
            Node parent = map.computeIfAbsent(root, Node::new);
            if (left != '.') parent.left = map.computeIfAbsent(left, Node::new);
            if (right != '.') parent.right = map.computeIfAbsent(right, Node::new);

            // 이것과 동일..
//            if (!map.containsKey(left)) {
//                map.put(left, new Node(left));
//            }
//            return map.get(left);
        }

        Node root = map.get('A'); // 항상 A가 루트라고 가정
        preorder(root); System.out.println();
        inorder(root);  System.out.println();
        postorder(root); System.out.println();
    }

    // 전위 순회 : 루트 -> 왼쪽 -> 오른쪽
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 : 왼쪽 -> 루트 -> 오른쪽
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // 후위 순회 : 왼쪽 -> 오른쪽 -> 루트
    static void postorder(Node node) {
        if (node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

