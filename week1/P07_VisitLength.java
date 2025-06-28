package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P07_VisitLength {

    private static boolean isValidMove(int nx, int ny) {
        // 좌표평면을 벗어나는지 체크하는 메서드
        return 0<=nx && nx <11 && 0<= ny && ny <11;
    }

    // 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1, 0});
    }


    public static int solution(String dirs) { // "ULURRDLLU";
        initLocation();
        int x=5, y=5;
        HashSet<String> answer = new HashSet<>(); // 겹치는 좌표는 1개로 처리하기 위함
        // 주어진 명령어로 움직이면서 좌표 저장
        for (int i=0; i<dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            System.out.println("offset->"+ Arrays.toString(offset));
            System.out.println(offset[0]);
            System.out.println(offset[1]);
            int nx = x + offset[0];
            int ny = y + offset[1];
            System.out.println("nx->"+nx);
            System.out.println("ny->"+ny);
            if (!isValidMove(nx, ny)) // 벗어난 좌표는 인정하지 않음
                continue;;
            // A에서 B로 간 경우도 B에서 A도 추가해야 함(총 경로의 개수는 방향성이 없음)
            answer.add(x +" "+y +" "+nx+" "+ny);
            answer.add(nx +" "+  ny +" "+ x +" "+ y);
            System.out.println("answer->"+answer);
            // 좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
        }
        return answer.size()/2;
    }
    public static void main(String[] args) {

        /*
         * 첫 번째, 문제를 쪼개서 분석하기
         * U : 위쪽으로 한 칸 가기
         * D : 아래쪽으로 한 칸 가기
         * L : 왼쪽으로 한 칸 가기
         * R : 오른쪽으로 한 칸 가기
         *
         * 캐릭터는 좌표평면 (0,0)애서 시작
         * 표평면 경계, 왼쪽 위가 (-5,5)
         * 왼쪽 아래가 (-5,-5)
         * 오른쪽 위가 (5,5)
         * 오른쪽 아래가 (5,-5) 로 구성.
         *
         * 캐릭터가 처음 가본 길 길이 구하기
         * 벽에 막혀있으면, 길이로 세지 않고, 그 이후에 명령어는 갈 수 있는 길이면 수행
         *
         * 두 번째, 제약사항을 파악하고 테스트케이스를 추가하라
         * 제약 조건
         * dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이와의 문자는 주어지지 않습니다.
         * dirs 길이는 500이하의 자연수입니다.
         *
         * 세 번째, 입력사항을 분석화라
         * dirs ULURRDLLU
         * answer 7
         *
         * 실수하기 좋은 포인트 체크
         *
         * 첫 번째, 중복된 길이는 최종 길이에 포함하지 않는다는 조건!!!! 이 부분을 어떻게 처리할지 고민해야 한다..
         * 중복을 포함하지 않는다는 문장이 나오면 해시셋~~~~ 생각하면 좋다.
         *
         * 두 번째, 음수 좌표를 포함한다는 사실...
         * -5<=x,y<=5 인데.. 2차원 배열에서 음수 인덱스를 사용할 수 없으므로.. 다른 방법을 생각해야 함.
         * 문제의 핵심은 원점에서 출발해 최종 경로의 길이를 구하는 건데,
         * 좌표는 방향에 의해서만 제어된다는 점....
         * 따라서 원점을 (0,0)에서 (5,5)로 바꿔 음수 좌표 문제를 해결해도 된다.
         *
         * 이 문제는 구현문제이므로, 별다른 알고리즘 설명은 필요하지 않다...
         * 구현문제는 답안 코드의 길이가 긴 경우가 많으므로, 기능별로 함수를 구현하는게 좋다.
         *
         * */

        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
}
// 책 시간복잡도
// N : dirs의 길이...순회 O(N)