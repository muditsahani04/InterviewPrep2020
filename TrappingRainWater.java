class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] maxtoRight = new int[size];
        int[] maxtoLeft = new int[size];

        int max = Integer.MIN_VALUE;
        for (int j=size-1; j>=0; j--)
        {
            max = Math.max(height[j],max);
            maxtoRight[j] = max;
        }
        max = Integer.MIN_VALUE;

        for (int i=0; i<size; i++)
        {
            max = Math.max(height[i],max);
            maxtoLeft[i] = max;
        }
        int res = 0;
        for (int i = 0; i<size; i++)
        {
           res += (Math.min(maxtoRight[i],maxtoLeft[i]) - height[i]);
        }

        return res;
    }
}
