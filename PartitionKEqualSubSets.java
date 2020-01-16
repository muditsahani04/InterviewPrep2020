class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[] used = new boolean[nums.length];
        for (int n : nums)
            sum+=n;
        if (sum%k!= 0)
            return false;
        return helper(k, 0, sum/k, used, nums,0);
    }
    private boolean helper(int k,int currentBucketSum, int targetBucketSum, boolean[] used, int[] nums, int iterationStart)
    {
        if (k == 1)
            return true;
        if (currentBucketSum == targetBucketSum)
            return helper(k-1, 0, targetBucketSum, used, nums,0);

        for (int i=iterationStart; i<nums.length; i++ )
        {
            if (!used[i] && currentBucketSum +nums[i] <= targetBucketSum)
            {
                used[i] = true;
                if (helper(k, currentBucketSum +nums[i], targetBucketSum, used, nums, i+1))
                    return true;
                used[i] = false;
            }
        }

        return false;
    }
}
