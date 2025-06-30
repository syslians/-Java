package week2.Extra02_TwoPointer;

public class E04_SumOfTwoNums {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int target = 7;
        int left = 0, right = arr.length-1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] +"+"+ arr[right] + "=" + target);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
