# 연결 리스트 (Linked List)

![[https://velog.io/@alsrl2313/자료구조-연결리스트란-Linked-List](https://velog.io/@alsrl2313/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%97%B0%EA%B2%B0%EB%A6%AC%EC%8A%A4%ED%8A%B8%EB%9E%80-Linked-List)](attachment:51a27b8b-ff07-4aca-9626-47a89ed9d95f:image.png)

[https://velog.io/@alsrl2313/자료구조-연결리스트란-Linked-List](https://velog.io/@alsrl2313/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%97%B0%EA%B2%B0%EB%A6%AC%EC%8A%A4%ED%8A%B8%EB%9E%80-Linked-List)

선형 자료구조로서, 각 노드가 다음 노드를 가리키는 형태를 가진다.

- 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 데이터를 저장하는 자료구조이다.
- 데이터를 담고 있는 노드들이 연결되어 있는데, **노드의 포인터가 다음이나 이전의 노드와의 연결을 담당한다.**

**각 노드는 동적으로 할당되므로, 노드들 사이의 주소 값은 연속적이지 않다.**

- 반면, **배열은 연속된 메모리 주소에 데이터를 저장하는 자료구조이다.**
- 각 값들은 연속된 주소에 위치하므로 인덱스를 사용해 빠르게 접근할 수 있다.

연결리스트는 배열과 달리 **중간 값을 인덱싱해 바로 접근하는 것이 불가능**하다.

- 연결리스트의 탐색은 보통 헤드로부터 시작해 각 노드가 가리키는 다음 노드로 이동하며 이루어진다.

연결리스트는 노드의 삽입과 삭제가 빈번한 경우에 유용하지만, 특정 요소를 검색하는데 시간이 오래 걸린다.

- 삽입과 삭제가 빈번할 때 배열은 요소를 옮기는 데 시간이 걸리지만, **연결 리스트는 포인터만 바꾸면 되므로 효율적이다.**
- 반면, 검색은 특정 값을 찾기 위해 처음 노드부터 하나씩 순차적으로 검색해야 한다.

# 연결리스트의 특징

## 장점

### 동적 메모리 할당

실행중에도 데이터 크기를 유연하게 조정할 수 있어, 미리 데이터 크기를 알 필요가 없다.

### 삽입/삭제 용이

중간에 있는 요소를 삽입하거나 삭제할 때, 연결 리스트는 포인터만 조정하면 되므로 상대적으로 간편하다.

### 메모리 효율

연결리스트는 불필요한 메모리를 미리 할당하지 않아 메모리 사용 효율성이 높다.

### 데이터 타입의 다양성

다양한 타입의 데이터를 한 리스트 안에서 저장할 수 있어 유연성이 높다.

- 단, Java의 연결리스트에서는 불가능하다.

## 단점

### 메모리 사용 비효율

각 노드는 데이터와 함께 다음 노드를 가리키는 포인터도 저장해야 하므로 추가적인 메모리를 필요로 한다.

### 코드 복잡성

연결 리스트를 사용하면 삽입과 삭제를 위해 추가적인 코드가 필요하므로 배열에 비해 코드가 복잡해질 수 있다.

### 시간 복잡도

특정 요소를 찾는데 있어 배열에 비해 시간이 더 걸릴 수 있다.

## 수행 시간

배열은 삽입/삭제 시 데이터 이동이 필요하지만, 연결리스트는 포인터만 변경하면 되므로 작업이 빠르다.

하지만 특정 요소를 찾을 때 전체를 순회해야 하므로, 검색 시간이 느리다.

# 연결 리스트의 연산과 시간 복잡도

## 검색

배열처럼 특정 원소의 인덱싱이 불가능하기 때문에 head값부터 비교해 값을 찾는다.

수행 시간은 `O(N)`이다.

## 삽입/삭제

배열의 삽입과 삭제는 최악의 경우 삽입되는 원소 나머지 원소들의 위치를 재조정해야 하므로 `O(N)`이 된다.

하지만 연결리스트는 삽입과 삭제 시간만 보면 `O(1)`이 된다.

# 연결 리스트의 종류

## 단순 연결 리스트(Singly Linked List)

![image.png](attachment:c05b3901-ad02-4f36-bcfa-130bc5a8e547:image.png)

단일 연결 리스트는 각 노드에 자료 공간과 한 개의 포인터 공간이 있고, 각 노드의 포인터는 다음 노드를 가리킨다.

단방향 연결 리스트라고도 한다.

현재 요소에서 이전 요소로 접근해야할 때 비효율적이라는 단점이 있다.

## 이중 연결 리스트(Doubly Linked List)

![image.png](attachment:808cfea4-7563-4e16-b8f6-a59f46bf4b14:image.png)

단순 연결 리스트는 next로 현재 노드에서 다음 노드로 갈 수 있지만, 이전 노드로는 갈 수 없다.

이러한 단점을 해결하기 위해 **노드에 앞 노드의 메모리 주소를 보관하는 포인터 `prev`를 추가한 형태를 이중 연결 리스트라고 한다.**

양방향 연결 리스트라고도 한다.

## 원형 연결 리스트(Circular Linked List)

![image.png](attachment:43f06ab1-9a30-4152-8694-4f466d977530:image.png)

단순 연결 리스트의 마지막 노드의 포인터가 NULL이 아닌 헤드를 가리키는 형태의 리스트이며, 리스트의 끝은 존재하지 않는다.

# 연결 리스트 vs 배열

| 구분 | **배열 (Array)** | **연결 리스트 (Linked List)** |
| --- | --- | --- |
| **접근 (Access)** | O(1) - 인덱스로 즉시 접근 가능 | O(n) - 순차 탐색 필요 |
| **탐색 (Search)** | O(n) - 전체 순회 필요 | O(n) - 전체 순회 필요 |
| **삽입 (Insert)** | O(n) - 중간 삽입 시 데이터 이동 필요O(1) - 끝에 삽입 시 | O(1) - 포인터 변경만 하면 됨 (삽입 위치 알고 있을 경우) |
| **삭제 (Delete)** | O(n) - 중간 삭제 시 데이터 이동 필요O(1) - 끝에서 삭제 시 | O(1) - 포인터만 조정 (삭제 위치 알고 있을 경우) |
| **메모리 사용** | 정적 할당크기 변경 불가 | 동적 할당필요 시 확장 가능 |
| **메모리 배치** | 연속된 메모리 공간 | 비연속 메모리 공간 |
| **추가 메모리** | 없음 (데이터만 저장) | 포인터(링크) 공간 추가 필요 |

# Java에서의 연결 리스트

Java에서의 `LinkedList`는 `ArrayList`와 같이 **인덱스로 접근해 조회/삽입이 가능하지만, 내부 구조는 완전히 다르게 구성되어 있다.**

![스크린샷 2025-07-06 오후 2.20.56.png](attachment:92090a6a-8815-4bb6-b873-a78f3199671e:스크린샷_2025-07-06_오후_2.20.56.png)

`ArrayList`는 내부적으로 배열을 이용해 메서드로 조작이 가능하도록 만든 컬렉션이라면, `LinkedList`는 노드끼리의 주소 포인터를 서로 가리키며 링크(참조)함으로써 이어지는 구조이다.

Java의 `LinkedList` 클래스는 이중 연결 리스트로 구현되어 있다.

> **Doubly-linked list implementation of the List and Deque interfaces.** Implements all optional list operations, and permits all elements (including null).
All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.
> 

https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```

그래서 각 노드는 이전 노드의 주소와 다음 노드의 주소를 모두 갖고 있기 때문에 메모리 오버헤드가 발생한다.

# 예제로 보는 연결 리스트

## 백준 - 키로거

[](https://www.acmicpc.net/problem/5397)

### 시간초과 코드

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        for (int t = 0; t < l; t++) {
            String input = br.readLine();
            int currentIndex = -1;
            List<Character> answer = new LinkedList<>();
            int inputSize = input.length();

            for (int i = 0; i < inputSize; i++) {
                char c = input.charAt(i);

                switch (c) {
                    case '<':
                        currentIndex = currentIndex - 1 < 0 
                          ? -1   // 아무것도 없는 상태, 맨 초기 위치
                          : currentIndex - 1;
                        break;

                    case '>':
                        currentIndex = currentIndex + 1 >= answer.size() 
                          ? answer.size() - 1    // 맨 오른쪽 위치
                          : currentIndex + 1;
                        break;

                    case '-':
                        if (answer.size() > 0 && currentIndex >= 0) {
                            answer.remove(currentIndex);     // 시간 초과
                            currentIndex--;
                        }
                        break;

                    default:
                        // 현재 위치 뒤 위치에 문자 추가
                        answer.add(currentIndex + 1, c);
                        currentIndex++;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i));
            }

            System.out.println(sb.toString());
        }
    }
}
```

- 연결 리스트가 내부적으로 삽입/삭제/탐색을 위해서 반복을 돌리기 때문에 시간 초과 발생 (이중 반복문)

### 정답 코드

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        for (int t = 0; t < l; t++) {
            String input = br.readLine();
            List<Character> answer = new LinkedList<>();
            ListIterator<Character> currentIndex = answer.listIterator();
                
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                switch (c) {
                    case '<':
                        if (currentIndex.hasPrevious()) {
                            currentIndex.previous();
                        }
                        break;

                    case '>':
                        if (currentIndex.hasNext()) {
                            currentIndex.next();
                        }
                        break;

                    case '-':
                        if (currentIndex.hasPrevious()) {
                            currentIndex.previous();    // remove()는 직전에 next() 또는 previous()로 읽은 요소만 삭제 가능
                            currentIndex.remove();   // O(1)
                        }
                        break;

                    default:
                        // 현재 위치 뒤 위치에 문자 추가
                        currentIndex.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            // for (int i = 0; i < answer.size(); i++) {
                // sb.append(answer.get(i));    // answer.get(i) O(N)
            // }

            for (char c : answer) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }
}
```

# 참고 자료

- [https://velog.io/@alsrl2313/자료구조-연결리스트란-Linked-List](https://velog.io/@alsrl2313/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%97%B0%EA%B2%B0%EB%A6%AC%EC%8A%A4%ED%8A%B8%EB%9E%80-Linked-List)
- [https://hyeinisfree.tistory.com/64#차이점 1. 시간 복잡도-1-10](https://hyeinisfree.tistory.com/64#%EC%B0%A8%EC%9D%B4%EC%A0%90%201.%20%EC%8B%9C%EA%B0%84%20%EB%B3%B5%EC%9E%A1%EB%8F%84-1-10)
- [https://inpa.tistory.com/entry/JAVA-☕-LinkedList-구조-사용법-완벽-정복하기#linkedlist_요소_추가_/_삽입](https://inpa.tistory.com/entry/JAVA-%E2%98%95-LinkedList-%EA%B5%AC%EC%A1%B0-%EC%82%AC%EC%9A%A9%EB%B2%95-%EC%99%84%EB%B2%BD-%EC%A0%95%EB%B3%B5%ED%95%98%EA%B8%B0#linkedlist_%EC%9A%94%EC%86%8C_%EC%B6%94%EA%B0%80_/_%EC%82%BD%EC%9E%85)