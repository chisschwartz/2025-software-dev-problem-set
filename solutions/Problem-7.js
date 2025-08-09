// Brute Force //

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    
    for (let row = 0; row < 9; row++) {
        let seen = new Set();
        
        for (let i = 0; i < 9; i++) {
            if (board[row][i] === ".") continue;
            if (seen.has(board[row][i])) return false;
            seen.add(board[row][i]);
        }
    }

    for (let col = 0; col < 9; col++) {
        let seen = new Set();
        
        for (let i = 0; i < 9; i++) {
            if (board[i][col] === ".") continue;
            if (seen.has(board[i][col])) return false;
            seen.add(board[i][col]);
        }
    }

    for (let square = 0; square < 9; square++) {
        let seen = new Set();
        
        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {

                let row = Math.floor(square / 3) * 3 + i;
                let col = (square % 3) * 3 + j;
                
                if (board[row][col] === ".") continue;
                if (seen.has(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }
    }

    return true;
};

// Hash Set (One Pass) //

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {

    const cols = new Map();
    const rows = new Map();
    const squares = new Map();
    //creates our maps

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            if (board[r][c] === ".") continue;
            //evaluates a blank and continues

            const squareKey = `${Math.floor(r / 3)}, ${Math.floor(c / 3)}`;

            if ((rows.get(r) && rows.get(r).has(board[r][c])) ||
                (cols.get(c) && cols.get(c).has(board[r][c])) ||
                (squares.get(squareKey) && squares.get(squareKey).has(board[r][c]))) {
                    return false;
                }

                if (!rows.has(r)) rows.set(r, new Set());
                if (!cols.has(c)) cols.set(c, new Set());
                if (!squares.has(squareKey)) squares.set(squareKey, new Set());
                //if spaces do not contain the numbers, then sets them in the map

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
        }
    }

    return true;
};

// Bitmask //

/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {

    let rows = new Array(9).fill(0);
    let cols = new Array(9).fill(0);
    let squares = new Array(9).fill(0);

    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {

            if (board[r][c] === ".") continue;

            let val = board[r][c] - "1";

            if ((rows[r] & (1 << val)) || (cols[c] & (1 << val)) ||
                (squares[Math.floor(r / 3) * 3 + Math.floor(c / 3)] & (1 << val))) {
                    return false;
                }

                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[Math.floor(r / 3) * 3 + Math.floor(c / 3)] |= (1 << val);
        }
    }

    return true;
};