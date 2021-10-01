package info.sandroalmeida;

public class EncryptedWords {

    public static String findEncryptedWord(String s) {

        if(s.length() == 0) return "";
        if(s.length() == 1) return s;

        int middle = (s.length() - 1)/ 2;
        String firstSub = s.substring(0, middle);
        String secondSub = "";
        if(middle < s.length() - 1)
            secondSub = s.substring(middle + 1);

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(middle));

        if(firstSub.length() == 1)
            sb.append(firstSub);
        else
            sb.append(findEncryptedWord(firstSub));

        if(secondSub.length() == 1)
            sb.append(secondSub);
        else
            sb.append(findEncryptedWord(secondSub));

        return sb.toString();
    }


    public static void main(String[] args) {
        String s_1 = "abc";
        //String expected_1 = "bac";
        System.out.println(findEncryptedWord(s_1));

        String s_2 = "abcd";
        //String expected_2 = "bacd";
        System.out.println(findEncryptedWord(s_2));
    }
}
