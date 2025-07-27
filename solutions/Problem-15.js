// Brute Force //

/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {

    while (tokens.length > 1) {
        for (let i = 0; i < tokens.length; i++) {
            if ("+-*/".includes(tokens[i])) {
                const a = parseInt(tokens[i - 2]);
                const b = parseInt(tokens[i - 1]);
                let result;

                if (tokens[i] === "+") result = a + b;
                else if (tokens[i] === "-") result = a - b;
                else if (tokens[i] === "*") result = a * b;
                else if (tokens[i] === "/") result = Math.trunc(a / b);

                tokens.splice(i - 2, 3, result.toString());
                break;
            }
        }
    }
    
    return parseInt(tokens[0]);
};

// Recursion //

/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {

    const dfs = () => {
    const token = tokens.pop();
        if (!"+-*/".includes(token)) {
            return parseInt(token);
        }

        const right = dfs();
        const left = dfs();

        if (token === '+') {
            return left + right;
        } else if (token === '-') {
            return left - right;
        } else if (token === '*') {
            return left * right;
        } else {
            return Math.trunc(left / right);
        }
    };

return dfs();
};

// Stack //

/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    const stack = [];
    
       for (const c of tokens) {
           if (c === '+') {
               stack.push(stack.pop() + stack.pop());
           } else if (c === '-') {
               const a = stack.pop();
               const b = stack.pop();
               stack.push(b - a);
           } else if (c === '*') {
               stack.push(stack.pop() * stack.pop());
           } else if (c === '/') {
               const a = stack.pop();
               const b = stack.pop();
               stack.push(Math.trunc(b / a));
           } else {
               stack.push(parseInt(c));
           }
       }
       
   return stack.pop();
};