class Solution {

    static record XY(int x, int y) {
    };

    public int numIslands(char[][] grid) {
        int visits = 0;
        Set<XY> visited = new HashSet<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new XY(i, j))) {
                    dfs(grid, visited, i, j);
                    visits++;
                }
            }
        }
        return visits;
    }

    void dfs(char[][] grid, Set<XY> visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited.contains(new XY(r, c))) {
            return;
        } //terminal case 

        //grid[r][c] = '0';   // visit by zeroing out so it can't be picked again in for loop
        visited.add(new XY(r, c));

        // recursively traverse to neighbors
        dfs(grid, visited, r-1, c);
        dfs(grid, visited, r+1, c);
        dfs(grid, visited, r, c-1);
        dfs(grid, visited, r, c+1);
    }
}
