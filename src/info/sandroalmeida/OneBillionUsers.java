package info.sandroalmeida;

public class OneBillionUsers {

    private static double userOnDay(float rate, int day) {
        return Math.pow(rate, day);
    }

    public static int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int start = 1;
        int end = 2_000; // considering this to be the upper_limit; can be discussed with the interviewer
        double target = 1_000_000_000;

        while (start < end) {
            double total = 0;
            int mid = start + (end - start) / 2;

            // calculate mid value
            for (float growthRate : growthRates) {
                total += userOnDay(growthRate, mid);
            }

            if (total == target) {
                return mid;
            }
            if (total > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        //int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);

        float[] test_2 = {1.01f, 1.02f};
        //int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
    }
}
