class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxIsland = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 1) {

                    int currIsland = dfs(grid, row, col);

                    maxIsland = Math.max(maxIsland, currIsland);
                }
            }
        }

        return maxIsland;
    }


    public int dfs(int[][] grid, int row, int col) {

        if (row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        area += dfs(grid, row - 1, col);
        area += dfs(grid, row + 1, col);
        area += dfs(grid, row, col - 1);
        area += dfs(grid, row, col + 1);

        return area;
    }
}