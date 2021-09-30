package info.sandroalmeida;

import java.util.PriorityQueue;
import java.util.Queue;

// time - O(nlog(n)) + O(klog(k)) space O(n)
public class MagicalCandyBags {

    public static int maxCandies(int[] arr, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i: arr)
            maxHeap.add(i);

        int total = 0;
        while(k > 0){
            int current = maxHeap.poll();
            total += current;
            current = current / 2;
            maxHeap.add(current);
            k--;
        }
        return total;
    }

    public static void main(String[] args) {
        int k_1 = 3;
        int[] arr_1 = {2, 1, 7, 4, 2};
        int expected_1 = 14;
        int output_1 = maxCandies(arr_1, k_1);
        System.out.println(expected_1 == output_1);

        int k_2 = 3;
        int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int expected_2 = 228;
        int output_2 = maxCandies(arr_2, k_2);
        System.out.println(expected_2 == output_2);
    }
}
