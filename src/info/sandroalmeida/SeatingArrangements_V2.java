package info.sandroalmeida;

import java.util.Arrays;

// time - O(n) space O(n)
public class SeatingArrangements_V2 {

    public static int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        int indexResult = 0;
        for(int i = 0; i < arr.length; i += 2){
            result[indexResult] = arr[i];
            indexResult++;
        }

        for(int i = arr.length % 2 == 0 ? arr.length - 1 : arr.length - 2; i > 0; i -= 2){
            result[indexResult] = arr[i];
            indexResult++;
        }

        int maxDiff = 0;
        for(int i = 0; i < result.length; i++){
            int next = i == result.length -1 ? 0 : i + 1;
            int currentDiff = Math.abs(result[i] - result[next]);
            if(currentDiff > maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr_1 = {5, 10, 6, 8};
        //int expected_1 = 4;
        System.out.println(minOverallAwkwardness(arr_1));

        int[] arr_2 = {1, 2, 5, 3, 7};
        //int expected_2 = 4;
        System.out.println(minOverallAwkwardness(arr_2));

        int[] arr_3 = {1, 3, 4, 5, 7, 8, 10};
        //int expected_2 = 3;
        System.out.println(minOverallAwkwardness(arr_3));
    }
}
