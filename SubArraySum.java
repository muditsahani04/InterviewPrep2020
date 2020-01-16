class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);

        for (int n : nums)
        {
            sum+=n;
            if (map.containsKey(sum-k))
            {
                res += map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0) +1);
        }
        return res;
    }
}
