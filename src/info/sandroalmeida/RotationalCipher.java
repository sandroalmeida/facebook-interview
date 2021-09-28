package info.sandroalmeida;

// time - O(n) space O(n)
public class RotationalCipher {

    public static char rotateCharacter(char c, int rotationFactor){
        if(c >= 'A' && c <= 'Z')
            return (char)(((c - 'A' + rotationFactor) % 26) + 'A');
        else if(c >= 'a' && c <= 'z')
            return (char)(((c - 'a' + rotationFactor) % 26) + 'a');
        else if(c >= '0' && c <= '9')
            return (char)(((c - '0' + rotationFactor) % 10) + '0');
        return c;
    }

    public static String rotationalCipher(String input, int rotationFactor) {
        for(int i = 0; i < input.length(); i++){
            char newChar = rotateCharacter(input.charAt(i), rotationFactor);
            if(i == 0)
                input = newChar + input.substring(1);
            else if(i == input.length() - 1)
                input = input.substring(0, i) + newChar;
            else
                input = input.substring(0, i) + newChar + input.substring(i + 1);
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.", 4));
        // Expected - "Epp-gsrzsCw-3-fi:Epivx5."
        System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200));
        // Expected - "stuvRPQrpq-999.@"
    }
}
