package info.sandroalmeida;

// time - O(n²) space O(n)
public class RevenueMilestones {

   public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] result = new int[milestones.length];
        int sum = 0;

        for(int i = 0; i < revenues.length; i++){
            sum += revenues[i];
            for(int j = 0; j < milestones.length; j++){
                if(sum >= milestones[j] && result[j] == 0){
                    result[j] = i + 1;
                }
            }
        }

        return result;
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
