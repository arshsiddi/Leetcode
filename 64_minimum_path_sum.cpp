class Solution {
public:
    int helper(vector<vector<int>>&grid , vector<vector<int>>& dp , int row , int col){

        if(row <0 || col<0 || row >= grid.size() || col>=grid[0].size()){
            return 1e9 ;
        }

        if(row == grid.size()-1 && col == grid[0].size()-1){
            return grid[row][col];
        }

        if(dp[row][col] != 1e9){
            return dp[row][col];
        }

        
        int minpath = grid[row][col] +min(helper(grid , dp , row , col+1) , helper(grid , dp , row+1 , col));

        return dp[row][col] = minpath;
    }
    int minPathSum(vector<vector<int>>& grid) {

        vector<vector<int>> dp(grid.size() + 1 , vector<int>(grid[0].size()+1 , 1e9));

        return helper(grid , dp , 0 , 0);
    }
};