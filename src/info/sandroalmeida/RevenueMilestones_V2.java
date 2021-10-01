package info.sandroalmeida;

// time - O(nlog(n)) space O(n)
public class RevenueMilestones_V2 {

   public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] revenues_sums = new int[revenues.length];
        int sum = 0;
        for(int i = 0; i < revenues.length; i++){
            sum += revenues[i];
            revenues_sums[i] = sum;
        }

        int[] result = new int[milestones.length];
        for(int i = 0; i < milestones.length; i++){
            result[i] = search(milestones[i], revenues_sums) + 1;
        }

        return result;
    }

    public static int search(int target, int[] revenues_sums){
       int start = 0;
       int end = revenues_sums.length - 1;

        while(start <= end) {
            int middle = (start + end) / 2;
            int current = revenues_sums[middle];
            if(current > target){
                end = middle - 1;
            } else if(current < target){
                start = middle + 1;
            } else{
                return middle;
            }
       }
       return start;
    }

    public static void main(String[] args) {
        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        //int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        //int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
    }
}
