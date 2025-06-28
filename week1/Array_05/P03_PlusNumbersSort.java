package week1.Array_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class P03_PlusNumbersSort {
    public static void main(String[] args) {
        /*
        * 첫 번째, 문제를 쪼개서 분석하기
        * 정수 배열 numbers가 주어짐
        * 서로 다른 인덱스에 있는 두 수를 뽑아 더하기
        * 해당 값 넣기
        * 오름차순로 정렬
        * 반환하기
        *
        * 두 번째, 제약사항 파악 및 테스트케이스 추가
        * 제약 조건
        * numbers의 길이는 2 이상 100 이하 입니다
        * numbers의 모든 수는 0 이상 100 이하입니다.
        * -> 시간복잡도.. O(N^3) -> 200~300 이 N의 가용범위이므로...
        * 이거 아래로는 다 가능..
        *
        * 세 번째, 입력사항 분석하기
        * 저자님이 책에 써놓았듯, 출력시 값이 중복되지 않는다.
        *
        * */
        int[] arr = new int[] {5, 0, 2, 7}; // {2, 1, 3, 4, 1};


        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(solution(arr)));
    }

    // 생각한 순서 따라가려면 : Ctrl+F 해서 '기록'으로 보셈..
    private static int[] solution(int[] arr) {
        int[] numbers = arr.clone();
        int n = numbers.length;
//        Set<Integer> set = new TreeSet<>(); // 중복제거 set
//        int[] sum = new int[1000000]; //  O(N^3) 기준으로 최대값 셋팅 : 테스트용으로 놔두기..
//        int[] sum = new int[10];
//        int index = 0;
        Set<Integer> set = new HashSet<>();

        // 두 수 선택해서 더하기 -> 책에서 나온대로...
        for (int i=0 ; i<n-1; i++) { // n : 4 가정 // 기록3 : i의 범위를 i<n으로 잡았었는데, 서로 다른 수이므로 i<n-1로 잡아야 한다.
            for (int j=i+1; j<n; j++) {
                // i : 0,1 2 // 1,2 // 2, // 3
                // j : 1 2 3 // 2 3 // 3  // x
                set.add(numbers[i] + numbers[j]); // 해당 값 넣기
//                sum[index++] = numbers[i] + numbers[j];
//                System.out.println("111"+Arrays.toString(sum));
            }
        }
        // 오름차순 정렬 : 현재 Intger[]
//        set.stream().sorted() // 기록1 : TreeSet sort하는 법을 모르겠음. 여기서 정렬해서 반환하는 것 하고 싶었음.

        // 기록2 : 지금 아는걸로 아래처럼 진행
        // 현재 아는 것으로 하려면, 위에서 두 수를 더한 값을 int[]에 담아서.
        // stream 변환 후 중복제거 : Arrays.stream(sum).boxed().distinct()
        // Integer[] 형태로 변환 : ~.toArray(Intger[]::new)
        // 오름차순 정렬 : Arrays.sort(result) -> 내림차순 : Arrays.sort(result, Collections.reverseOrder());
        // 다시 stream 변환 후 int[]로 변환해서 반환하기 : Arrays.stream(result).mapToInt(integer::intValue).toArray();
//        Integer[] result = Arrays.stream(sum).boxed().distinct().toArray(Integer[]::new);
//        System.out.println("222"+Arrays.toString(result));
//        Arrays.sort(result) ; // 오름차순 정렬(기본)
//        System.out.println("333"+Arrays.toString(result));
//        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();

        // 기록4: sum[] 에 두 수의 값을 저장했더니.. int[] 이 길이가 정해진 배열이라, 값이 들어가지 않으면
        // 0으로 초기화된 값이 들어있어서 결과값에 포함이 되네. 결국, 가변길이 자료구조를 사용해야 함.
        // 그럼 다시, ㅋㅋㅋㅋ 저자님의 풀이를 보곸ㅋㅋ HashSet 이용하기로 함.
        // set이니까 중복제거 자연스럽게 되고, stream 변환후 sorted하면 기본이 오름차순 같음.. int[]로 변환해서 리턴하기
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

// 책에 나와있는 시간복잡도 분석하기
// N : numbers의 길이
// 이중 반복문을 통해 모든 원소들에 대한 두 수의 합을 구하는 연산의 시간 복잡도 : O(N^2)
// 이후 이를 Set으로 만들 때 시간 복잡도는 O(N^2)
// N^2개의 데이터를 정렬하는데는 O(N^2log(N^2)) -> sort() API 가 O(NlogN) 시간복잡도인데, N이 N^2이므로..
// 최종 시간 복잡도는 O(N^2log(N^2))