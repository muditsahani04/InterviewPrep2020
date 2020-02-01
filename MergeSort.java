class Solution {
    public List<Integer> sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        List<Integer> res = new ArrayList<Integer>();
        for (int num : nums)
            res.add(num);
        return res;
    }

    private void mergeSort(int[] nums, int start, int end)
    {
        int mid = (start+end)/2;
        if (start < end)
        {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums,start,mid,end);
        }
    }
    private void merge(int[] nums, int start, int mid, int end)
    {
        int[] cache = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int index=0;

        while (i<= mid && j<=end)
        {
            if (nums[i] <= nums[j])
            {
                cache[index++] = nums[i++];
            }
            else
            {
                cache[index++] = nums[j++];
            }
        }

        while (i<=mid)
        {
            cache[index++] = nums[i++];
        }
        while (j<=end)
        {
            cache[index++] = nums[j++];
        }

        for (i=0; i<cache.length; i++)
        {
            nums[start+i] = cache[i];
        }
    }
}
