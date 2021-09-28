package info.sandroalmeida;

// time - O(n²) space O(n)
public class ContiguousSubarrays {

    public static int[] countSubarrays(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            int count = 1;

            int left = i - 1;
            while(left >= 0 && arr[left] <= current){
                count++;
                left--;
            }
            int right = i + 1;
            while(right < arr.length && arr[right] <= current){
                count++;
                right++;
            }
            result[i] = count;
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
