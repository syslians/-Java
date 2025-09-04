class Solution {
    public int solution(String word) {
        // 문자와 인덱스 매핑: A=0, E=1, I=2, O=3, U=4
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] weights = {781, 156, 31, 6, 1}; // 각 자리별 가중치: 5^4, 5^3, 5^2, 5^1, 5^0
        
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 현재 문자의 인덱스 찾기
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    // 현재 자리에서 이전 문자들의 단어 수 + 현재 단어
                    answer += j * weights[i] + 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
