class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int area = dfs(i, j, grid, visited);
                maxArea = (area > maxArea)?area:maxArea;
            }
        }

        return maxArea;
    }

    int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (grid[i][j] == 0) return 0;
        if (visited[i][j]) return 0;
        if (grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            int left = (i-1 >= 0)?(dfs(i-1, j, grid, visited)):0;
            int right = (i+1 < grid.length)?(dfs(i+1, j, grid, visited)):0;
            int up = (j-1 >= 0)?(dfs(i, j-1, grid, visited)):0;
            int down = (j+1 < grid[0].length)?(dfs(i, j+1, grid, visited)):0;
            return 1 + left + right + up + down;
        } else return 0;
    }
}
