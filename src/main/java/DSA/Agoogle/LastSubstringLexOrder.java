package DSA.Agoogle;

public class LastSubstringLexOrder {
    //https://leetcode.com/problems/last-substring-in-lexicographical-order/submissions/1994437506/
    public static void main(String[] args) {

        System.out.println(lastSubstring("leetcode"));
    }

    public static String lastSubstring(String s) {

       int n = s.length();
       int i=0,j=1,k=0;

       while (j<n && (i+k)<n && (j+k)<n){
           if(s.charAt(i+k) ==s.charAt(j+k)){
               k++;
           }
           else if(s.charAt(i+k) <s.charAt(j+k)){
               i = Math.max(i+k+1,j);
               j =i+1;
               k=0;
           }
           else{
               j = j+k+1;
               k=0;
           }
       }
       return s.substring(i);
    }
}
