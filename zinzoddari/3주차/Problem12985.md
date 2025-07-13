```java

public class Problem12985 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(final int N, int A, int B) {
        int answer = 0;

        while(A != B) {
            A = getRoot(A);
            B = getRoot(B);

            answer++;
        }

        return answer;
    }

    private static int getRoot(final int target) {
        if (0 >= target) {
            return 0;
        }

        return (target - 1) / 2;
    }
}

```