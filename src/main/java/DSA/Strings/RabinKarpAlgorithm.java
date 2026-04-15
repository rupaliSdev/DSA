package DSA.Strings;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        System.out.println(rabinKarp("ABC", "ABCDABCD"));
    }


    public static int rabinKarp(String pattern, String text) {
        int n = text.length(), m = pattern.length();
        int base = 256;
        int h = 1, mod = (int) 1e9;
        for (int i = 1; i <= m - 1; i++) h = (h * base) % mod;
        int patternHash = 0, windowHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (pattern.charAt(i) + patternHash * base) % mod;
            windowHash = (text.charAt(i) + windowHash * base) % mod;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                int j = 0;
                while (j < m) {
                    if (pattern.charAt(j) != text.charAt(i + j)) {
                        break;
                    }
                    j++;
                }
                if (j == m) return i;
            }
            if (i < n - m) {
                windowHash = (windowHash - text.charAt(i) * h) % mod;
                windowHash = (windowHash * base + text.charAt(i + m)) % mod;
                if (windowHash < 0) windowHash += mod;
            }
        }
        return -1;
    }


}
