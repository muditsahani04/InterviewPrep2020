class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res=0;

        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length;j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    res++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited)
    {
       if ( i== grid.length || j == grid[0].length || i<0 || j<0 || visited[i][j] == true || grid[i][j] == '0')
           return;

        visited[i][j] = true;
        dfs(i+1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j-1, grid, visited);

    }

}
