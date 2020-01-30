class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left =0;
        int right = nums.length -1;
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int start = 0; start<nums.length-2; start++)
        {
            left = start+1;
            right = nums.length -1;
            while (left<right)
            {
                int sum = nums[start]+nums[left]+nums[right];
                if (sum == target)
                    return target;
                int currDist = Math.abs(sum - target);
                if (currDist < minDist)
                {
                    minDist = currDist;
                    map.put(minDist, sum);
                }

                if (sum > target)
                    right -- ;
                else
                    left ++;
            }
        }

        return map.getOrDefault(minDist,-1);
    }
}
