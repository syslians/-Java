package week2.Extra01_LinkedList;

public class E02_CustomLinkedList {
    public static void main(String[] args) {
        /*
        * 자바로 연결 리스트 직접 구현하기 (단일 연결 리스트 기준)
        * Node 클래스 + 연결 리스트 직접 구현
        * */

        E02_CustomLinkedList list = new E02_CustomLinkedList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.print(); // 1 -> 3 -> 5 -> null

        list.remove(3);
        list.print(); // 1 -> 5 -> null
    }

    // 내부 노드 클래스
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    // 맨 끝에 노드 추가
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 값 출력
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 값 삭제
    public void remove(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        // 찾았다면 current.next가 삭제 대상
        if (current.next != null) {
            current.next = current.next.next; // 삭제 대상 스킵
        }
    }
}
