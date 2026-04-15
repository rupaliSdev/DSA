package DSA.Strings;

public class BasicProblems {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String s1 = "abCdEf";
        System.out.println(toogleString(s1));
        // a-z  97 to 122
        // A-Z-> 65 to 90

        System.out.println(sortString("rupalisahu"));
        System.out.println(reverseString(s1));

        System.out.println(reverse("hello please wake me up"));
    }

    private static String toogleString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char) (s.charAt(i) ^ 1 << 5));
        }
        return sb.toString();
    }

    private static String reverse(String st) {
        String[] strings = st.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            builder.append(strings[i]);
            if (i > 0) builder.append(" ");
        }
        return builder.toString();
    }

    private static String reverseString(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i <= j) {
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
            i++;
            j--;
        }
        return new String(ch);
    }

    //given a string which contains only lowercase characters sort the string
    private static String sortString(String s) {
        int[] ch = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < ch[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }


}
