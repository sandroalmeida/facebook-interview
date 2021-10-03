package info.sandroalmeida;

import java.util.*;
import java.util.stream.IntStream;

public class MinimizingPermutations {

    int minOperations(int[] arr) {
        int ret = 0;
        int[] target = IntStream.rangeClosed(1, arr.length).toArray();
        Set<String> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);
        seen.add(Arrays.toString(arr));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (Arrays.equals(target, curr)) {
                    return ret;
                }
                for (int j = 0; j < curr.length; j++) {
                    for (int k = j + 1; k < curr.length; k++) {
                        int[] next = curr.clone();
                        reverse(next, j, k);
                        if (!seen.contains(Arrays.toString(next))) {
                            queue.offer(next);
                            seen.add(Arrays.toString(next));
                        }
                    }
                }
            }
            ret++;
        }
        return ret;
    }

    private void reverse(int[] arr, int from, int to) {
        for(; from < to; from++, to--) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

    }
    public static void main(String[] args) {
        new MinimizingPermutations().run();
    }
}
