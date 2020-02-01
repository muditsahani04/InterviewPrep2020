class Solution {
    public int minDistance(String word1, String word2) {
        int c = word1.length();
        int r = word2.length();
        if (r==0 || c==0)
        {
            return r==0?c:r;
        }
        int[][] res = new int[r+1][c+1];

        for (int i=0; i<r+1; i++)
        {
            for (int j=0; j<c+1; j++)
            {
                if (i==0 || j==0)
                {
                    res[i][j] = i==0?j:i;
                }
                else
                {

                    if (word2.charAt(i-1) != word1.charAt(j-1))
                    {
                        res[i][j] = Math.min (Math.min(res[i-1][j], res[i-1][j-1]), res[i][j-1])+1;
                    }
                    else
                    {
                        res[i][j] = res[i-1][j-1];
                    }
                }
            }
        }

        return res[r][c];
    }
}
