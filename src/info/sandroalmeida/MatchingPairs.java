package info.sandroalmeida;

import java.util.*;

// time - O(n) space O(n)
public class MatchingPairs {

    public static int matchingPairs(String s, String t) {
        Set<String> unMatched = new HashSet<>();
        Set<Character> matched = new HashSet<>();
        boolean isDup = false;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(i)){
                count++;
                if(matched.contains(s.charAt(i)))
                    isDup = true;
                matched.add(s.charAt(i));
            } else{
                unMatched.add(s.charAt(i) + "" + t.charAt(i));
            }
        }

        if(count == s.length())
            return isDup ? count : count - 2;

        if(count == s.length() - 1){
            String onlyUnMatched = (String) unMatched.toArray()[0];
            if(isDup || matched.contains(onlyUnMatched.charAt(0)) || matched.contains(onlyUnMatched.charAt(1)))
                return count;
            return count - 1;
        }

        for(String um: unMatched){
            if(unMatched.contains(um.charAt(1) + "" + um.charAt(0)))
                return count + 2;
        }

        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(String um: unMatched){
            if(unMatchedS.contains(um.charAt(1)) || unMatchedT.contains(um.charAt(0)))
                return count + 1;
            unMatchedS.add(um.charAt(0));
            unMatchedT.add(um.charAt(1));
        }
        return count;
    }

    public static void main(String[] args) {
        String s_1 = "abcde", t_1 = "adcbe";
        System.out.println(5 == matchingPairs(s_1, t_1));
        String s_2 = "abcd", t_2 = "abcd";
        System.out.println(2 == matchingPairs(s_2, t_2));
        String s_3="aa", t_3="aa";
        System.out.println(2 == matchingPairs(s_3, t_3));
        String s_4="ax", t_4="ay";
        System.out.println(0 == matchingPairs(s_4, t_4));
        String s_5="axb", t_5="ayb";
        System.out.println(1 == matchingPairs(s_5, t_5));
        String s_6="axa", t_6="aya";
        System.out.println(2 == matchingPairs(s_6, t_6));
        String s_7="abx", t_7="abb";
        System.out.println(2 == matchingPairs(s_7, t_7));
        String s_8="abb", t_8="axb";
        System.out.println(2 == matchingPairs(s_8, t_8));
        String s_9="ax", t_9="ya";
        System.out.println(1 == matchingPairs(s_9, t_9));
    }
}
