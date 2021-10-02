package info.sandroalmeida;

import java.util.*;

public class CountingTriangles {

    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int countDistinctTriangles(ArrayList<Sides> arr) {
        Set<Map<Integer, Integer>> set = new HashSet<>();
        int count = 0;
        for(Sides triangle: arr){
            if(!set.contains(createMap(triangle))){
                set.add(createMap(triangle));
                count++;
            }
        }
        return count;
    }

    public static Map<Integer, Integer> createMap(Sides triangle){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(triangle.a, 1);
        map.put(triangle.b, (map.getOrDefault(triangle.b, 0) + 1));
        map.put(triangle.c, (map.getOrDefault(triangle.c, 0) + 1));
        return map;
    }

    public static void main(String[] args) {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        //int expected_1 = 3;
        System.out.println(countDistinctTriangles(arr_1));

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        //int expected_2 = 3;
        System.out.println(countDistinctTriangles(arr_2));
    }
}
