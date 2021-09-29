package info.sandroalmeida;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestTripleProducts {

    public static int[] findMaxProduct(int[] arr) {

        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        int[] result = new int[arr.length];
        int prod = arr[0];
        minHeap.add(arr[0]);
        result[0] = -1;

        for(int i = 1; i < arr.length; i++){
            minHeap.add(arr[i]);
            prod *= arr[i];
            if(minHeap.size() < 3){
                result[i] = -1;
            } else if(minHeap.size() == 3){
                result[i] = prod;
            } else{
                int removed = minHeap.poll();
                prod = prod / removed;
                result[i] = prod;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 3, 4, 5};
        //int[] expected_1 = {-1, -1, 6, 24, 60};
        int[] output_1 = findMaxProduct(arr_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        //int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        int[] output_2 = findMaxProduct(arr_2);
    }
}
