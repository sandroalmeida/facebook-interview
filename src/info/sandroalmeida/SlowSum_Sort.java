package info.sandroalmeida;

import java.util.Arrays;

public class SlowSum_Sort {

    public static int getTotalTime(int[] arr) {
        if(arr.length == 1) return arr[0];
        Arrays.sort(arr);
        int subtotal = arr[arr.length - 1];
        int total = 0;
        for(int i = arr.length - 2; i >= 0; i--){
            subtotal += arr[i];
            total += subtotal;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr_1 = {4, 2, 1, 3};
        //int expected_1 = 26;
        System.out.println(getTotalTime(arr_1));

        int[] arr_2 = {2, 3, 9, 8, 4};
        //int expected_2 = 88;
        System.out.println(getTotalTime(arr_2));
    }
}
