class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int n : nums)
        {
            if (n <= min)
                min = n;
            else if (n <= secMin)
                secMin = n;
            else
                return true;
        }
        return false;
    }
}
