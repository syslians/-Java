package week1;

import java.util.Arrays;
import java.util.HashMap;

public class P06_FailureRate {
    public static void main(String[] args) {

        /*
        * 첫 번째, 문제를 쪼개서 분석하기
        * 오렐리를 위해 실패율을 구하는 코드를 완성하라.
        * 실패율 정의 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
        *
        * 전체 스테이지 개수 N
        * 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담겨 있는 배열 stages
        *
        * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨 있는 배열을 반환하라..
        *
        * 두 번째, 제약 사항을 파악하고 테스트케이스를 추가하라.
        * 제약 조건
        * 스테이지 개수 N은 1 이상 500 이하의 자연수
        * stages의 길이는 1 이상 200,000 이하
        * stages에는 1 이상 N+1 이하의 자연수가 있습니다
        * -> 각 자연수는 사용자가 현재 도전 중인 스테이지 번호를 나타냅니다
        * -> 단, N+1 은 마지막 스테이지, 즉 N까지 클리어한 사용자를 나타냅니다
        * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오면 됩니다.
        * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의합니다.
        *
        * 세 번째, 입력사항을 분석하라
        * 책. 저자님의 풀이 참고함..
        * N: 5, stages [2, 1, 2, 6, 2, 4, 3, 3], result [3, 4, 2, 1, 5]
        * 1번 스테이지 실패율 : 1/8
        * 2번 스테이지 실패율 : 3/7
        * 3번 스테이지 실패율 : 2/4
        * 4번 스테이지 실패율 : 1/2
        * 5번 스테이지 실패율 : 0/1
        * 각 스테이지 번호를 실패율의 내림차순으로 정렬하면
        * [3,4,2,1,5]
        *
        * *** 새 용어를 정의하는 부분이 나오면 반드시 이해하고 넘어가야 합니다.
        * *** 바로 그 부분이 문제의 핵심이 되는 경우가 많기 때문입니다...
        *
        * 시간복잡도
        * stages가 20만까지 입력될 수 있으므로.. 시간 초과를 방지하려면
        * 정렬 알고리즘의 시간 복잡도는 O(NlogN)이어야 한다...
        * 만약, 정렬 알고리즘의 시간 복잡도가 O(N^2)이라면 시간 초과가 발생할 수 있다.
        * 자바 표준 API를 사용하는 것이 좋은 전략...
        * */

        int N = 4; // stage 개수
        int[] stages = new int[] {4,4,4,4,4};
        System.out.println(Arrays.toString(solution(N, stages)));

    }

    public static int[] solution(int N, int[] stages) {

        // 스테이지별 도전자 수를 구함.
        int[] challenger = new int[N+2]; // N번째 스테이지까지 클리어한 플레이어는 N+1에 저장되므로..
        for (int i=0; i<stages.length; i++) { // stages.length : 5 -> i=0~4
            challenger[stages[i]] +=1;          // challenger[stages[4]] +=1;
            System.out.println("challenger->"+ Arrays.toString(challenger));
        }

        // 스테이별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 각 스테이지를 순회하며 실패율 계산
        for (int i=1; i<=N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i]/total); // 실패율 공식
                total -= challenger[i]; //  다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
            System.out.println("2. fails->"+fails);
        }

        // 실패율 내림차순
        return fails.entrySet().stream().sorted((o1, o2)
                -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();

    }
}

// 책. 저자님 시간복잡도
// N : 스테이지 개수, M(stages.length) : stages 길이
// challenger 배열을 초기화하고, 각 스테이지 도전자 수를 계산할 때 시간 복잡도는 O(N+M)
// 이후, 스테이지별 실패율 계산하는데 필요한 시간 복잡도는 O(N)
// 실패율을 기준으로 스테이지를 정렬할 때의 시간 복잡도는 O(NlogN)
// 이 연산들을 모두 고려.. O(2*N+M+NlogN)이므로 최종 시간복잡도는 O(M+NlogN) 입니다.