package info.sandroalmeida;

import java.util.PriorityQueue;
import java.util.Queue;

// time - O(nlog(n)) space O(n)
public class MedianStream {

    public static int[] findMedian(int[] arr) {

        Queue<Integer> biggersHeap = new PriorityQueue<>((a, b) -> a - b);
        Queue<Integer> smallersHeap = new PriorityQueue<>((a,b) -> b - a);
        int[] result = new int[arr.length];
        smallersHeap.add(arr[0]);
        result[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            int current = arr[i];

            if(i % 2 == 0){
                if(current > smallersHeap.peek()) {
                    biggersHeap.add(current);
                    result[i] = biggersHeap.peek();
                } else {
                    smallersHeap.add(current);
                    result[i] = smallersHeap.peek();
                }

            } else{
                int extraElement;
                if(biggersHeap.size() > smallersHeap.size()){
                    extraElement = biggersHeap.poll();
                } else{
                    extraElement = smallersHeap.poll();
                }
                if(current < extraElement){
                    smallersHeap.add(current);
                    biggersHeap.add(extraElement);
                } else{
                    smallersHeap.add(extraElement);
                    biggersHeap.add(current);
                }
                result[i] = (biggersHeap.peek() + smallersHeap.peek())/2;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr_1 = {5, 15, 1, 3};
        //int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        //int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
    }
}
