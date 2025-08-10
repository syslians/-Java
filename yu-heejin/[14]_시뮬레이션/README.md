# 14-1 시뮬레이션 문제 풀이 노하우

시뮬레이션이란 문제에 주어진 상황을 완벽하게 이해하고 이를 콛로 구현하는 과정이다. 다른 알고리즘은 성능에 중점을 둔 반면, 시뮬레이션은 구현에 중점을 맞춘다.

## 시뮬레이션 문제를 푸는 방법

시뮬레이션 문제는 다른 알고리즘처럼 일반화한 방법으로 설명하거나 풀 수 없다. 왜냐하면 시뮬레이션 문제는 주어진 상황에 따라 해결 방식이 결정되기 때문이다. 그래서 시뮬레이션 문제는 문제 자체에 접근하는 방식을 공부해야 한다.

- 하나의 문제를 최대한 여러 개로 분리한다.
    - 조급한 마음에 문제를 분리하지 않은 상태에서 구현하려고 하면 하나의 함수에 문제에서 제시한 모든 동작을 구현하게 되어 코드가 복잡해진다.
- 예외 처리가 필요하다면 독립 함수로 구현한다.
    - 시뮬레이션 문제 특성상 구현할 부분이 많다. 이때 기본으로 동작하는 부분과 예외처리 부분의 코드가 섞이면 구현과 디버깅이 어려워진다.

## 행렬 연산

시뮬레이션 문제에 행렬 연산은 굉장히 많이 활용하는 기법이다.

### 행렬 덧셈과 뺄셈, 그리고 곱셈

각 행렬에서 같은 위치에 있는 값끼리 더하거나 빼는 연산이다. 이 연산을 하려면 **사용하는 두 행렬의 크기가 같아야 한다.** 만약 A나 B의 행 또는 열의 크기가 서로 다르면 행렬 덧셈과 뺄셈은 할 수 없다.

행렬 곱셈은 곱셈 순서가 중요하며, A → B 순서로 곱했다면 **행렬 A의 행, 행렬 B의 열 크기가 일치해야 하고 곱셈의 결과는 행렬 A의 열, 행렬 B의 행 크기가 된다.**

행렬을 곱할 때는 왼쪽 행렬의 1행과 오른쪽 행렬의 각 열을 각각 곱한다. 이때, 왼쪽 행렬의 행과 오른쪽 행렬의 열은 요소를 각각 곱하여 더하는 식으로 계산한다. 예를 들어, 행렬 A의 1행과 B의 1열의 각 요소를 곱하여 더하면 27이 나오고, 행렬 A의 1행과 B의 2열의 각 요소를 곱하여 더하면 36이 나온다.

$$
\sum (A[i][j] * B[j][i])
$$

### 전치 행렬

전치 행렬은 `arr[i][j]`를 `arr[j][i]`로 바꾸는 연산을 말한다. 쉽게 말해 행과 열의 위치를 바꾸는 것이다.

## 좌표 연산

시뮬레이션 문제에서는 조건에 따라 이동을 구현하는 경우가 많다. 이때 2차원 좌표를 사용하면 유용하다.

### 좌표 배열로 표현하기

좌표를 배열로 표현하는 방법은 **좌푯값에 해당하는 배열의 위치를 활용하는 것이다.**

### 좌표 이동 오프셋값으로 쉽게 표현하기

좌표를 활용하는 대부분 문제는 현재 위치를 이동하는 문제가 많다. 다만, 좌표의 이동을 if문의 연속으로 표현하면 구현해야 하는 양이 너무 많아져서 좋지 않다. **그럴 때는 좌표의 이동을 오프셋 값을 이용해 표현하면 훨씬 깔끔하게 코드를 구현할 수 있다.**

## 대칭, 회전 연산

길이가 N인 정사각형 배열에서 좌우 대칭을 일반화하면 `A[i, j] = A[i, (N - 1) - j]`와 같이 표현할 수 있다. (대각선 대칭이 아니라 가운데 기준으로 좌우 요소를 바꿔주는 것이다.)

회전은 길이가 N인 정사각형 배열에서 90도 반시계 방향으로 회전하는 것을 일반화하면 `A[i, j] = A[(N - 1) - j, i]`와 같이 표현할 수 있다. 큐브를 90도 회전시켰다고 생각해도 좋다. 이 식을 기억하면 180도 회전도 쉽게 구현할 수 있다. 180도 회전은 90도 회전 연산을 2번하면 된다. (반시계 방향)

# 14-2 몸풀기 문제

## 문제 59 배열 회전하기

2차원 배열 arr을 시계 방향으로 90도 * n번 회전하는 solution 함수를 작성하세요.

### 제약 조건

- 회전 횟수 n은 자연수이며, 1~4입니다.
- 2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않습니다.

### 오답 코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        int row = 4;
        int col = 4;

        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int n = 2;

        for (int i = 0; i < n; i++) {
            for (int j = row-1; j >= 0; j--) {
                for (int k = 0; k < col; k++) {
                    int temp = arr[k][j];
                    arr[k][j] = arr[row - 1 - j][k];
                    arr[row - 1 - j][k] = temp;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

- 회전이 아니라 swap을 하기 때문에 올바른 값이 나오지 않는다.

### 정답 코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        int row = 4;
        int col = 4;

        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int n = 2;

        for (int i = 0; i < n; i++) {
            arr = rotate(arr, row, col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

		// 기능 단위로 함수를 만드는 것이 중요하다.
		// 90도 회전 함수
    private static int[][] rotate(int[][] arr, int row, int col) {
        int[][] newArr = new int[row][col];
        
        for (int i = row-1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                newArr[j][i] = arr[row - 1 - i][j];
            }
        }

        return newArr;
    }
}
```

## 문제 60 두 행렬을 곱한 후 전치 행렬 만들기

matrix1과 matrix2는 정수값으로 이루어진 3 x 3 행렬입니다. 이 두 행렬을 곱한 결과의 전치 행렬을 반환하는 solution() 함수를 구현해주세요.

### 정답 코드

```java
import java.util.*;
import java.lang.*;
import java.io.*;

// https://yang-wistory1009.tistory.com/135

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] newMatrix = multiply(matrix1, matrix2);
        newMatrix = change(newMatrix);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 행렬을 곱하고 그 결과를 반환하는 함수
    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] newMatrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    newMatrix[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }

        return newMatrix;
    }

    // 전치행렬
    private static int[][] change(int[][] matrix) {
        int[][] newMatrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        return newMatrix;
    }
}
```

## 문제 61 달팽이 수열 만들기

n을 입력받아 n x n 크기의 2차원 배열을 생성해 달팽이 수열을 채우는 solution() 함수를 구현하세요. 달팽이 수열은 다음과 같이 숫자 1부터 시작해 시계 방향 나선형으로 채우는 수열을 의미한다.

### 제약 조건

- n은 2 이상 10 미만의 자연수이다.
- 숫자는 배열의 첫 번째 행, 첫 번째 열에서 시작합니다.

### 정답 코드

```java
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 4;

        int[][] arr = new int[n][n];

        // 회전
        int row = 0;  // 행
        int col = 0;  // 열
        int number = 1;
        int isAllFilled = 0;

        while (isAllFilled < (n * n)) {
            // right
            for (; col < n; col++) {
                if (arr[row][col] > 0) break;
                arr[row][col] = number++;
                isAllFilled++;
            }
    
            col--;
            row++;
    
            // down
            for (; row < n; row++) {
                if (arr[row][col] > 0) break;
                arr[row][col] = number++;
                isAllFilled++;
            }
    
            row--;
            col--;
    
            // left
            for (; col >= 0; col--) {
                if (arr[row][col] > 0) break;
                arr[row][col] = number++;
                isAllFilled++;
            }
    
            // up
            row--;
            col++;
            
            for (; row >= 0; row--) {
                if (arr[row][col] > 0) break;
                arr[row][col] = number++;
                isAllFilled++;
            }

            row++;
            col++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

# 14-3 합격자가 되는 모의 테스트

## 문제 62 이진 변환 반복하기

```java
class Solution {
    public int[] solution(String s) {
        StringBuilder sb;
        int zero1 = 0;
        int zero2 = 0;
        
        while (!s.equals("1")) {
            sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') sb.append(s.charAt(i));
                else zero2++;
            }
            
            s = Long.toBinaryString(Long.parseLong(sb.toString()));
            zero1++;
        }
        
        return new int[] {zero1, zero2};
    }
}

Exception in thread "main" java.lang.NumberFormatException: For input string: "111111111111111111111"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
	at java.base/java.lang.Long.parseLong(Long.java:707)
	at java.base/java.lang.Long.parseLong(Long.java:832)
	at Solution.solution(Unknown Source)
	at SolutionTest.lambda$main$0(Unknown Source)
	at SolutionTest$SolutionRunner.run(Unknown Source)
	at SolutionTest.main(Unknown Source)

```