package Lily.src.week3.C09_Tree;

import java.util.Arrays;

public class P25_TreeVisit {
    public static void main(String[] args) {
        /*
        * // 문제
        * 이진 트리를 표현한 리스트 nodes를 인자로 받음
        * nodes 이진 트리에 대하여, 전위 순회, 중위 순회, 후위 순회 결과를 반환...
        *
        * // 제약조건
        * 입력 노드값의 개수는 1개 이상 1,000개 이하
        * 노드값을 정수형, 중복되지 않음
        *
        * // 입출력
        * [1, 2, 3, 4, 5, 6, 7]
        * ["1 2 4 5 3 6 7", "4 2 5 1 6 3 7", "4 5 2 6 7 3 1"]
        *
        * */
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution(nodes)));
    }

    public static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim(); // 마지막 공백 제거
        result[1] = inorder(nodes, 0).trim(); //마지막 공백 제거
        result[2] = postorder(nodes, 0).trim(); // 마지막 공백 제거
        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) { // idx가 범위를 벗어나면 빈 문자열 반환
            return "";
        }

        // 루트노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return nodes[idx] + " " + preorder(nodes, 2*idx+1) + preorder(nodes, 2*idx+2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2*idx+1) + nodes[idx] + " " + inorder(nodes, 2*idx+2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2*idx+1) + postorder(nodes, 2*idx+2) + nodes[idx] + " ";
    }
}

// 시간 복잡도
// N은 노드의 개수. 전위, 중위, 후위 연산 모두 각 노드를 한 번씩 방문함로 시간복잡도는 O(N)입니다.
// 여기서는 재귀가 이해되는걸 보면, C08_Hash 단원에 P24_MenuRenewal 문제는 문제를 이해 못했을 확률이 높네..