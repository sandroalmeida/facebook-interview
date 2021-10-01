package info.sandroalmeida;

// time - O(n²) space O(n)
public class ChangeInAForeignCurrency {

    public static boolean canGetExactChange(int targetMoney, int[] denominations) {
        int biggestDenomination = 0;
        for(int i = denominations.length - 1; i >= 0; i--){
            if(denominations[i] <= targetMoney){
                biggestDenomination = i;
                break;
            }
        }
        for(int i = biggestDenomination; i >= 0; i--){
            if(changeRecursive(targetMoney, denominations, i))
                return true;
        }
        return false;
    }

    public static boolean changeRecursive(int amount, int[] denominations, int index){
        int rest = amount % denominations[index];

        if(index == 0 && rest < denominations[0])
            return false;

        if(rest == 0){
            return true;
        } else{
            return changeRecursive(rest, denominations, index - 1);
        }
    }

    public static void main(String[] args) {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        //boolean expected_1 = false;
        System.out.println(canGetExactChange(target_1, arr_1));

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        //boolean expected_2 = true;
        System.out.println(canGetExactChange(target_2, arr_2));
    }

}
