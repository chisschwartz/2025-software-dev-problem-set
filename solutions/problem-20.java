public class problem-20 {

    // Brute Force //

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (matrix[r][c] == target) {
                        return true;
                    }
                }
            }
    
            return false;
        }
    }

    // Binary Search //

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int ROWS = matrix.length;
            //Initailizes our rows variable to the actual length of the matrix
            int COLS = matrix[0].length;
            //Initializes our column variable
    
            int top = 0, bot = ROWS - 1;
            //Initializes the top and bottom pointers for binary search on rows
    
            while (top <= bot) {
                int row = (top + bot) / 2;
                //Calculater the middle row
    
                if (target > matrix[row][COLS - 1]) {
                    top = row + 1;
                    //Moves the pointer down if the target is greater than the last element in the row
                } else if (target < matrix[row][0]){
                    bot = row - 1;
                    //Moves the pointer up if the target is less than the first element in the row
                } else {
                    break;
                }
            }
    
                if (!(top <= bot)) {
                    return false;
                    //Returns false if the target is not within range
                }
    
                int row = (top + bot) / 2;
                //Calculates the middle row
                int l = 0, r = COLS - 1;
                //Intializes the left and right pointers
    
                while (l <= r) {
                    int m = (l + r) / 2;
                    //Calculates the middle column
    
                    if (target > matrix[row][m]) {
                        l = m + 1;
                        //Moves the pointer right if the target is greater than the middle
                    } else if (target < matrix[row][m]) {
                        r = m -1;
                        //Moves the pointer left if the target is less than the middle
                    } else {
                        return true;
                    }
                }
    
            return false;
        }
    }
    
}
