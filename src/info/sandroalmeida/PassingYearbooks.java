package info.sandroalmeida;

import java.util.Arrays;

public class PassingYearbooks {

    public static int[] signaturesCounts(int[] arr) {
        int[] res = new int[arr.length];
        // every student signs his own first
        Arrays.fill(res, 1);
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            // until book is back to (i+1)th student
            while (arr[j] != i + 1) {
                // increment result of signatures of (i+1)th student's book
                res[i]++;
                // pass it to the next one
                j = arr[j] - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        int[] result = signaturesCounts(arr);
    }
}
