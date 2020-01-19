class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        int l=0,r=nums.length-1;
        Set<String> check = new HashSet<String>();
        for (int i=0; i<nums.length-1; i++)
        {
            l=i+1;
            r=nums.length-1;
            while(l<r)
            {
                int sum = nums[i]+nums[l]+nums[r];
                if (sum == 0)
                {
                    if (!check.contains(String.valueOf(nums[i]) + String.valueOf(nums[l])))
                    {
                       List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        res.add(temp);
                        check.add(String.valueOf(nums[i]) + String.valueOf(nums[l]));
                    }
                    l++;
                    r--;
                }
                else if (sum > 0)
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }
        return res;
    }
}
