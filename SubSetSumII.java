class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums.length == 1)
            return false;
        for (int n : nums)
            sum+= n;
        if (sum%2 != 0)
            return false;

        sum = sum/2;
        return subsetSum(nums,sum);

    }

    private boolean subsetSum (int[] nums, int target)
    {
        int r = nums.length;
        int c = target+1;

        boolean[][] dp = new boolean[r][c];

        for (int i=0; i<r; i++)
            dp[i][0]=true;

        dp[0][nums[0]]=true;

        for (int i =1; i<r; i++)
        {
            for (int j=1; j<c; j++)
            {
                if (j <nums[i])
                   dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[r-1][c-1];
    }
}
