package info.sandroalmeida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// time - O(n) space O(n)
public class PairSums {

    public static int numberOfWays(int[] arr, int k) {
        Map<Integer, List<Integer>> diffMap = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            int diff = k - arr[i];
            if(diffMap.containsKey(arr[i])){
                List<Integer> list = diffMap.get(arr[i]);
                counter += list.size();
                list.add(i);
            } else{
                diffMap.put(diff, new ArrayList<>(List.of(i)));
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        //int expected_1 = 2;
        System.out.println(numberOfWays(arr_1, k_1));

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        //int expected_2 = 4;
        System.out.println(numberOfWays(arr_2, k_2));
    }
}
