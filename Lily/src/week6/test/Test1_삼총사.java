package week6.test;

public class Test1_삼총사 {

    int answer = 0;

    public int solution(int[] number) {
        backtrack(number, 0, 0, 0);
        return answer;
    }

    private void backtrack(int[] number, int start, int count, int sum) {

        // 합이 0이 되면 결과 리스트에 추가
        if (count == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for (int i=start; i<number.length; i++) {
            backtrack(number, i+1, count+1, sum+number[i]);
        }
    }
}
