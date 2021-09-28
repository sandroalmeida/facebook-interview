package info.sandroalmeida;

import java.util.Stack;

// time - O(n) space O(n)
public class ContiguousSubarrays_V2 {

    public static int[] countSubarrays(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.empty() && arr[stack.peek()] < arr[i]){
                result[i] += result[stack.pop()];
            }
            stack.push(i);
            result[i]++;
        }

        stack.clear();
        int[] temp = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                result[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] result = countSubarrays(test_1);
        // int[] expected_1 = {1, 3, 1, 5, 1};
        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] result_2 = countSubarrays(test_2);
        //int[] expected_2 = {1, 2, 6, 1, 3, 1};
    }

}
