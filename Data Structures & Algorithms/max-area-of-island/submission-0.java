class Solution {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j ++){
                if(grid[i][j] == 1){
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }
    private int dfs(int[][] grid, int i, int j){
        if(i < 0 | j < 0|| i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0; 
        }

        grid[i][j] = 0;
        int res = 1;
        for(int[] dir : directions){
            res += dfs(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }
}
