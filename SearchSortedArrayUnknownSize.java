class Solution {
    public int search(ArrayReader reader, int target) {
        int l=0, r=1;
        while (reader.get(r)<target)
        {
            l = r;
            r=r*2;
        }

        while (l<=r)
        {
            int mid = (l+r)/2;
            if (reader.get(mid) == target)
                return mid;
            if (reader.get(mid) > target)
                r = mid-1;
            else
                l= mid+1;
        }

        return -1;
    }
}
