// Brute Force //

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

         for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                int row = (square / 3) * 3 + i;
                int col = (square % 3) * 3 + j; 
                if (board[row][col] == '.') continue;
                if (seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
                }
            }
        }
        
        return true;
    }
}

// Hash Set (One Pass) //

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        //creates our 3 maps that we need

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                //evaluates a blank and continues

                String squareKey = (r / 3) + "," + (c / 3);
                //divides our 9 squares into essintially 3 subsections

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) || 
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                        //stores all values we have seen before and checks for duplicates
                    }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
                //if no issues adds values into the board
            }
        }

        return true;
    }
}

// Bitmask //

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int val = board[r][c] - '1';

                if ((rows[r] & (1 << val)) > 0 || (cols[c] & ( 1 << val)) > 0 ||
                    (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0 ) {
                        return false;
                    } 

                    rows[r] |= (1 << val);
                    cols[c] |= (1 << val);
                    squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
            }
        }

        return true;
    }
}