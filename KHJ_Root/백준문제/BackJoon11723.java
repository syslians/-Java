/* 문제 */
/* 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오. */
/* 
- add x : S에 x를 추가한다. (1 <= x <= 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
- remove x : S에서 x를 제거한다. (1 <= x <= 20) S에 x가 없는 경우에는 연산을 무시한다.
- check x : S에 x 가 있으면 1을, 없으면 0을 출력한다. (1 <= x <= 20)
- toggle x : S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 <= x <= 20) 
- all : S를 {1, 2, ..., 20}으로 바꾼다
- empty : S를 공집합으로 바꾼다.

<입력>
첫째 줄에 수행하는 연산의 수 M (1 <= M <= 3,000,000)이 주어진다.
둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

<출력>
check 연산이 주어질때마다, 결괄를 출력한다.
*/ 

/*
<비트마스크 연산>
add: $ x $번째 비트를 1로 (set |= 1 << (x-1)).
remove: $ x $번째 비트를 0으로 (set &= ~(1 << (x-1))).
check: $ x $번째 비트 확인 (set & (1 << (x-1))).
toggle: $ x $번째 비트 반전 (set ^= 1 << (x-1)).
all: 1~20 비트를 1로 (set = (1 << 20) - 1).
empty: 모든 비트를 0으로 (set = 0).
*/


import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
   BufferReader br = new BufferReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();

   int M = Integer.parseInt(br.readLine()); // 연산 수 입력
   int set = 0; // 비트마스크로 집합 표현 (초기 공집합)

   for (int i = 0; i < M; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String operation =  st.nextToken(); // 연산 명령어
        int x;

        switch (operation) {
          case "add":
              x = Integer.parseInt(st.nextToken());
              set |= (1 << (x - 1)); // x 번째 비트를 1로 설정 (추가)
            break;
          case "remove":
              x = Integer.parseInt(st.nextToken());
              set &= ~(1 << (x-1)); // x 번째 비트를 0으로 설정 (제거)
            break;
          case "check":
              x = Integer.parseInt(st.nextToken());
              if ((set & (1 << (x-1))) != 0) { // x번째 비트가 1인지 확인
                  sb.append("1\n"); // 있으면 1 추가
              } else {
                  sb.append("0\n"); // 없으면 0 추가
              }
            break;
          case "toggle":
              x = Integer.parseInt(st.nextToken());
              set ^= (1 << (x-1)); // x번째 비트를 revese
            break;
          case "all":
              set = (1 << 20) - 1; // 1 ~ 20 비트를 모두 1로 설정
            break;
          case "empty":
              set = 0; // 모든 비트를 0으로 설정
            break;
        }
   }
    System.out.println(sb);
    br.close();
  }
}
