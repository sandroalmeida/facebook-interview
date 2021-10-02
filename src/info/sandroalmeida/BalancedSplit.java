package info.sandroalmeida;

import java.util.Arrays;

public class BalancedSplit {

    public static boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length -1;
        int leftSum = 0;
        int rightSum = 0;

        while(left < right){
            rightSum += arr[right];
            while(leftSum < rightSum && left < right){
                if(arr[left] < arr[right]){
                    leftSum += arr[left];
                }
                left++;
            }
            right--;
        }
        return leftSum == rightSum;
    }

    public static void main(String[] args) {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        System.out.println(balancedSplitExists(arr_1));

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        System.out.println(balancedSplitExists(arr_2));
    }

}
