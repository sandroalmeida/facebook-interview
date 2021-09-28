package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {

    public static boolean areTheyEqual(int[] array_a, int[] array_b) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: array_a){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i: array_b){
            if(map.containsKey(i)){
                if(map.get(i) > 1){
                    map.put(i, map.get(i) - 1);
                } else{
                    map.remove(i);
                }
            } else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        //boolean expected_1 = true;
        System.out.println(areTheyEqual(array_a_1, array_b_1));

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        //boolean expected_2 = false;
        System.out.println(areTheyEqual(array_a_2, array_b_2));
    }
}
