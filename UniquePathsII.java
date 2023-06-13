/* You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., 
grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move 
either down or right at any point in time. An obstacle and space are marked as 1 or 0 respectively in grid. A path 
that the robot takes cannot include any square that is an obstacle. Return the number of possible unique paths that 
the robot can take to reach the bottom-right corner.*/
import java.util.*;
public class UniquePathsII
{
      public int NumberOfUniquePaths(int grid[][])
      {
            if(grid[0][0] == 1)     return 0;    // If the Obstacle is present at the start node...
            if((grid.length == 1) && (grid[0].length) == 1) return 1;    // If there is only one cell...
            grid[0][0] = 1;      //* Tabulation base case -> O(1)
            for(int i = 1 ; i < grid.length; i++)      //! Dynamic Base Case -> O(N)
            {
                  if(grid[0][i] != 1)     // Checking for the first column...
                        grid[0][i] = 1;
                  else                    // If obstacle is found...
                        grid[0][i] = 0;
            }
            for(int i = 1 ; i < grid[0].length; i++)     //! Dynamic Base Case -> O(M)
            {
                  if(grid[i][0] != 1)      // Checking for the first row...
                        grid[i][0] = 1;
                  else                     // If obstacle is found...
                        grid[i][0] = 0;
            }
            for(int i = 1; i < grid.length; i++)     //! Grid Traversal -> O(N x M)
            {
                  for(int j = 1; j < grid.length; j++)
                  {
                        if(grid[i][j] == 1)     // If obstacle is found, it does not contribute to DP...
                              grid[i][j] = 0;
                        else                    // Current cell count depends upon upper and left cell count...
                              grid[i][j] = grid[i - 1][j] + grid[i][j - 1];    // Evaluating using DP...
                  }
            }
            return grid[grid.length - 1][grid[0].length - 1];    // Returing the value of the bottom right cell...
      }
      public void DisplayGrid(int grid[][])     //! Displaying the Grid -> O(N x M)
      {
            System.out.println("The Grid Formed !! ");
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                        System.out.print(grid[i][j]+", ");
                  System.out.println();
            }
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Ënter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter state of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            UniquePathsII uniquepathsII = new UniquePathsII();     // Object creation...
            uniquepathsII.DisplayGrid(grid);        // Helper function...
            row = uniquepathsII.NumberOfUniquePaths(grid);           // Function Calling...
            uniquepathsII.DisplayGrid(grid);        // Helper function...
            System.out.println("The Unique Possible Ways to Traverse the Grid : "+row);
            sc.close();
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(1)