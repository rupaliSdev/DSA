package DSA.dp;

public class WildCardMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","*"));
    }
    public static boolean isMatch(String s, String p) {

        int n = s.length(),m= p.length();
        boolean[][] dp= new boolean[n+1][m+1];

        dp[0][0]=true;
        for(int i =0;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(i==0){
                    dp[i][j]= p.charAt(j-1)=='*'&& dp[i][j-1];
                }
                else if (p.charAt(j-1)=='?' || s.charAt(i-1)== p.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }
                else if (p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];;
                }
            }
        }
        return dp[n][m];
    }
}
