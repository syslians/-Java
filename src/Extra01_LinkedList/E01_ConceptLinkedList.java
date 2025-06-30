package week2.Extra01_LinkedList;

import java.util.LinkedList;

public class E01_ConceptLinkedList {
    public static void main(String[] args) {
        /*
        * 연결 리스트 (LinkedList)
        * - 배열은 인덱스로 접근이 빠르지만, 중간 삽입/삭제가 느림 (O(n))
        * - 연결 리스트는 포인터로 연결되어 중간 십입/삭제가 빠름 (O(1) 가능)
        * - 단, 임의 위치 접근은 느림 (O(n))
        *
        * 종류
        * 1. 단일 연결 리스트 : 다음 노드만 참고( node.next )
        * 2. 이중 연결 리스트 : 이전/다음 노드 모두 참조( node.prev, node.next )
        * 3. 원형 연결 리스트 : 마지막 노드의 다음이 첫 노드를 가리킴
        *
        * 자바에서 연결 리스트는 아래 코드 참조
        *
        * 코테에서는?
        * 직접 Node 클래스로 구현하는 문제 나올 수 있음
        * 혹은 Deque로 대체 가능 -> 오.. 비슷하다고 생각했다. addFirst, addLast
        *
        * 연결 리스트 : 노드/연결/포인터
        * 삽입/삭제가 자주 일어나는 곳
        * 연속된 합, 두 수의 조합
        *
        * 투 포인터 : 인덱스/두 위치/구간
        * 연속된 합, 두 수의 조합
        * 정렬 배열 문제, 누적합 문제
        *
        * 1. 연결 리스트는 중간 삽입/삭제에 강하고, 구현형 문제에서 등장
        * 2. 투 포인터는 '정렬된 배열에서 O(n)'으로 문제를 푸는 핵심 전략
        * 3. 둘 다 시간복잡도 줄이기 위한 전략적 구조
        * */

        // 자바에서 연결 리스트
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);         // 끝에 추가
        list.addFirst(0); // 맨 앞에 추가
        list.addLast(2);  // 맨 뒤에 추가
        list.remove();       // 첫 요소 제거


    }
}
