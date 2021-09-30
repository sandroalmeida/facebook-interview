package info.sandroalmeida;

import java.util.PriorityQueue;
import java.util.Queue;

// time - O(nlog(n)) space O(n)
public class SlowSum_MaxHeap {

    public static int getTotalTime(int[] arr) {
        if(arr.length == 1) return arr[0];

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int number: arr)
            maxHeap.add(number);

        int total = 0;
        while(!maxHeap.isEmpty()){
            int firstElement = maxHeap.poll();
            int secondElement = maxHeap.poll();
            int penalty = firstElement + secondElement;
            total += penalty;
            if(maxHeap.isEmpty())
                break;
            maxHeap.add(penalty);
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
