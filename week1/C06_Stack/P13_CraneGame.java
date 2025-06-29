package week1.C06_Stack;

import java.util.Stack;

public class P13_CraneGame {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개고 분석하라
        * 게임화면 1x1 크기의 격자로 구성된 MxN 크기의 격자
        * 위쪽에는 크레인이 있고 오른족에는 바구니가 있음
        *
        * 인형 없는 칸은 빈칸
        * 인형은 격자 한칸 차지
        * 크레인을 좌우로 음직일 수 있고 크레인을 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있음
        *
        * 집어 올린 인형은 바구니에 쌓임
        * 바구니의 가장 아래 칸부터 인형이 순서대로 쌓임
        * 같은 모양 인형 2개가 바구니에 연속해 쌓이면 두 인형은 펑하고 터지며 사라짐
        *
        * 인형 없는 곳에서 크레인을 작동시키면 아무일도 일어나지 않음
        * 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 큼
        *
        * 2차원 배열 : board
        * 크레인을 작동시킨 위치가 담긴 배열 : moves
        * 크레인을 모두 작동시킨 후 사라진 인형 개수 result
        * 를 반환하는 solution() 함수를 완성하라
        *
        * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
        * [제약 조건]
        * board는 2차원 배열, 크기는 5x5이상 30x30 이하입니다
        * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다
        * - 0은 빈 칸을 나타냅니다
        * - 1~100 의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다
        * moves 배열 크기는 1 이상 1,000 이하입니다
        * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
        *
        * 세 번째, 입력값을 분석하라
        * [입력] board
        * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
        *
        * [출력] moves
        * [1,5,3,5,1,2,1,4]
        *
        * result
        * 4
        *
        *
        * */
        int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[] {1,5,3,5,1,2,1,4};
        System.out.println(Solution13.solution(board,moves));
    }
}

class Solution13 {
    public static int solution(int[][] board, int[] moves) {
        // 1. 각 열에 대한 스택을 생성
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i=0; i<lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // 2. board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가합니다
        for (int i=board.length-1; i>=0; i--) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] >0 ) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 3. 인형을 담을 bucket을 생성합니다
        Stack<Integer> bucket = new Stack<>();
        // 4. 사라진 인형의 총 개수를 저장할 변수를 초기화
        int answer = 0;

        // 5. moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가합니다
        for (int move : moves) {
            if (!lanes[move-1].isEmpty()) {
                int doll = lanes[move-1].pop();
                // 바구니에 넣기 전에 체크
                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop(); // 펑~
                    answer += 2;
                } else { // 7. 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }
        return answer;
    }
}
