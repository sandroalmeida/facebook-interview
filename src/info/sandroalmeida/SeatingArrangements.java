package info.sandroalmeida;

import java.util.*;

public class SeatingArrangements {

    public static int minOverallAwkwardness(int[] arr) {
        Queue<Item> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);
        for(int i = 0; i < arr.length; i++)
            maxHeap.add(new Item(i, arr[i]));

        int[] newArr =  new int[arr.length];

        newArr[arr.length - 1] = maxHeap.poll().value;
        Item secondBiggest = maxHeap.poll();
        newArr[0] = secondBiggest.value;
        Item thirdBiggest = maxHeap.poll();
        newArr[arr.length - 2] = thirdBiggest.value;

        List<Item> list = new ArrayList<>();
        list.add(secondBiggest);
        list.add(thirdBiggest);
        boolean addingRight = true;
        int right = 1;
        int left = arr.length - 3;

        while(!list.isEmpty()){
            Item current = list.get(0);
            list.remove(0);
            if(!maxHeap.isEmpty()){
                Item next = maxHeap.poll();
                list.add(next);
                if(addingRight){
                    newArr[right] = next.value;
                    right++;
                    addingRight = false;
                } else{
                    newArr[left] = next.value;
                    left--;
                    addingRight = true;
                }
            }
        }


        int maxDiff = 0;
        for(int i = 0; i < newArr.length; i++){
            int next = i == newArr.length -1 ? 0 : i + 1;
            int currentDiff = Math.abs(newArr[i] - newArr[next]);
            if(currentDiff > maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }

    static class Item{
        int index;
        int value;

        public Item(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
