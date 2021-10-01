package info.sandroalmeida;

public class SwappingElements {

    public static int[] findMinArray(int[] arr, int k) {
        int smallest = 0;
        for(int i = 1; i <= k; i++){
            if(arr[i] < arr[smallest])
                smallest = i;
        }

        if(smallest > 0){
            while(smallest > 0){
                swap(arr, smallest, smallest -1);
                smallest--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        //int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        //int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
    }
}
