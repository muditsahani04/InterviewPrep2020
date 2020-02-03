class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length+1];
        if (s.length() ==0)
            return 0;
        if (arr[0] == '0')
            return 0;

        dp[0] =1;
        dp[1]=1;

        for (int i=2; i<dp.length; i++)
        {
            if (arr[i-1] >'0')
                dp[i] = dp[i-1];
            if (arr[i-2] =='1' || (arr[i-2] =='2' && arr[i-1] < '7') )
                dp[i] += dp[i-2];
        }



    return dp[dp.length-1];
    }
}
