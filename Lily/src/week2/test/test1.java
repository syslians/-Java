package week2.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class test1 {
    public static void main(String[] args) throws IOException {
        /*
        * 1. 문제를 쪼개서 분석하기
        * L : 커서를 왼쪽으로 한 칸 옮김
        * D : 커서를 오른쪽으로 한 칸 옮김
        * B : 커서 왼쪽에 있는 문자를 삭제함
        * P $ : $ 라는 문자를 커서 왼쪽에 추가함
        *
        * 처음 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있음
        *
        * 입력
        * abcd
        * 3
        * P x
        * L
        * P y
        *
        * 출력과정
        * abcd
        * abcdx
        * abcdyx
        *
        *
        *
        *
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> list = new LinkedList<>();
        for (char c: br.readLine().toCharArray()) {
            list.add(c);
        }
        int n = Integer.parseInt(br.readLine()); // 명령어 갯수
        ListIterator<Character> cursor = list.listIterator(list.size());

        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");

            if ("L".equals(str[0])) {
                // 커서 왼쪽 이동
                if (cursor.hasPrevious()) cursor.previous();
            } else if ("D".equals(str[0])) {
                // 커서 오른쪽 이동
                if (cursor.hasNext()) cursor.next();
            } else if ("B".equals(str[0])) {
                // 커서 왼쪽 문자 삭제
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if("P".equals(str[0])) {
                // 문자 왼쪽에 추가
                cursor.add(str[1].charAt(0));
            }
        }

        StringBuffer sb = new StringBuffer();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
