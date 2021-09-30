package info.sandroalmeida;

import java.util.*;

// time - O(n) space O(n)
public class MinimumLengthSubstrings {

    public static int minLengthSubstring(String s, String t) {
        Map<Character, Integer> smallCharMap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(smallCharMap.containsKey(c))
                smallCharMap.put(c, smallCharMap.get(c) + 1);
            else
                smallCharMap.put(c, 1);
        }

        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> bigCharMap = new HashMap<>();
        int minSum = Integer.MAX_VALUE;

        while(right < chars.length){
            char current = chars[right];
            if(smallCharMap.containsKey(current)){
                if(bigCharMap.containsKey(current))
                    bigCharMap.put(current, bigCharMap.get(current) + 1);
                else
                    bigCharMap.put(current, 1);
            }
            while(isMapEqual(smallCharMap, bigCharMap)){
                if(right - left < minSum){
                    minSum = right - left + 1;
                }
                char leftChar = s.charAt(left);
                left++;
                if(bigCharMap.containsKey(leftChar)){
                    bigCharMap.put(leftChar, bigCharMap.get(leftChar) - 1);
                }
            }
            right++;
        }

        if(minSum != Integer.MAX_VALUE)
            return minSum;
        else
            return -1;

    }

    public static boolean isMapEqual(Map<Character, Integer> smallMap, Map<Character, Integer> bigMap){
        for(Map.Entry<Character, Integer> item: smallMap.entrySet()){
            if(!bigMap.containsKey(item.getKey()) || bigMap.getOrDefault(item.getKey(),0) < item.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        System.out.println(expected_1 == output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        System.out.println(expected_2 == output_2);
    }
}
