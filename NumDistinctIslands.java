class Solution {
    ArrayList<Integer> shape;
    public int numDistinctIslands(int[][] grid) {
        int res = 0;
        Set<List<Integer>> shapes = new HashSet<List<Integer>>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length; j++)
            {
               if (grid[i][j] == 1 && !visited[i][j])
               {
                   shape = new ArrayList<Integer>();
                   dfsHelper(grid,i,j,visited,0);
                   if (!shape.isEmpty())
                    shapes.add(shape);
               }
            }
        }

        return shapes.size();
    }

    private void dfsHelper(int[][] grid, int i, int j, boolean[][] visited, int di)
    {
        if (i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j]==true || grid[i][j] == 0)
            return;
        visited[i][j] = true;
        shape.add(di);
        dfsHelper(grid,i+1,j,visited, 1);
        dfsHelper(grid,i,j+1,visited, 2);
        dfsHelper(grid,i-1,j,visited, 3);
        dfsHelper(grid,i,j-1,visited, 4);
        shape.add(0);
     return;
    }
}
