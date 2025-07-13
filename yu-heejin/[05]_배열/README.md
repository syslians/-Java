# 배열 개념

## 배열 선언

배열은 인덱스와 값을 일대일 대응해 관리하는 자료구조이다.

데이터를 저장할 수 있는 모든 공간은 인덱스와 일대일 대응하므로 **어떤 위치에 있는 데이터든 한 번에 접근할 수 있다.**

데이터에 한 번에 접근할 수 있으니 위치만 알면 빠르게 탐색 가능하며, 이러한 방식을 임의 접근(random access)라고 한다.

자바에는 배열과 유사한 기능을 가진 `ArrayList` 자료구조가 있다. 배열과의 차이점은 **배열은 처음 선언할 때 배열의 크기가 결정되고, `ArrayList`는 크기가 동적이라는 것이다.**

정확한 데이터의 개수를 알 수 있다면 코드가 더 간결하고 속도가 더 빠른 배열을 사용하면 되고, 저장해야 할 데이터의 개수를 정확히 알 수 없다면 `ArrayList`를 사용하면 된다. (엄밀히 말하면 `ArrayList`도 초기에 크기가 결정되지만, 동적으로 변하는 것처럼 구현되어 있다.)

## 배열과 차원

배열은 2차원 배열, 3차원 배열과 같이 다차원 배열을 사용할 때도 많다. 하지만 컴퓨터 메모리의 구조는 1차원이므로, 2차원, 3차원 배열도 실제로는 1차원 공간에 저장된다. 다시 말해 **배열은 차원과는 무관하게 메모리에 연속 할당된다.**

엄밀히 말하면 **자바에서는 1차원 배열 역시 하나의 객체이므로, 2차원 배열을 1차원 배열 객체의 배열로 표현**한다. 즉, 2차원 배열은 1차원 배열 객체 여러 개가 있는 것이다. 따라서 2차원 배열은 메모리에 데이터가 반드시 연속으로 저장되지는 않을 수 있다.

# ArrayList 사용법

## ArrayList에 데이터 추가

### `remove()` 메서드로 데이터 삭제

`remove()` 메서드를 사용하면 특정 위치의 데이터를 삭제할 수 있다. 다만, `remove()` 메서드는 데이터를 삭제하는 위치에 따라 데이터를 복사하는 연산이 필요하므로 시간 복잡도가 `O(N)`까지 증가할 수 있기 때문에 주의해야 한다.

# ArrayList의 효율성

## 배열 연산의 시간 복잡도

배열은 임의 접근이라는 방법으로 배열의 모든 위치에 있는 데이터에 단번에 접근할 수 있다. 따라서, 데이터에 접근하기 위한 시간 복잡도는 `O(1)`이다.

### 맨 뒤에 삽입할 경우

맨 뒤에 삽입할 때는 `arr[3]`에 임의 접근을 바로 할 수 있으며, 데이터를 삽입해도 다른 데이터 위치에 영향을 주지 않는다. 따라서 시간 복잡도는 `O(1)`이다.

**자바에서는 기본적으로 `ArrayList`를 생성하면 기본 값으로 10개의 데이터를 저장할 수 있는 배열이 생성**된다. 이후, 데이터가 가득찬 상태에서 추가로 데이터를 삽입하면 리사이징한다. 즉, 다시 말해 배열의 크기를 늘린다.

리사이징 전략은 다양하지만, 자바 `ArrayList`는 50% 증가 전략을 사용한다. 기본 10개 데이터가 가득 차면 사이즈를 50% 늘려 15개를 저장할 수 있는 배열을 생성한다.

리사이징할 때마다 새 배열을 생성하는 것이므로, 기존 데이터를 복사하는 과정이 필요하다. 저장된 모든 데이터를 옮겨야하기 때문에 복사하는 과정은 `O(N)`의 시간 복잡도를 갖는다. 그래서 리사이징을 자주하면 효율이 좋지 않지만, 그렇다고 기본 사이즈를 크게 하거나 리사이징 시 더 큰 크기의 배열을 생성하면 낭비 공간이 많아지므로 메모리 효율이 좋지 않다. 따라서 자바에서는 수행 시간의 효율과 메모리 공간의 효율 사이에서 고민 후 50% 증가 전략을 선택한 것이다.

50% 증가 전략의 경우, `ArrayList`의 사이즈가 작을 때는 리사이징이 자주 발생하는 대신 데이터의 개수가 적어 새로운 메모리 영역에 복사하는 시간이 빠르고, 사이즈가 클 때는 리사이징 시에 늘어나는 공간이 크므로 리사이징이 자주 발생하지 않는 대신 복사해야 할 데이터의 수가 많다.

코딩 테스트에서는 `ArrayList`의 리사이징으로 인한 효율성 이슈는 고려하지 않아도 될 정도로 비용이 적으니 무시해도 괜찮다.

### 맨 앞에 삽입할 경우

데이터를 맨 앞에 삽입할 경우, 기존 데이터들을 뒤로 한 칸씩 밀어야 한다. 데이터 개수를 N개로 일반화하면 시간 복잡도는 `O(N)`이 된다.

### 중간에 삽입할 경우

현재 삽입한 데이터 뒤에 있는 데이터 개수만큼 미는 연산을 해야한다. 밀어야 하는 데이터 개수가 N개라면, 시간 복잡도는 `O(N)`이다.

## 배열을 선택할 때 고려할 점

데이터에 자주 접근하거나 읽어야 하는 경우, 배열을 사용하면 좋은 성능을 낼 수 있다. 예를 들어, 그래프를 표현할 때 배열을 활용하면 임의 접근을 할 수 있으므로 간선 여부도 시간 복잡도 `O(1)`로 판단할 수 있다. 그러나, 배열은 메모리 공간을 충분히 확보해야 하는 단점도 있다.

임의 접근이라는 특징이 있어 데이터에 인덱스로 바로 접근할 수 있어 데이터에 빈번하게 접근하는 경우 효율적이지만 메모리 낭비가 발생할 수 있다. 따라서 코딩 테스트에서는 다음 사항을 고려해 배열을 선택해야 한다.

1. **할당할 수 있는 메모리 크기를 확인해야 한다.**
    
    배열로 표현하려는 데이터가 너무 많으면 런타임에서 배열 할당에 실패할 수도 있다. 운영체제마다 배열을 할당할 수 있는 메모리의 한계치는 다르지만, 일반적인 코딩 테스트에서는 정수형 1차원 배열을 1000만개, 2차원 배열은 3000 * 3000 크기를 최대로 생각한다.
    
2. **중간에 데이터 삽입이 많은지 확인해야 한다.**
    
    배열은 선형 자료구조이기 때문에 중간이나 처음에 데이터를 빈번하게 삽입하면 시간 복잡도가 높아져 실제 시험에서 시간 초과가 발생할 수 있다.
    

# 몸풀기 문제

## 문제 01 - 배열 정렬하기

정수 배열을 정렬해서 반환하는 `solution()` 함수를 완성하세요.

### 제약 조건

- 정수 배열의 길이는 2 이상 10^5 이하입니다.
- 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하입니다.

### 풀이

```java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Collections.sort(arrays);
    }
}
```

### 문제 분석하고 풀기

제약 조건을 보면, 데이터 개수는 최대 10^5개이다. 즉, 제한 시간이 3초라면 `O(N^2)` 알고리즘은 사용할 수 없다. 만약 정수 배열의 최대 길이가 10이라면 `O(N^2)` 알고리즘을 사용해도 된다. 이렇듯 제약 조건에 따라 같은 문제도 난이도가 달라질 수 있다. 단순히 내림차순, 오름차순으로 정렬하면 이 문제는 통과할 수 없다.

```java
class Main {
    private static int[] solution(int[] arr) {
        Arrays.sort(arrays);
    }
}
```

`Arrays.sort()` 메서드는 배열을 오름차순으로 정렬한다. 주목할 점은 `sort()` 메서드가 원본 배열 자체를 정렬시킨다는 것이다. 만약 원본 배열을 그대로 두고 싶다면 아래와 같이 구현할 수 있다.

```java
private static int[] solution(int[] arr) {
	int[] clone = arr.clone();
	Arrays.sort(clone);
	return clone;
}
```

배열의 `clone()` 메서드는 타겟이 되는 배열을 복사해 새로운 배열로 생성한다. 아래 두 코드의 실행 결과를 보면, `clone()` 메서드가 어떻게 동작하는지 조금 더 명확히 알 수 있다.

```java
public static void main(String[] args) {
	int[] org = {4, 2, 3, 1, 5};
	int[] sorted = solution(org);
	
	System.out.println(Arrays.toString(org));    // [4, 2, 3, 1, 5]
	System.out.println(Arrays.toString(sorted));  // [1, 2, 3, 4, 5]
}
```

원본 배열의 상태를 유지하면서 원본 배열로부터 새로운 배열을 복사해 사용해야 하는 상황에서는 `clone()` 메서드를 사용해야 한다.

## sort() 메서드를 사용하지 않고 O(N^2) 알고리즘을 사용하면?

```java

```

첫번째 방법은 `O(N^2)` 정렬 알고리즘인 버블 정렬을 활용한 방법이고, 두번째 방법은 `O(NlogN)` 시간 복잡도를 가진 `sort()` API를 활용한 방법이다.

데이터 100,000개를 오름차순으로 정렬하는데 버블 정렬은 1초가 걸렸지만 두번재 방법은 0.1초도 걸리지 않는다. 참고로, `sort()` API의 정렬 알고리즘은 Dual-Pivot QuickSort 혹은 Tim-Sort이다.

### [추가 자료] Arrays.sort()의 최악의 시간 복잡도는 `O(N^2)`이다.

[Arrays.sort()와 Collections.sort()](https://velog.io/@minizero0/Arrays.sort%EC%99%80-Collections.sort)

## 문제 02 - 배열 제어하기

정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 `solution()` 함수를 구현하세요.

### 제약 조건

- 배열 길이는 2 이상 1,000 이하입니다.
- 각 배열의 데이터 값은 -100,000 이상 100,000 이하입니다.

### 풀이

```java
private static int[] solution(int[] arr) {
	List<Integer> answer = new ArrayList<>();
	
	for (int a : arr) {
		if (!answer.contains(a)) {
			answer.add(a);
		}
	}
	
	Collections.sort(answer);
	
	int[] toArr = new int[answer.size()];
	
	for (int i = 0; i < answer.size(); i++) {
		toArr[i] = answer.get(i);
	}
	
	return toArr;
}
```

### 문제 분석하고 풀기

```java
private static int[] solution(int[] arr) {
		Integer[] result = Arrays.stream(arr)  // reverseOrder를 사용하기 위해 참조형으로 변경
			.boxed()
			.distinct()
			.toArray(Integer[]::new);
		
		Arrays.sort(result, Collections.reverseOrder());
	
		return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
	}
}
```

`Arrays` 클래스의 `stream()` 메서드를 통해 stream으로 변환한다. 해당 stream의 Primitive 타입인 `IntStream`의 데이터를 `boxed()`를 통해 레퍼런스 타입인 `Integer`로 변환하고, `distinct()` 메서드를 통해 중복을 제거한다. 마지막으로 `Integer`형 배열로 중복 제거된 데이터를 반환한다.

가끔 자바의 표준 API를 통해 해결할 수 있는 문제를 굳이 직접 코드를 작성해서 해결하려는 경우가 있다. 하지만 그럴 필요가 없다. 이를테면 이중 반복문을 통해 일일이 데이터를 확인해서 중복값을 확인해 제거하는 알고리즘은 시간 복잡도가 `O(N^2)`으로 성능이 좋지 않다. 심지어 `distinct()` 메서드는 시간 복잡도 O(N)을 보장한다.

## 스트림을 사용하지 않고 기본 반복문으로 풀기

```java

```

시험 상황은 단일 스레드 환경이므로 스트림과 `for`문의 차이가 크지 않다. 시간 복잡도만 동일하다면 수행 시간에서 큰 차이가 없다. 스트림을 적극적으로 사용하면 코드도 짧아지고, 가독성도 좋아지는 것은 사실이나 스트림의 많은 사용법을 다 외우려고 하기 보다는 자주 사용하는 기능은 자연스럽게 외우되, 혹시라도 기억이 잘 나지 않는다면 스트림을 사용하지 않고 반복문으로 구현하는 연습을 평소에 해두는 것도 좋다.

# 합격자가 되는 모의 테스트

## 문제 03 - 두 개 뽑아서 더하기

### **문제 설명**

정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

### 제한사항

- numbers의 길이는 2 이상 100 이하입니다.
- numbers의 모든 수는 0 이상 100 이하입니다.

### 입출력 예

| numbers | result |
| --- | --- |
| `[2,1,3,4,1]` | `[2,3,4,5,6,7]` |
| `[5,0,2,7]` | `[2,5,7,9,12]` |

### 풀이

```java
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // numers의 길이는 100 이하, 모든 수도 100 이하
        // TreeSet을 사용하면 별도 정렬 없이 내부에서 정렬해준다.
        Set<Integer> answer = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                
                answer.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] toArr = new int[answer.size()];
        int arrIndex = 0;
        for (int n : answer) {
            toArr[arrIndex] = n;
            arrIndex++;
        }
        
        return toArr;
    }
}
```

### 문제 분석하고 풀기

numbers의 최대 데이터 개수는 100이므로 시간 복잡도는 고려하지 않아도 된다.

```java

import java.util.HashSet;

class Solution {
     public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
		        // 이전 반복에서 계산했기 때문에, i + 1을 조건문으로 달아두면 된다.
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
```

1. 배열에서 두 수를 선택하는 모든 경우의 수를 구한다.
2. 과정 1에서 구한 수를 새로운 배열에 저장하고 중복값을 제거한다.
3. 배열을 오름차순으로 정렬하고 반환한다.

### 시간 복잡도 분석하기

N은 numbers의 길이, 이중 반복문을 통해 모든 원소들에 대한 두 수의 합을 구하는 연산의 시간 복잡도는 `O(N^2)`이다. 이후 이를 Set으로 만들 때 시간 복잡도는 `O(N^2)`이고, N^2개의 데이터를 정렬하는 데는 `O(N^2log(N^2))`이므로, 최종 시간 복잡도는 `O(N^2log(N^2))`이다.

## 문제 04 - 모의고사

### **문제 설명**

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...

2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...

3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한 조건

- 시험은 최대 10,000 문제로 구성되어있습니다.
- 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
- 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

### 입출력 예

| answers | return |
| --- | --- |
| [1,2,3,4,5] | [1] |
| [1,3,2,4,2] | [1,2,3] |

### 풀이

```java
import java.util.*;

class Solution {
    private final int[] first = {1, 2, 3, 4, 5};
    private final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (first[firstIndex] == answers[i]) {
                firstCount++;
            }
            
            if (second[secondIndex] == answers[i]) {
                secondCount++;
            }
            
            if (third[thirdIndex] == answers[i]) {
                thirdCount++;
            }
            
            firstIndex = (firstIndex + 1) % first.length;
            secondIndex = (secondIndex + 1) % second.length;
            thirdIndex = (thirdIndex + 1) % third.length;
        }
        
        List<Integer> answer = new ArrayList<>();
        int max = Math.max(firstCount, Math.max(secondCount, thirdCount));
        
        if (max == firstCount) {
            answer.add(1);
        }
        
        if (max == secondCount) {
            answer.add(2);
        }
        
        if (max == thirdCount) {
            answer.add(3);
        }
        
        // List to int[]
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

### 시간 복잡도 분석하기

N은 answer의 길이이고, 각 수포자들의 패턴과 정답을 비교하는 부분은 `O(N)`이다. 이후 scores를 순회하면서 가장 높은 점수를 받은 수포자를 추가하는 연산은 scores의 길이가 3으로 고정이면서 N에 비해 상당히 작은 수이므로 `O(1)`이다. 따라서 최종 시간 복잡도는 `O(N)`이다.

## 문제 05 - 행렬의 곱셈

### **문제 설명**

2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

### 제한 조건

- 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
- 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
- 곱할 수 있는 배열만 주어집니다.

### 입출력 예

| arr1 | arr2 | return |
| --- | --- | --- |
| [[1, 4], [3, 2], [4, 1]] | [[3, 3], [3, 3]] | [[15, 15], [15, 15], [15, 15]] |
| [[2, 3, 2], [4, 2, 4], [3, 1, 4]] | [[5, 4, 3], [2, 4, 1], [3, 1, 1]] | [[22, 22, 11], [36, 28, 18], [29, 20, 14]] |

### 풀이

```java
class Solution {Add commentMore actions
    // A x B일 때, A의 열의 개수와 B의 행의 개수가 같아야 한다.
    // https://yang-wistory1009.tistory.com/135
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
```

### 문제 분석하고 풀기

수학의 행렬 곱셈을 그대로 구현하면 된다. 두 배열의 최대 데이터 개수가 100개이므로 시간 복잡도는 신경쓰지 않아도 된다. 또한, 행렬에는 곱할 수 있는 배열만 주어지므로 예외 처리도 없다.

### 시간 복잡도 분석하기

N은 행 혹은 열의 길이이며, 두 길이는 같다. `arr1`의 행과 열 수를 `r1`, `c1`이라 하고, `arr2`의 행과 열 수를 `r2`, `c2`라고 했을 때 `r1 * c1 * c2`만큼 연산한다. `r1`, `c1`, `r2`, `c2` 모두 N으로 볼 수 있으므로 최종 시간 복잡도는 `O(N^3)`이다.

## 문제 06 - 실패율

![failture_rate1.png](https://grepp-programmers.s3.amazonaws.com/files/production/bde471d8ac/48ddf1cc-c4ea-499d-b431-9727ee799191.png)

슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

- 실패율은 다음과 같이 정의한다.
    - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

### 제한사항

- 스테이지의 개수 N은 `1` 이상 `500` 이하의 자연수이다.
- stages의 길이는 `1` 이상 `200,000` 이하이다.
- stages에는 `1` 이상 `N + 1` 이하의 자연수가 담겨있다.
    - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
    - 단, `N + 1` 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
- 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
- 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 `0` 으로 정의한다.

### 입출력 예

| N | stages | result |
| --- | --- | --- |
| 5 | [2, 1, 2, 6, 2, 4, 3, 3] | [3,4,2,1,5] |
| 4 | [4,4,4,4,4] | [4,1,2,3] |

### 풀이 (실패)

```java
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int users = stages.length;
        
        // 오름차순으로 정렬
        Arrays.sort(stages);
        int stage = 1;
        int failUsers = 0;
        double[] failures = new double[N];
        
        for (int i = 0; i < stages.length; i++) {
            if (stage == stages[i]) {
                // 해당 단계에서 실패한 사람이 있는 경우
                failUsers++;
            } else {
                failures[stage - 1] = failUsers / (double)users;
                if (failUsers == users) {
                    failures[stage - 1] = 1;
                }
                users -= failUsers;
                failUsers = 0;
                stage++;
                
                if (stage == stages[i]) {
                    // 해당 단계에서 실패한 사람이 있는 경우
                    failUsers++;
                } 
            }
        }
        
        // 같은 순위면 스테이지 번호가 작은 순
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (failures[o1 - 1] > failures[o2 - 1]) {
                return -1;
            }
            
            if (failures[o1 - 1] < failures[o2 - 1]) {
                return 1;
            }
            
            if (failures[o1 - 1] == failures[o2 - 1]) {
                return o1 - o2;
            }
            
            return 0;
        }); 
        
        int[] toArr = new int[N];
        for (int i = 1; i <= N; i++) {
            pq.add(i);
        }
        
        int index = 0;
        while (!pq.isEmpty()) {
            toArr[index] = pq.poll();
            index++;
        }
        
        return toArr;
    }
}

테스트 1 〉	실패 (1.00ms, 81.2MB)
테스트 2 〉	통과 (1.57ms, 89.6MB)
테스트 3 〉	통과 (5.53ms, 73MB)
테스트 4 〉	통과 (14.98ms, 87MB)
테스트 5 〉	통과 (25.70ms, 87.5MB)
테스트 6 〉	실패 (1.67ms, 86.9MB)
테스트 7 〉	실패 (3.52ms, 75.9MB)
테스트 8 〉	실패 (21.02ms, 84MB)
테스트 9 〉	실패 (27.60ms, 105MB)
테스트 10 〉	실패 (15.29ms, 98.9MB)
테스트 11 〉	실패 (13.93ms, 103MB)
테스트 12 〉	실패 (24.75ms, 95.9MB)
테스트 13 〉	실패 (16.45ms, 97.6MB)
테스트 14 〉	통과 (1.08ms, 72.1MB)
테스트 15 〉	통과 (6.70ms, 79.8MB)
테스트 16 〉	통과 (4.14ms, 91.4MB)
테스트 17 〉	실패 (7.23ms, 88.9MB)
테스트 18 〉	실패 (4.69ms, 89.8MB)
테스트 19 〉	실패 (1.56ms, 75.4MB)
테스트 20 〉	실패 (4.54ms, 89.8MB)
테스트 21 〉	실패 (7.25ms, 94.8MB)
테스트 22 〉	실패 (22.29ms, 91.2MB)
테스트 23 〉	실패 (7.97ms, 81.4MB)
테스트 24 〉	실패 (17.94ms, 85.1MB)
테스트 25 〉	통과 (1.05ms, 82.5MB)
테스트 26 〉	통과 (1.15ms, 86.6MB)
테스트 27 〉	통과 (1.05ms, 81.4MB)
```

### 문제 분석하고 풀기

실패율이란 해당 스테이지에 도달한 적이 있는 사용자 중 아직 클리어하지 못한 사용자의 비율을 의미한다.