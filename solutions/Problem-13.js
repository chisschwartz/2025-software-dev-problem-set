// Valid Parentheses - Easy Stack //

// Brute Force //

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {

    while (s.includes("()") || s.includes("{}") || s.includes("[]")) {
        s = s.replace("()", "");
        s = s.replace("{}", "");
        s = s.replace("[]", "");
    }

    return s === "";
};

// Stack //

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {

    const stack = [];
    const closeToOpen = {
        ')': '(',
        '}': '{',
        ']': '['
    };
    //Give our variables in pairs

    for (let c of s) {
        //iterates over the array one by one
        if (closeToOpen[c]) {
            if (stack.length > 0 && stack[stack.length - 1] === closeToOpen[c]) {
                stack.pop();
                //removes the pair from the stack
            } else {
                return false;
            }

        } else {
            stack.push(c);
            //pushes our objects into the array to be removed
        }
    }

    return stack.length === 0;
};