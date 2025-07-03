package week2.Extra02_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E07_SumOfTwoNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[] arr = new int[N];

        String[] nums = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
             arr[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr);
        int left =0, right = N-1;
        int count = 0;

        while (left < right) {
            int sum = arr[left]+arr[right];
            if (sum == target) {
                count++;
                left++;
                right--;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
