class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max= 0;
        Map<Character, Integer> set = new HashMap<Character,Integer>();
        int i=0, j = 0;
        while ( i<=j && j<s.length())
        {
            char ch = s.charAt(j);
            if (set.containsKey(ch))
            {
                i = Math.max(set.get(ch)+1,i);
            }
            set.put(ch,j);
            max = Math.max(max, j-i+1);
            j++ ;
        }

        return max;
    }
}
