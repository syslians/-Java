package week6.test;

public class test2_모음사전 {
    private static final char[] words= {'A','E','I','O','U'};
    private static int count = 0;
    private static int answer = 0;

    public int solution(String word) {

        dfs("", word);

        return answer;
    }

    private void dfs(String current, String target) {
        // 최대 길이 5
        if (current.length() > 5) {
            return;
        }

        if (current.equals(target)) {
            answer = count;
            return;
        }

        count++;

        for (char c : words) {
            dfs(current + c, target);
        }
    }
}
