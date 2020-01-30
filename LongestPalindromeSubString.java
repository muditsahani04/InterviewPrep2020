class Solution {
    public String longestPalindrome(String s) {
        String res ="";
        if (s.length() == 0 || s.length() == 1)
            return s;
            
        char[] arr = s.toCharArray();
        int max = 0;
        int mid = 0;
        for (int i=0; i<arr.length;i++)
        {
            int len1 = expandAroundCenter(i, i, arr);
            int len2 = expandAroundCenter(i, i+1, arr);
            if (len1 > max || len2 > max)
            {
                mid = i;
                max = Math.max(len1,len2);
            }
            
        }
        
         
        return s.substring(mid- ((max-1)/2), mid+(max/2)+1 );
    }
    
    private int expandAroundCenter(int left, int right, char[] arr)
    {
        int l = left;
        int r = right;
        while (l>=0 && r<arr.length && arr[l] == arr[r])
        {
            l--;r++;
        }
        
        return r-l-1;
    }
}
