class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums[0] == target)
            return 0;
        if (nums[nums.length -1] > nums[0])
            return bSearch (nums,target);
        else
            return bSearchRotated(nums,target);
    }

    private int bSearch (int[] nums, int target)
    {
        int start =0 , end = nums.length-1, mid;
        while (start <= end)
        {
            mid = (start+end)/2;
            if (nums[mid] == target)
                return mid;

            else if (target > nums[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    private int bSearchRotated (int[] nums, int target)
    {
        int start =0 , end = nums.length-1, mid;
        while (start <= end)
        {
            if (nums[start] == target)
                return start;
            if (nums[end] == target)
                return end;
            mid = (start+end)/2;
            if (nums[mid] == target)
                return mid;
            else
            {
                if (nums[mid] > nums[start])
                {
                    if (target > nums[start] && target < nums[mid])
                        end = mid-1;
                    else
                        start = mid+1;
                }
                else
                {
                    if (target > nums[mid] && target < nums[end])
                        start = mid+1;
                    else
                        end = mid-1;
                }

            }
        }
        return -1;
    }
}
