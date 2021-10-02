package info.sandroalmeida;

import java.util.Arrays;

public class BalancedSplit_V2 {

    public static boolean balancedSplitExists(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;

        return partitionSum(arr, 0, arr.length - 1, 0, sum / 2);
    }

    public static void swap(int[] arr, int i, int j){
        if(i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean partitionSum(int[] arr, int start, int end, int currSum, int neededSum) {
        if (start == end) return currSum + arr[start] == neededSum;

        int newSum = currSum;
        int lowerBound = start;

        for (int upperBound = start; upperBound < end; ++upperBound) {
            if (arr[upperBound] <= arr[end]) {
                newSum += arr[upperBound];
                swap(arr, lowerBound++, upperBound);
            }
        }

        swap(arr, lowerBound, end);
        newSum += arr[lowerBound];

        if (newSum < neededSum)
            return partitionSum(arr, lowerBound + 1, end, newSum, neededSum);

        if (newSum > neededSum) {
            while (lowerBound >= start && (arr[lowerBound] == arr[end]))
                --lowerBound;

            if (lowerBound <= start) return false;

            return partitionSum(arr, start, lowerBound, currSum, neededSum);
        }
        return true;
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
